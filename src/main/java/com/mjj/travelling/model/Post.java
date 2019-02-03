package com.mjj.travelling.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String title;

    private String content;

    private Integer likes;

    private Integer comments;

    private Timestamp postTime;
}
