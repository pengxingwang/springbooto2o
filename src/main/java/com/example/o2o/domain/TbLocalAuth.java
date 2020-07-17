package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbLocalAuth {
    private Integer localAuthId;

    private Integer userId;

    private String username;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;
}