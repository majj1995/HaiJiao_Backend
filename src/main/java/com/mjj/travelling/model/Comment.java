package com.mjj.travelling.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    @CreatedDate
    private Timestamp commentTime;

    private Integer likes;

    private String username;

    private Integer replyId;
}
