package com.wang.service;

import com.wang.entity.Blog;
import com.wang.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Blog saveBlog(Blog blog);
    Blog getBlog(Long id);
    Blog updateBlog(Long id, Blog blog);
    Blog getAndConvert(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery);
    Page<Blog> listSearchBlog(String query, Pageable pageable);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(Long tagId,Pageable pageable);
    Map<String, List<Blog>> archiveBlog();
    Long countBlog();
    List<Blog> listRecommendBlog(Integer size);
    void deleteBlog(Long id);
}
