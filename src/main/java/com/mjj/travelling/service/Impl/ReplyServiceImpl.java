package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.PostRepository;
import com.mjj.travelling.dao.ReplyRepository;
import com.mjj.travelling.model.MyReply;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.Reply;
import com.mjj.travelling.model.User;
import com.mjj.travelling.service.ReplyService;
import com.mjj.travelling.service.VO.MyReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private UserService userService;

    private final static Integer PAGE_SIZE = 10;

    @Override
    public Reply save(Reply reply) {
        Post post = postRepository.findById(reply.getPostId()).get();
        postService.incCommentsNum(post.getId());
        userService.incMyComment(reply.getUsername());
        return replyRepository.save(reply);
    }

    @Override
    public void delete(Integer replyId) {
        Reply reply = replyRepository.findById(replyId).orElse(null);
        postService.decCommentsNum(reply.getPostId());
        userService.decMycomment(reply.getUsername());
        replyRepository.deleteById(replyId);
    }

    @Override
    public Page<Reply> loadByPostId(Integer postId, Integer page) {
        return loadByPostId(postId, page, PAGE_SIZE);
    }

    @Override
    public Page<Reply> loadByPostId(Integer postId, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        PageRequest pageable = PageRequest.of(page, size);
        Page<Reply> replies = replyRepository.getByPostId(postId, pageable);
        return replies;
    }

    @Override
    public MyReplyVO loadByUsername(String username, Integer page) {
        return loadByUsername(username, page, PAGE_SIZE);
    }

    @Override
    public MyReplyVO loadByUsername(String username, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Reply> replies = replyRepository.getByUsername(username, pageable);
        List<MyReply> myReplies = new ArrayList<>();
        for (Reply reply : replies) {
            MyReply myReply = new MyReply();
            myReply.setReply(reply);
            myReply.setTitle(postService.getOne(reply.getPostId()).getTitle());
            myReplies.add(myReply);
        }
        MyReplyVO myReplyVO = new MyReplyVO();
        myReplyVO.setMyReplies(myReplies);
        myReplyVO.setReplies(replies);
        return myReplyVO;
    }
}
