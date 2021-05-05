package com.edu.jdy.entity.query;


import lombok.Data;

@Data
public class QueryTeacher {

    private String name;
    private String level;
    private String begin;// 开始时间
    private String end; // 结束时间

}
