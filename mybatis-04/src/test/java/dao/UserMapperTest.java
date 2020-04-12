package dao;

import com.lx.utils.MybatisUtils;
import com.lx.dao.UserMapper;
import com.lx.pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.log4j.Logger;

import javax.sound.sampled.Line;
import javax.sound.sampled.SourceDataLine;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        logger.info("测试，进入getUserLike方法成功");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testLog4j(){

        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过java代码层面实现分页
        List<User>  userList = sqlSession.selectList("com.lx.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
