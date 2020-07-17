package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbHeadLine {
    private Integer lineId;

    private String lineName;

    private String lineLink;

    private String lineImg;

    private Integer priority;

    private Integer enableStatus;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;
}