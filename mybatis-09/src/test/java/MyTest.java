import com.lx.dao.UserMapper;
import com.lx.pojo.User;
import com.lx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.xml.transform.Source;

public class MyTest {


    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUsersById(1);
        System.out.println(user);

//        mapper.updateUser(new User(2,"vb","198"));
        sqlSession.clearCache();//手动清理缓存

        System.out.println("====================");
        User user2 = mapper.queryUsersById(2);
        System.out.println(user2);

        System.out.println(user==user2);

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUsersById(1);
        System.out.println(user);
        sqlSession.close();

        System.out.println("===================");
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUsersById(1);
        System.out.println(user2);

        User user3 = mapper2.queryUsersById(2);
        System.out.println(user2);
        System.out.println(user3);

        User user4 = mapper2.queryUsersById(2);
        System.out.println(user4);

        System.out.println(user==user2);
        sqlSession2.close();
    }
}
