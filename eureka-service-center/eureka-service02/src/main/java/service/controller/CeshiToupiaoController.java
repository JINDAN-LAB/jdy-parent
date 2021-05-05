package service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.entity.CeshiToupiao;
import service.service.CeshiToupiaoService;

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
    public String nestedListByCourseId(){

           throw new RuntimeException();
//        List<CeshiToupiao> chapterVoList = chapterService.list(null);
//        System.out.println("===========================");
//        System.out.println(chapterVoList);
//        return  null;
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
