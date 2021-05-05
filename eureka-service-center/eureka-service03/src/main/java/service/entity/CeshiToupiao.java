package service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
