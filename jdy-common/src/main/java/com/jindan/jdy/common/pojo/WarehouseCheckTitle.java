package com.jindan.jdy.common.pojo;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:TODO(规则实体类)
 * 
 * @version: V1.0
 * @author: kong
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseCheckTitle extends Model<WarehouseCheckTitle> {

	private static final long serialVersionUID = 1589448305130L;

	@TableId(value = "check_id", type = IdType.UUID)
	@ApiModelProperty(name = "checkId" , value = "")
	private String checkId;
    
	@ApiModelProperty(name = "parentId" , value = "被盘点的ID")
	private String parentId;
    
	@ApiModelProperty(name = "checkNum" , value = "盘点数量")
	private Integer checkNum;

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
    
	@ApiModelProperty(name = "remarks" , value = "备注")
	private String remarks;
    
	@ApiModelProperty(name = "checkTime" , value = "盘点时间")
	private String checkTime;
    
	@ApiModelProperty(name = "checkPersons" , value = "")
	private String checkPersons;
    
	@ApiModelProperty(name = "checkUuid" , value = "")
	private String checkUuid;
    

}