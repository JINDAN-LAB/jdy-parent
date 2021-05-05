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
 * @Description:TODO(人员请假登记实体类)
 * 
 * @version: V1.0
 * @author: kong
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JdyUserLeave extends Model<JdyUserLeave> {

	private static final long serialVersionUID = 1608283684617L;

	@TableId(value = "leave_id", type = IdType.UUID)
	@ApiModelProperty(name = "leaveId" , value = "主键")
	private String leaveId;
    
	@ApiModelProperty(name = "leaveUsername" , value = "请假人")
	private String leaveUsername;
    
	@ApiModelProperty(name = "leaveDepartment" , value = "请假部门")
	private String leaveDepartment;
    
	@ApiModelProperty(name = "leavePost" , value = "请假职务")
	private String leavePost;
    
	@ApiModelProperty(name = "leaveType" , value = "请假类别")
	private String leaveType;
    
	@ApiModelProperty(name = "leaveContent" , value = "请假内容")
	private String leaveContent;
    
	@ApiModelProperty(name = "startTime" , value = "开始时间")
	private String startTime;
    
	@ApiModelProperty(name = "endTime" , value = "结束时间")
	private String endTime;
    
	@ApiModelProperty(name = "leaveStatus" , value = "状态")
	private String leaveStatus;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "deleteId" , value = "")
	private Integer deleteId;
    
	@ApiModelProperty(name = "leaveDay" , value = "请假天数")
	private String leaveDay;
    

}