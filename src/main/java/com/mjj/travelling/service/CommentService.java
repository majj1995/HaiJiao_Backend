package com.mjj.travelling.service;

import com.mjj.travelling.model.Comment;
import org.springframework.data.domain.Page;

public interface CommentService{

    Comment save(Comment comment);

    void delete(Integer commentId);

    Page<Comment> load(Integer page);

    Page<Comment> load(Integer page, Integer size);
}
