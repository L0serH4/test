import lx.dao.UserMapper;
import lx.pojo.User;
import lx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层依靠反射实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);
//        mapper.updateUser(new User(4,"loser","190"));

        sqlSession.close();
    }
      /*
        List<User> users = mapper.getUsers();
        for (User user : users){
            System.out.println(user);
        }
        User userById = mapper.getUserById(1);
        System.out.println("userById");

        mapper.addUser(new User(4,"an","179"));

         */
}
