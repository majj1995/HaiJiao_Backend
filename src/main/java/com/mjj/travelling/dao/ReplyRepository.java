package com.mjj.travelling.dao;

import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    Page<Reply> getByPostId(Integer postId, Pageable pageable);

    Page<Reply> getByUsername(String username, Pageable pageable);
}
