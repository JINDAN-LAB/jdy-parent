package com.jindan.jdy.controller.purchase;

import com.jindan.jdy.common.dto.JdyPutTypeDto;
import com.jindan.jdy.common.pojo.JdyPutCheckDetails;
import com.jindan.jdy.common.pojo.JdyPutType;
import com.jindan.jdy.service.purchase.JdyPutCheckDetailsService;
import com.jindan.jdy.common.utils.api.ResultVo;
import com.jindan.jdy.service.purchase.JdyPutCheckService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

/**
*
* <p>说明： 风险控制任务超期API接口层</P>
* @version: V1.0
* @author: kong
* @time    2020年12月29日
*
*/
@Api(tags = "仓库盘点")
@RestController
@RequestMapping("/jdyPutCheckDetails")
public class JdyPutCheckDetailsController{

    @Reference(version = "${service.version}", check = false)
    JdyPutCheckDetailsService jdyPutService;

    @ApiOperation(value = "风险控制任务超期查询", notes = "参数:风险控制任务超期信息")
    @PostMapping("/seleteJdyPurchase")
    public ResultVo seleteDepartment(@ApiParam(name = "jdyPurchaseDto", required = false)
                                     @RequestBody JdyPutCheckDetails jdyPurchaseDto){
        List<JdyPutCheckDetails> list = jdyPutService.seletelist(jdyPurchaseDto);
        return ResultVo.success(list);
    }


    @ApiOperation("更新风险控制任务超期")
    @PostMapping("updatejdyPurchase")
    public ResultVo updatejdyPurchase(@ApiParam(name = "jdyPurchase", required = true)
                                      @RequestBody JdyPutCheckDetails JdyPut){
        boolean save = jdyPutService.updateById(JdyPut);
        if(save){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }


    @ApiOperation("新增风险控制任务超期")
    @PostMapping("addJdyPurchase")
    public ResultVo addsubset(@ApiParam(name = "jdyPurchaseDto", required = true)
                              @RequestBody JdyPutCheckDetails  jdyPurchaseDto){
        boolean save1 = jdyPutService.insertSave(jdyPurchaseDto);
        if(save1){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }


    @ApiOperation("删除风险控制任务超期")
    @DeleteMapping("deleteJdyCommodity/{commodityId}")
    public ResultVo deletejdyCommodity(@ApiParam(name = "commodityId", value = "删除ID", required = true) @PathVariable String  commodityId){
        boolean remove = jdyPutService.removeById(commodityId);
        if(remove){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }



}