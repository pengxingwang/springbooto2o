package com.example.o2o.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TbArea {
    private Integer areaId;

    private String areaName;

    private Integer priority;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;
}