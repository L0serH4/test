package dao;

import com.lx.MybatisUtils;
import com.lx.dao.UserMapper;
import com.lx.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> useList = mapper.getUserList();

//        List<User> useList = mapper.getUserLike("x");

        for (User user : useList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
