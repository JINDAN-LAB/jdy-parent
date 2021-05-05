package com.jindan.jdy.service.sys;

import com.jindan.jdy.common.pojo.JdyDomain;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**   
 * @Description:TODO(自定义验证二维码域名目录服务层)
 * @version: V1.0
 * @author: kong
 * 
 */
public interface JdyDomainService extends IService<JdyDomain> {

    boolean saveJdyDomain(JdyDomain jdyDomain);

    List<JdyDomain> seletelist(Object o);
}