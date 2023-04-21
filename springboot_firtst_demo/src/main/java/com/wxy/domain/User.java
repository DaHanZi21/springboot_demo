package com.wxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String type;
    private String name;
    private String description;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
