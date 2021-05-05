package com.edu.jdy.controller;


import com.edu.jdy.common.R;
import com.edu.jdy.entity.EduSubject;
import com.edu.jdy.entity.dto.SubjectOneVo;
import com.edu.jdy.service.EduSubjectService;
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
 * 课程科目 前端控制器
 * </p>
 * @author kong
 * @since 2019-12-21
 */
@Slf4j
@Api(description="课程分类管理")
@RestController
@RequestMapping("/eduservice/edu-subject")
@CrossOrigin //跨域
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    @ApiOperation(value = "Excel批量导入")
    @PostMapping("import")
    public R addUser(
            @ApiParam(name = "file", value = "Excel文件", required = true)
            @RequestParam("file") MultipartFile file) throws Exception {

        List<String> msg = subjectService.batchImport(file);
        if(msg.size() == 0){
            return R.ok().message("批量导入成功");
        }else{
            return R.error().message("部分数据导入失败").data("messageList", msg);
        }
    }

    @ApiOperation(value = "嵌套数据列表")
    @GetMapping("/tree")
    public R nestedList(){
        List<SubjectOneVo> subjectNestedVoList = subjectService.nestedList();
        return R.ok().data("items", subjectNestedVoList);
    }

    @ApiOperation(value = "目录模糊查询")
    @PostMapping("singleLikeselete")
    public R nSingleList(@ApiParam(name = "subject", value = "目录信息", required = true)
                         @RequestBody EduSubject subject)   {
        List<EduSubject> subjectNestedVoList = subjectService.nestedSinleLikeList(subject);
        return R.ok().data("items", subjectNestedVoList);
    }

    @ApiOperation(value = "新增一级分类")
    @PostMapping("save-level-one")
    public R saveLevelOne(@ApiParam(name = "subject", value = "课程分类对象", required = true)
                          @RequestBody EduSubject subject){
        boolean result = subjectService.saveLevelOne(subject);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }


    @ApiOperation(value = "修改一级分类")
    @PostMapping("update-level-one")
    public R updateLevelOne(@ApiParam(name = "subject", value = "课程分类对象", required = true)
                          @RequestBody EduSubject subject){
        boolean result = subjectService.updateById(subject);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }


    @ApiOperation(value = "删除一级分类")
    @PostMapping("delete-level-one")
    public R deleteLevelOne(@ApiParam(name = "subject", value = "课程分类对象", required = true)
                            @RequestBody EduSubject subject){
        boolean result = subjectService.removeById(subject);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "新增二级分类")
    @PostMapping("save-level-two")
    public R saveLevelTwo( @ApiParam(name = "subject", value = "课程分类对象", required = true)
                           @RequestBody EduSubject subject){
        boolean result = subjectService.saveLevelTwo(subject);
        if(result){
            return R.ok();
        }else{
            return R.error().message("保存失败");
        }
    }

    @ApiOperation(value = "更新二级分类")
    @PostMapping("update-level-two")
    public R updateLevelTwo( @ApiParam(name = "subject", value = "课程分类对象", required = true)
                             @RequestBody EduSubject subject){
        boolean result = subjectService.updateById(subject);
        if(result){
            return R.ok();
        }else{
            return R.error().message("保存失败");
        }
    }

    @ApiOperation(value = "删除二级分类")
    @PostMapping("delete-level-two")
    public R deleteLevelTwo( @ApiParam(name = "subject", value = "课程分类对象", required = true)
                             @RequestBody EduSubject subject){
        boolean result = subjectService.removeById(subject);
        if(result){
            return R.ok();
        }else{
            return R.error().message("保存失败");
        }
    }


}

