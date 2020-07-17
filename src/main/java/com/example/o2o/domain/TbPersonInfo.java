package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbPersonInfo {
    private Integer userId;

    private String name;

    private String profileImg;

    private String email;

    private String gender;

    /**
    * 0:禁止使用本商城，1:允许使用本商城
    */
    private Integer enableStatus;

    /**
    * 1:顾客，2:店家，3:超级管理员
    */
    private Integer userType;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;
}