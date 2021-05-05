package com.eureka.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kong
 * @since 2020-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "CESHI_TOUPIAO")
public class CeshiToupiao implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField(value="PHONES")
    private String phones;
    @TableField(value="XUHAO")
    private String xuhao;
    @TableField(value="PIAOREN")
    private String piaoren;
    @TableId(value = "IDSS", type = IdType.ID_WORKER)
    private String idss;

}
