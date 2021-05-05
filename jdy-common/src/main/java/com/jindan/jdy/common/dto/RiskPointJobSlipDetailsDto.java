package com.jindan.jdy.common.dto;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jindan.jdy.common.pojo.RiskPointContentResult;
import com.jindan.jdy.common.pojo.RiskPointJobSlipDetails;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RiskPointJobSlipDetailsDto implements Serializable {

    private static final long serialVersionUID = 161054619739L;

    @TableId(value = "did", type = IdType.UUID)
    @ApiModelProperty(name = "did", value = "")
    private String did;

    @ApiModelProperty(name = "parentId", value = "")
    private String parentId;

    @ApiModelProperty(name = "xtitle", value = "")
    private String xtitle;

    @ApiModelProperty(name = "dcontent", value = "")
    private String dcontent;

    @ApiModelProperty(name = "status", value = "")
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(name = "insertTime" , value = "")
    @TableField(fill = FieldFill.INSERT)
    private Date insertTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(name = "updateTime" , value = "")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @ApiModelProperty(name = "deleteId" , value = "")
    private Integer deleteId;

    @ApiModelProperty(name = "remarks", value = "")
    private String remarks;

    private List<RiskPointContentResult> resultList;

}