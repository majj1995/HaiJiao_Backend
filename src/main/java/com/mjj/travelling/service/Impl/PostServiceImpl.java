package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.PostRepository;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.Reply;
import com.mjj.travelling.service.PostService;
import com.mjj.travelling.service.VO.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReplyServiceImpl replyService;

    private static final Integer PAGE_SIZE = 10;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Integer postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Page<Post> load(Integer page) {
        return load(page, PAGE_SIZE);
    }

    @Override
    public Page<Post> load(Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        PageRequest pageable = PageRequest.of(page, size);
        Page<Post> posts = postRepository.findAll(pageable);
        return posts;
    }

    @Override
    public PostVO loadByPostId(Integer postId, Integer replyPage) {
        Post post = postRepository.findById(postId).orElse(null);
        Page<Reply> replies = replyService.loadByPostId(postId, replyPage);
        PostVO postVO = new PostVO();
        postVO.setPost(post);
        postVO.setReplies(replies);
        return postVO;
    }

    @Override
    public Page<Post> loadByUsername(String username, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        PageRequest pageable = PageRequest.of(page, size);
        Page<Post> posts = postRepository.getByUsername(username, pageable);
        return posts;
    }

    @Override
    public Page<Post> loadByUsername(String username, Integer page) {
        return loadByUsername(username, page, PAGE_SIZE);
    }

    @Override
    public Post incLikesNum(Integer postId) {
        Post post = postRepository.findById(postId).orElse(null);
        post.setLikes(post.getLikes() + 1);
        return save(post);
    }

    @Override
    public Post incCommentsNum(Integer postId) {
        Post post = postRepository.findById(postId).orElse(null);
        post.setComments(post.getComments() + 1);
        return save(post);
    }

    @Override
    public Post decLikesNum(Integer postId) {
        Post post = postRepository.findById(postId).orElse(null);
        post.setLikes(post.getLikes() - 1);
        return save(post);
    }

    @Override
    public Post decCommentsNum(Integer postId) {
        Post post = postRepository.findById(postId).orElse(null);
        post.setComments(post.getComments() - 1);
        return save(post);
    }

    public Post getOne(Integer postId) {
        return postRepository.findById(postId).orElse(null);
    }


}
