package com.eureka.service.controller;


import com.eureka.service.entity.CeshiToupiao;
import com.eureka.service.service.CeshiToupiaoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2020-10-24
 */
@RestController
@RequestMapping("/ceshi-toupiao")
public class CeshiToupiaoController {

    @Autowired
    DiscoveryClient client;

    @Autowired
    private CeshiToupiaoService chapterService;


    @GetMapping("/index")
    @HystrixCommand(fallbackMethod = "index123")
    public String nestedListByCourseId(){
        List<CeshiToupiao> chapterVoList = chapterService.list(null);
        System.out.println("===========================");
        System.out.println(chapterVoList);
        return  chapterVoList.toString();
    }

    public String index123(){
        return "rognduanl";
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }




}
