package com.laibin.mapper;

import com.laibin.pojo.User;
import com.laibin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void test(){
        //第一步：获取SQLSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        logger.info(sqlSession);
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
    public void testLog4j(){

        logger.info("into:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }



}
