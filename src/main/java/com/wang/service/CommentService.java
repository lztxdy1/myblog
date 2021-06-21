package com.wang.service;

import com.wang.entity.Comment;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
