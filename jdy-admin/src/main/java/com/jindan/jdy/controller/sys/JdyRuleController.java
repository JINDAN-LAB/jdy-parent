package com.jindan.jdy.controller.sys;

import com.jindan.jdy.common.pojo.JdyDomain;
import com.jindan.jdy.common.pojo.JdyRule;
import com.jindan.jdy.common.pojo.JdySupplier;
import com.jindan.jdy.service.sys.JdyDomainService;
import com.jindan.jdy.service.sys.JdyRuleService;
import com.jindan.jdy.common.utils.api.ResultVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

/**
*
* <p>说明： 规则API接口层</P>
* @version: V1.0
* @author: kong
* @time    2020年4月20日
*
*/
@CrossOrigin(origins = "http://118.24.255.51:20201")
@Api(tags = "规则")
@RestController
@RequestMapping("/jdyRule")
public class JdyRuleController{

    @Reference(version = "${service.version}", check = false)
    JdyRuleService JdyRuleService;

    @ApiOperation(value = "域名管理", notes = "参数:域名信息")
    @PostMapping("/seleteJdyRule")
    public ResultVo seletejdyClassroom(@ApiParam(value = "jdyDomain", required = false)
                                       @RequestBody JdyRule jdyDomain){
        List<JdyRule> list = JdyRuleService.seletelist(jdyDomain);
        return  ResultVo.success(list);
    }

    @ApiOperation("更新域名信息")
    @PostMapping("/updateJdyRule")
    public ResultVo updatejdyClassroom(@ApiParam(value = "jdyDomain", required = true)
                                       @RequestBody JdyRule jdyDomain){
        boolean b = JdyRuleService.updateById(jdyDomain);
        if(b){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }

    @ApiOperation("新增供应商信息")
    @PostMapping("addJdySupplier")
    public ResultVo addJdySupplier( @ApiParam(name = "jdySupplier", required = true)
                                    @RequestBody JdyRule jdySupplier){
        boolean save = JdyRuleService.save(jdySupplier);
        if(save){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }

    @ApiOperation("域名信息")
    @DeleteMapping("/deleteJdyJdyRule/{id}")
    public ResultVo deletejdyClassroom(@ApiParam(value = "id", name = "ID", required = true) @PathVariable String  id){
        boolean b = JdyRuleService.removeById(id);
        if(b){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }



}