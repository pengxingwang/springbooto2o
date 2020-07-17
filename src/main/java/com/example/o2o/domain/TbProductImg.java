package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbProductImg {
    private Integer productImgId;

    private String imgAddr;

    private String imgDesc;

    private Integer priority;

    private LocalDateTime createTime;

    private Integer productId;
}