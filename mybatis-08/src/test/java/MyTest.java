import com.lx.dao.BlogMapper;
import com.lx.pojo.Blog;
import com.lx.utils.Idutils;
import com.lx.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(Idutils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(Idutils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(Idutils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(Idutils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title","Java如此简单2");
        map.put("author","狂神说");
//        map.put("id","5317aad8d3d64b8a972614d34e21d29d");
//        map.put("views",9999);
//        List<Blog> blogs = mapper.queryBlogIf(map);
//        mapper.updateBlog(map);
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();

    }
}
