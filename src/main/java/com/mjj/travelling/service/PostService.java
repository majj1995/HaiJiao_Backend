package com.mjj.travelling.service;

import com.mjj.travelling.model.Post;
import com.mjj.travelling.service.VO.PostVO;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;

public interface PostService{


    /**
     * @param post 传入保存的帖子
     * @return Post
     * @Author mjj on 2019/1/29 17:05
     * @Description: 增、改帖子内容
     */
    Post save(Post post);


    /**
     * @param postId 需要删除的帖子Id
     * @return
     * @Author mjj on 2019/1/29 17:07
     * @Description: 删除帖子
     */
    void delete(Integer postId);

    Page<Post> load(Integer page);

    /**
     * @param
     * @return Page 返回帖子列表分页后结果
     * @Author mjj on 2019/1/29 17:11
     * @Description:
     */
    Page<Post> load(Integer page, Integer size);

    PostVO loadByPostId(Integer postId, Integer replyPage);

    Page<Post> loadByUsername(String username, Integer page);

    /**
     * @param username 发帖人用户名（唯一）
     * @param page
     * @param size
     * @return Post 帖子内容对象
     * @Author mjj on 2019/1/29 17:09
     * @Description: 传入发帖人的用户名，查询帖子内容，用于查询“我的帖子”
     */
    Page<Post> loadByUsername(String username,Integer page, Integer size);

    /**
     * @param postId
     * @return Post
     * @Author mjj on 2019/1/29 17:31
     * @Description: 增加帖子的点赞数
     */
    Post incLikesNum(Integer postId);

    /**
     * @param postId
     * @return Post
     * @Author mjj on 2019/1/29 17:31
     * @Description: 增加帖子的评论数
     */
    Post incCommentsNum(Integer postId);

    Post decLikesNum(Integer postId);

    Post decCommentsNum(Integer postId);


}
