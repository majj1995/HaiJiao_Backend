package com.mjj.travelling.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*不是数据库表*/

@Data
@NoArgsConstructor
public class MyReply {

    private Reply reply;

    private String title;
}
