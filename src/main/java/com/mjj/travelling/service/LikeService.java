package com.mjj.travelling.service;

import com.mjj.travelling.model.PostLike;
import com.mjj.travelling.service.VO.MyLikeVO;

public interface LikeService {

    PostLike save(PostLike postLike);

    void delete(String username, Integer postId);

    MyLikeVO loadByUsername(String username, Integer page);

    MyLikeVO loadByUsername(String username, Integer page, Integer size);
}
