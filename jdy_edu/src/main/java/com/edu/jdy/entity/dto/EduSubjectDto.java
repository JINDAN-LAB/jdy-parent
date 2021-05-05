package com.edu.jdy.entity.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class EduSubjectDto implements Serializable {


    @ApiModelProperty(value = "讲师")
    private String teacherId;

    @ApiModelProperty(value = "科目")
    private String title;

    @ApiModelProperty(value = "上课时间")
    private String times;

    private String remarks;


    private List<JdyUser> list;

}
