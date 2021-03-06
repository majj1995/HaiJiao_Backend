package com.mjj.travelling.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PostLike {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private Integer postId;
}
