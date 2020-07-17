package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbWechatAuth {
    private Integer wechatAuthId;

    private Integer userId;

    private String openId;

    private LocalDateTime createTime;
}