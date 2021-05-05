package com.edu.jdy.entity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubjectOneVo {

    private String id;
    private String title;
    private String sort;
    private List<SubjectTwoVo> children = new ArrayList<>();
}
