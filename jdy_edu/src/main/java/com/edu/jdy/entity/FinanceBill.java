package com.edu.jdy.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

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
 * @since 2020-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FinanceBill对象", description="")
public class FinanceBill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fapiao_id", type = IdType.ID_WORKER_STR)
    private String fapiaoId;

    @ApiModelProperty(value = "发票类型")
    private String fapiaoTypes;

    @ApiModelProperty(value = "发票代码")
    private String fapiaoDaima;

    @ApiModelProperty(value = "发票号")
    private String fapiaoNumers;

    @ApiModelProperty(value = "发票金额")
    private String fapiaoJine;

    @ApiModelProperty(value = "发票日期")
    private String fapiaoRiqi;

    @ApiModelProperty(value = "发票校验码")
    private String fapiaoJiaoyan;

    @ApiModelProperty(value = "发票人")
    private String fapiaoPerson;

    @ApiModelProperty(value = "发票时间")
    private String fapiaoTime;

    @ApiModelProperty(value = "发票状态")
    private String fapiaoStatus;

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
