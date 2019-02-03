package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.FavoriteRepository;
import com.mjj.travelling.model.Favorite;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.User;
import com.mjj.travelling.service.FavoriteService;
import com.mjj.travelling.service.VO.MyFavoriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostServiceImpl postService;

    private final static Integer PAGE_SIZE = 10;

    @Override
    public Favorite save(String username, Integer postId) {
        Favorite favorite = new Favorite();
        favorite.setPostId(postId);
        favorite.setUsername(username);
        userService.incMyFavorite(username);
        return favoriteRepository.save(favorite);
    }

    @Override
    public void delete(String username, Integer postId) {
        Favorite favorite = new Favorite();
        favorite.setUsername(username);
        favorite.setPostId(postId);
        userService.decMyFavorite(username);
        favoriteRepository.delete(favorite);
    }

    @Override
    public MyFavoriteVO loadByUsername(String username, Integer page) {
        return loadByUsername(username, page, PAGE_SIZE);
    }

    @Override
    public MyFavoriteVO loadByUsername(String username, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Favorite> favorites = favoriteRepository.getByUsername(username, pageable);
        List<Post> myLikePosts = new ArrayList<>();
        for (Favorite favorite : favorites) {
            myLikePosts.add(postService.getOne(favorite.getPostId()));
        }
        MyFavoriteVO myFavoriteVO = new MyFavoriteVO();
        myFavoriteVO.setMyFavoritePosts(myLikePosts);
        myFavoriteVO.setFavorites(favorites);
        return myFavoriteVO;
    }
}
