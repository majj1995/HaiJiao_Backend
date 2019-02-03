package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.CommentRepository;
import com.mjj.travelling.model.Comment;
import com.mjj.travelling.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    private final static Integer PAGE_SIZE = 10;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public Page<Comment> load(Integer page) {
        return load(page, PAGE_SIZE);
    }

    @Override
    public Page<Comment> load(Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Comment> comments = commentRepository.findAll(pageable);
        return comments;
    }
}
