package com.edu.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kong
 * @since 2021-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Addrs对象", description="")
public class Addrs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "add_ids", type = IdType.ID_WORKER_STR)
    private String addIds;

    private String addrs;

    private String phone;

    private Date times;

}
