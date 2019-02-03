package com.mjj.travelling.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
public class Reply {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    @CreatedDate
    private Timestamp replyTime;

    private Integer postId;

    private Integer likes;

    private Integer comments;

    private String username;
}
