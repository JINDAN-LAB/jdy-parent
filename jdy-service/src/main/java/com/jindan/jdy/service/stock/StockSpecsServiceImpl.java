package com.jindan.jdy.service.stock;

import com.jindan.jdy.common.pojo.StockSpecs;
import com.jindan.jdy.common.mapper.StockSpecsDao;
import com.jindan.jdy.service.stock.StockSpecsService;
import org.apache.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**   
 * @Description:TODO(货物规格表服务实现)
 *
 * @version: V 1.0
 * @author: xbdyilin
 * 
 */
@Service(version = "${service.version}")
@Component
public class StockSpecsServiceImpl  extends ServiceImpl<StockSpecsDao,StockSpecs> implements StockSpecsService  {
	
}