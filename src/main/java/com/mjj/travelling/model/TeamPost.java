package com.mjj.travelling.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class TeamPost {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String content;

    private Integer teamSize;

    private Integer comments;

    private Integer likes;

    private String leaderUsername;

    private String destination;

    private String returnTime;

    private String leavingTime;

    @CreatedDate
    private Timestamp postTime;

}
