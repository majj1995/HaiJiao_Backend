package com.mjj.travelling.dao;

import com.mjj.travelling.model.PostLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<PostLike, String> {

    Page<PostLike> getByUsername(String username, Pageable pageable);
}
