package com.mjj.travelling.service;

import com.mjj.travelling.model.Favorite;
import com.mjj.travelling.service.VO.MyFavoriteVO;
import org.springframework.data.domain.Page;

public interface FavoriteService {

    Favorite save(String username, Integer postId);

    void delete(String username, Integer postId);

    MyFavoriteVO loadByUsername(String username, Integer page);

    MyFavoriteVO loadByUsername(String username, Integer page, Integer size);

}
