package com.jindan.jdy.common.pojo;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**   
 * @Description:TODO(资产子标题分类实体类)
 * 
 * @version: V1.0
 * @author: kong
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StarchOrganizationPutSubtype extends Model<StarchOrganizationPutSubtype> {

	private static final long serialVersionUID = 1601771515402L;

	@TableId(value = "tid", type = IdType.UUID)
	@ApiModelProperty(name = "tid" , value = "")
	private String tid;
    
	@ApiModelProperty(name = "names" , value = "")
	private String names;
    
	@ApiModelProperty(name = "parentId" , value = "")
	private String parentId;

	@JsonIgnore
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "insertTime" , value = "插入时间  不要设置")
	@TableField(fill = FieldFill.INSERT)
	private Date insertTime;

	@JsonIgnore
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "updateTime" , value = "更新时间 不需要设置")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
	@JsonIgnore
	@TableLogic
	@ApiModelProperty(name = "deleteId" , value = "")
	private Integer deleteId;



}