package com.edu.jdy.controller;


import com.edu.jdy.common.R;
import com.edu.jdy.entity.CeshiToupiao;
import com.edu.jdy.entity.CeshiToupiaoImg;
import com.edu.jdy.entity.EduChapter;
import com.edu.jdy.entity.EduChapterTestResult;
import com.edu.jdy.entity.dto.ChapterVo;
import com.edu.jdy.service.CeshiToupiaoImgService;
import com.edu.jdy.service.CeshiToupiaoService;
import com.edu.jdy.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kong
 * @since 2020-09-23
 */
@Slf4j
@Api(description="测试投票")
@CrossOrigin //跨域
@RestController
@RequestMapping("/ceshi-toupiao")
public class CeshiToupiaoController {

    @Autowired
    private CeshiToupiaoService chapterService;

    @Autowired
    private CeshiToupiaoImgService ceshiToupiaoImgService;

    @ApiOperation(value = "查询投票已投票个数")
    @PostMapping("/chaxunList")
    public R chaxunList(
            @ApiParam(name = "chapterVo", value = "查询", required = true)
            @RequestBody CeshiToupiao chapter){
        List<CeshiToupiao> list = chapterService.seleteAllList(chapter);
        List<CeshiToupiaoImg> listindex = ceshiToupiaoImgService.listindex();
        for (int i = 0; i <listindex.size() ; i++) {
            for (int j = 0; j <list.size() ; j++) {
                if(listindex.get(i).getXuhao().equals(list.get(j).getXuhao())){
                    listindex.get(i).setTimes("true");
              }
            }
        }
        return R.ok().data("data",listindex);
    }


    @ApiOperation(value = "新增章节")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "chapterVo", value = "章节对象", required = true)
            @RequestBody CeshiToupiao chapter){
        boolean save = chapterService.save(chapter);
        if(save){
            return R.ok();
        }
        return R.error();
    }




    @ApiOperation(value = "根据ID删除章节")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "章节ID", required = true)
            @PathVariable String id){
        boolean result = chapterService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }


    @ApiOperation(value = "修改测试问题")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody CeshiToupiao eduTeacher){
        boolean b = chapterService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "查询")
    @PostMapping
    public R chaxun(
            @ApiParam(name = "chapterVo", value = "查询", required = true)
            @RequestBody CeshiToupiao chapter){
        List<CeshiToupiao> list = chapterService.seleteAllList(chapter);
        return R.ok().data("data",list);
    }

    @ApiOperation(value = "汇总查询")
    @GetMapping
    public R chaxuhuizong(){
        List<CeshiToupiao> list = chapterService.seletelist();
        return R.ok().data("data",list);
    }




}

