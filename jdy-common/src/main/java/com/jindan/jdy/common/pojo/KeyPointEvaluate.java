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
 * @Description:TODO(重点工作评价实体类)
 * 
 * @version: V1.0
 * @author: kong
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KeyPointEvaluate extends Model<KeyPointEvaluate> {

	private static final long serialVersionUID = 1591926146671L;

	@TableId(value = "evid", type = IdType.UUID)
	@ApiModelProperty(name = "evid" , value = "")
	private String evid;
    
	@ApiModelProperty(name = "prointId" , value = "项目ID")
	private String prointId;
    
	@ApiModelProperty(name = "content" , value = "主要内容")
	private String content;
    
	@ApiModelProperty(name = "result" , value = "合格不合格")
	private String result;
    
	@ApiModelProperty(name = "evalresult" , value = "评价结果")
	private String evalresult;

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
    
	@ApiModelProperty(name = "fileUrl" , value = "文件路径")
	private String fileUrl;
    

}