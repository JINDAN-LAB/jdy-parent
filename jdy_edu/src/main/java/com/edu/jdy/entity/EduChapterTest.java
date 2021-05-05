package com.edu.jdy.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author kong
 * @since 2020-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduChapterTest对象", description="")
public class EduChapterTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "tid", type = IdType.UUID)
    private String tid;
    @ApiModelProperty(value = "标题名字")
    private String tname;
    @ApiModelProperty(value = "选项1")
    private String tan1;
    @ApiModelProperty(value = "选项2")
    private String tan2;
    @ApiModelProperty(value = "选项3")
    private String tan3;
    @ApiModelProperty(value = "选项4")
    private String tan4;
    @ApiModelProperty(value = "选项5")
    private String tan5;
    @ApiModelProperty(value = "选项6")
    private String tan6;
    @ApiModelProperty(value = "选项7")
    private String tan7;
    @ApiModelProperty(value = "答案")
    private String daan;

    @ApiModelProperty(value = "父类ID")
    private String parentId;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(name = "insertTime" , value = "插入时间 不需要填入")
    @TableField(fill = FieldFill.INSERT)
    private Date insertTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(name = "updateTime" , value = "修改日期 不需要填入")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @ApiModelProperty(name = "deleteId" , value = "")
    private Integer deleteId;



}
