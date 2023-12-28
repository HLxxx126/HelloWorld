package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author HLxxx
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptLog {
    private int id;
    private LocalDateTime createTime;
    private String description;
}
