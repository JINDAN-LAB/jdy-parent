package com.edu.jdy.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduSubject;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.entity.FinanceBill;
import com.edu.jdy.entity.dto.SubjectOneVo;
import com.edu.jdy.entity.query.QueryTeacher;
import com.edu.jdy.service.EduSubjectService;
import com.edu.jdy.service.EduTeacherService;
import com.edu.jdy.service.FinanceBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2020-11-27
 */
@Slf4j
@Api(tags="财务发票验证")
@CrossOrigin //跨域
@RestController
@RequestMapping("/finance-bill")
public class FinanceBillController {

    @Autowired
    private FinanceBillService subjectService;

    @ApiOperation(value = "更新发票信息")
    @PostMapping("updatefinanceBill")
    public R updateTeacher(@RequestBody FinanceBill eduTeacher){
        boolean b = subjectService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "根据ID进行查询发票信息")
    @GetMapping("getfinanceBillInfo/{fapiaoId}")
    public R getTeacherInfo(@PathVariable String fapiaoId){
        FinanceBill edut = subjectService.getById(fapiaoId);
        return R.ok().data("eduTeacher",edut);
    }

    @ApiOperation(value = "添加发票信息")
    @PostMapping("addfinanceBill")
    public R addTeacher(@RequestBody FinanceBill eduTeacher){
        int edut = subjectService.getOneFinanceBill(eduTeacher);
        if(edut <= 0){
            boolean save = subjectService.save(eduTeacher);
            if(save){
                return R.ok();
            }
            return R.error();
        }
        return R.error();
    }

    @ApiOperation(value = "分页查询")
    @PostMapping("financeBillList/{page}/{limt}")
    public R getMoreConditionPageList(@PathVariable Long page, @PathVariable Long limt,@RequestBody(required = false) FinanceBill queryTeacher){

        Page<FinanceBill> page1 =new Page<>(page,limt);
        subjectService.pageListCondition(page1,queryTeacher);
        long total = page1.getTotal();// 总记录数
        List<FinanceBill> records = page1.getRecords();//每页的数据信息
        return R.ok().data("total",total).data("items",records);
    }

    @ApiOperation(value = "根据ID删除")
    @DeleteMapping("deleteFapiaoId/{fapiaoId}")
    public R removeById(@ApiParam(name = "fapiaoId", value = "fapiaoId", required = true) @PathVariable String fapiaoId){
        boolean flag = subjectService.removeDeleteById(fapiaoId);
        if(flag){
            return R.ok();
        }else{
            return R.error();
        }
    }

    @ApiOperation(value = "根据发票信息进行校验")
    @PostMapping("getfinanceJiaoyan")
    public R postTeacherInfo(@RequestBody FinanceBill eduTeacher){
        int edut = subjectService.getOneFinanceBill(eduTeacher);
        return R.ok().data("sum",edut);
    }




}

