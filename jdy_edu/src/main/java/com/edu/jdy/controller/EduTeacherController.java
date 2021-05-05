package com.edu.jdy.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.entity.query.QueryTeacher;
import com.edu.jdy.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@Api(description="讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin  // 解决跨域的问题
public class EduTeacherController {

    @Autowired
     EduTeacherService eduTeacherService;

    @PostMapping("updateTeacher/{id}")
    public R updateTeacher(@PathVariable String id,@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("getTeacherInfo/{id}")
    public R getTeacherInfo(@PathVariable String id){
        EduTeacher edut = eduTeacherService.getById(id);
        return R.ok().data("eduTeacher",edut);
    }

    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if(save){
            return R.ok();
        }
        return R.error();
    }
    @PostMapping("moreConditionPageList/{page}/{limt}")
    public R getMoreConditionPageList(@PathVariable Long page, @PathVariable Long limt,@RequestBody(required = false) QueryTeacher queryTeacher){

        Page<EduTeacher> page1 =new Page<>(page,limt);
        eduTeacherService.pageListCondition(page1,queryTeacher);
        long total = page1.getTotal();// 总记录数
        List<EduTeacher> records = page1.getRecords();//每页的数据信息
        return R.ok().data("total",total).data("items",records);
    }

    @GetMapping("pageList/{page}/{limt}")
    public R getPageTeacherList(@PathVariable Long page,@PathVariable Long limt){
        Page<EduTeacher> page1 =new Page<>(page,limt);
        eduTeacherService.page(page1,null);
        long total = page1.getTotal();// 总记录数
        List<EduTeacher> records = page1.getRecords();//每页的数据信息
        return R.ok().data("total",total).data("items",records);
    }

    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public R getAllTeacherList(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return  R.ok().data("items", list);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id){
        boolean flag =   eduTeacherService.deleteTeacherById(id);
          if(flag){
               return R.ok();
          }else{
              return R.error();
          }
    }

}

