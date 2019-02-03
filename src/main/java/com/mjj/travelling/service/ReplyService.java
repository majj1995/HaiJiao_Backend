package com.mjj.travelling.service;

import com.mjj.travelling.model.Reply;
import com.mjj.travelling.service.VO.MyReplyVO;
import org.springframework.data.domain.Page;

public interface ReplyService {

    Reply save(Reply reply);

    void delete(Integer replyId);

    Page<Reply> loadByPostId(Integer postId, Integer page);

    Page<Reply> loadByPostId(Integer postId, Integer page, Integer size);

    MyReplyVO loadByUsername(String username, Integer page);

    MyReplyVO loadByUsername(String username, Integer page, Integer size);
}
