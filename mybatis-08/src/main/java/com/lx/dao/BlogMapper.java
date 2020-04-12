package com.lx.dao;

import com.lx.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    //更新一个博客
    int updateBlog(Map map);

    //查询1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map map);

}
