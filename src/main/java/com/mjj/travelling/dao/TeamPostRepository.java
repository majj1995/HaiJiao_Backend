package com.mjj.travelling.dao;

import com.mjj.travelling.model.TeamPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamPostRepository extends JpaRepository<TeamPost, Integer> {
}
