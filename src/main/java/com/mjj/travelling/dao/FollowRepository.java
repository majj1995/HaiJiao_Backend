package com.mjj.travelling.dao;

import com.mjj.travelling.model.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, String> {

    Page<Follow> getByUsername(String username, Pageable pageable);
}
