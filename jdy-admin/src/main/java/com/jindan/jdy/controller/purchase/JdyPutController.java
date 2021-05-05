package com.jindan.jdy.controller.purchase;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jindan.jdy.common.dto.JdyPurchaseDto;
import com.jindan.jdy.common.dto.JdyPutDto;
import com.jindan.jdy.common.dto.JdyPutTypeDetails;
import com.jindan.jdy.common.dto.JdyPutTypeDto;
import com.jindan.jdy.common.pojo.JdyCommodity;
import com.jindan.jdy.common.pojo.JdyPurchase;
import com.jindan.jdy.common.pojo.JdyPut;
import com.jindan.jdy.common.pojo.JdyPutType;
import com.jindan.jdy.controller.utils.CommonUtils;
import com.jindan.jdy.service.purchase.JdyPutService;
import com.jindan.jdy.common.utils.api.ResultVo;
import com.jindan.jdy.service.user.JdyUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

/**
*
* <p>说明： API应用KEYAPI接口层</P>
* @version: V1.0
* @author: kong
* @time    2019年10月16日
*
*/
@CrossOrigin(origins = "http://118.24.255.51:20201")
@Api("仓库的信息列表")
@RestController
@RequestMapping("/jdyPut")
public class JdyPutController{

        @Reference(version = "${service.version}", check = false)
        JdyPutService jdyPutService;


        @ApiOperation(value = "采购查询", notes = "参数:采购信息")
        @PostMapping("/seleteJdyPurchase")
        public ResultVo seleteDepartment(@ApiParam(name = "jdyPurchaseDto", required = false)
                                         @RequestBody JdyPutDto jdyPurchaseDto){
            if(jdyPurchaseDto.getCurrentPage() <= 0   || jdyPurchaseDto.getPageSize()  <= 0){
                jdyPurchaseDto.setCurrentPage(1);
            }
            PageHelper.startPage(jdyPurchaseDto.getCurrentPage(), jdyPurchaseDto.getPageSize());
            JdyPut jdyPut =new JdyPut();
            BeanUtils.copyProperties(jdyPurchaseDto,jdyPut);
            List<JdyPut> list = jdyPutService.seletelist(jdyPut);
            PageInfo<JdyPut> pageInfo = new PageInfo(list, 5);
            return ResultVo.success(pageInfo);
        }

        @ApiOperation("更新采购表头信息")
        @PostMapping("updatejdyPurchase")
        public ResultVo updatejdyPurchase(@ApiParam(name = "jdyPurchase", required = true)
                                          @RequestBody JdyPut JdyPut){
            boolean save = jdyPutService.updateById(JdyPut);
            if(save){
                return ResultVo.success();
            }
            return ResultVo.failed();
        }

        @ApiOperation("新增采购信息")
        @PostMapping("addJdyPurchase")
        public ResultVo addsubset(@ApiParam(name = "jdyPurchaseDto", required = true)
                                  @RequestBody JdyPut  jdyPurchaseDto){
            boolean save1 = jdyPutService.insertSave(jdyPurchaseDto);
            if(save1){
                return ResultVo.success();
            }
            return ResultVo.failed();
        }


        @ApiOperation("删除采购商品信息")
        @DeleteMapping("deleteJdyCommodity/{commodityId}")
        public ResultVo deletejdyCommodity(@ApiParam(name = "commodityId", value = "删除ID", required = true) @PathVariable String  commodityId){
            boolean remove = jdyPutService.removeById(commodityId);
            if(remove){
                return ResultVo.success();
            }
            return ResultVo.failed();
        }

//      库存统计信息
        @ApiOperation(value = "库存统计信息", notes = "参数:库存统计信息")
        @GetMapping("/seleteKucun")
        public ResultVo seleteKucun(){
            List<JdyPutTypeDetails> list = jdyPutService.seleteDetailslist(null);
            return ResultVo.success(list);
        }


        



}