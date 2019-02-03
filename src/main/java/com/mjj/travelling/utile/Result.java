package com.mjj.travelling.utile;

import lombok.Data;

@Data
public class Result<T> {

    private T data;

    private String error;

    private int code;


}
