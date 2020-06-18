package com.laibin.mapper;

import com.laibin.pojo.Blog;
import com.laibin.utils.IDutils;
import com.laibin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setAuthor("阿斯蒂芬");
        blog.setTitle("宇宙学说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("地球学说");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("黑洞学说");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
        hashMap.put("title", "宇宙学说2");

        List<Blog> blogs = mapper.queryBlogIF(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
        hashMap.put("views", "9999");
        //hashMap.put("title", "宇宙学说");

        List<Blog> blogs = mapper.queryBlogChoose(hashMap);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }


        sqlSession.close();
    }
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
        hashMap.put("id", "20516be36d814fc6a0f36b29bb21edcf");
        hashMap.put("title", "宇宙学说2");

        mapper.updateBlog(hashMap);

        sqlSession.close();
    }
}
