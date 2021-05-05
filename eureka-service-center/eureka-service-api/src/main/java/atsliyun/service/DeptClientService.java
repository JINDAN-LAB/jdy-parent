package atsliyun.service;

import atsliyun.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//import org.springframework.cloud.netflix.feign.FeignClient;


/**
 * 
 * @Description: 修改microservicecloud-api工程，根据已经有的DeptClientService接口
   新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author zzyy
 * @date 2018年4月21日
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{

	@GetMapping(value = "/ceshi-toupiao/index")
	public String get();

//	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
//	public List<Dept> list();
//
//	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
//	public boolean add(Dept dept);
}
