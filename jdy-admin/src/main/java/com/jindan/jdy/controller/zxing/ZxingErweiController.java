package com.jindan.jdy.controller.zxing;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jindan.jdy.common.dto.ZxingErweiDto;
import com.jindan.jdy.common.pojo.JdyPurchase;
import com.jindan.jdy.common.pojo.UserPermission;
import com.jindan.jdy.common.pojo.ZxingErwei;
import com.jindan.jdy.common.pojo.ZxingErweim;
import com.jindan.jdy.controller.utils.RedisUtil;
import com.jindan.jdy.service.user.UserPermissionService;
import com.jindan.jdy.service.zxing.ZxingErweiService;
import com.jindan.jdy.common.utils.api.ResultVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

/**
*
* <p>说明： 二维码API接口层</P>
* @version: V1.0
* @author: kong
* @time    2020年4月20日
*
*/
@CrossOrigin(origins = "http://118.24.255.51:20201")
@Api(tags = "二维码模板信息")
@RestController
@RequestMapping("/zxingErwei")
public class ZxingErweiController{

    @Autowired
    RedisUtil redisUtil;

    @Reference(version = "${service.version}", check = false)
    ZxingErweiService zxingErweiService;

    @ApiOperation(value = "二维码模板信息", notes = "参数:二维码模板信息")
    @PostMapping("/seleteUserPermission")
    public ResultVo seleteDepartment( @ApiParam(name = "zxingErweiDto", required = false)
                                      @RequestBody ZxingErweiDto zxingErweiDto ){
        Page<ZxingErwei>  list = zxingErweiService.seletelist(zxingErweiDto);
        return  ResultVo.success(list) ;
    }


    @ApiOperation("更新二维码模板信息")
    @PostMapping("updateUserPermission")
    public ResultVo updatefacility(@ApiParam(name = "zxingErwei", required = true)
                                   @RequestBody ZxingErwei  zxingErwei ){
        boolean b = zxingErweiService.updateById(zxingErwei);
        if(b){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }

    @ApiOperation("新增二维码模板信息")
    @PostMapping("addUserPermission")
    public ResultVo addsubset( @ApiParam(name = "zxingErwei", required = true)
                               @RequestBody ZxingErwei  zxingErwei){
        boolean save = zxingErweiService.save(zxingErwei);
        if(save){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }

    @ApiOperation("删除二维码模板信息")
    @DeleteMapping("deleteUserPermission/{id}")
    public ResultVo deletefacility(@ApiParam(name = "id", value = "权限ID", required = true) @PathVariable String  id){
        boolean b = zxingErweiService.removeById(id);
        if(b){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }

}