package com.jindan.jdy.service.fileupload;

import com.jindan.jdy.common.pojo.JdyFileUpload;
import com.jindan.jdy.common.mapper.JdyFileUploadMapper;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**   
 * @Description:TODO(API应用KEY服务实现)
 *
 * @version: V1.0
 * @author: kong
 * 
 */
@Service(version = "${service.version}")
@Component
public class JdyFileUploadServiceImpl  extends ServiceImpl<JdyFileUploadMapper,JdyFileUpload> implements JdyFileUploadService  {
	
}