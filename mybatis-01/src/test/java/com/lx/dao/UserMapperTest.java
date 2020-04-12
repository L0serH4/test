package com.lx.dao;

import com.lx.pojo.User;
import com.lx.MybatisUtils;
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

        List<User> useList = mapper.getUserLike("%x%");

//        List<User> useList = mapper.getUserLike("x");

        for (User user : useList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void test(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {

            //方式一：执行SQL getMapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.getUserList();
            //方式二
            //List<User> userList = sqlSession.selectList
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();


        sqlSession.close();
    }


    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(1, "ag", "170"));
        if (res > 0){
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //修改用户
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(4, "ba", "180"));
        if (res > 0){
            System.out.println("修改成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //删除用户
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUser(1);
        if (res > 0){
            System.out.println("删除成功！");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    /*
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userId",5);
        map.put("userName","kl");
        map.put("passWord","178");

        mapper.addUser2(map);
        sqlSession.close();
    }
     */
}
