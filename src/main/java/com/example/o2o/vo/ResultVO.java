package com.example.o2o.vo;

import lombok.Data;

@Data
public class ResultVO<T> {
    private String msg;

    private Integer code;

    private T data;
}
