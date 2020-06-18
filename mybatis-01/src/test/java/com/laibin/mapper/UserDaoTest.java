package com.laibin.mapper;

import com.laibin.pojo.User;
import com.laibin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获取SQLSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            //        List<User> userList = sqlSession.selectList("com.laibin.dao.UserDao.getUserList");
            for (User user: userList) {
                System.out.println(user.getId());
                System.out.println(user.getName());
                System.out.println(user.getPwd());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPwd());
        sqlSession.close();
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int res = userDao.addUser(new User(4, "kiukiu", "123456"));

        if (res>0){
            System.out.println("插入成功");
        }
        //增加和修改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void testAdd2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("userId", 5);
        map.put("userName", "heihei");
        map.put("userPwd", 123456);

        int res = userDao.addUser2(map);

        if (res>0){
            System.out.println("插入成功");
        }
        //增加和修改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.updateUser(new User(4, "hiahia", "123456"));

        if (res>0){
            System.out.println("修改成功");
        }
        //增加和修改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.deleteUser(4);
        if (res>0){
            System.out.println("删除成功");
        }
        //增加和修改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userLike = mapper.getUserLike("li%");
        for (User user: userLike) {
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getPwd());
        }
    }

}
