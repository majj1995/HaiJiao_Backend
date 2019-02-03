package com.mjj.travelling.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "username", "phone", "email"})})
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String name;

    private String phone;

    private Integer age;

    private String birthday;

    private String university;

    private Integer myLike;

    private Integer myFavorite;

    private Integer myComment;

    private Integer myFollow;

}
