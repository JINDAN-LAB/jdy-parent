package com.jindan.jdy.controller.waimao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jindan.jdy.common.dto.WaimaoFahuoDto;
import com.jindan.jdy.common.pojo.WaimaoArea;
import com.jindan.jdy.common.pojo.WaimaoFahuo;
import com.jindan.jdy.controller.utils.WorkbookUtils;
import com.jindan.jdy.service.waimao.WaimaoAreaService;
import com.jindan.jdy.common.utils.api.ResultVo;
import com.jindan.jdy.service.waimao.WaimaoFahuoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
*
* <p>说明： 设备维修申报API接口层</P>
* @version: V1.0
* @author: kong
* @time    2020年5月28日
*
*/

@CrossOrigin(origins = "http://118.24.255.51:20201")
@Api(tags = "外贸地区分类")
@RestController
@RequestMapping("/waimaoArea")
public class WaimaoAreaController{

    @Reference(version = "${service.version}", check = false)
    WaimaoAreaService waimaoAreaService;

    @ApiOperation(value = "地区分类导入", notes = "参数:地区分类导入")
    @PostMapping("addexclewaimaoArea")
    public ResultVo addfahuo(@RequestParam("file") MultipartFile file) throws Exception {
        //创建Excel工作薄
        Workbook work = WorkbookUtils.getWorkbook(file.getInputStream(),file.getOriginalFilename());
        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        System.out.println("work.getNumberOfSheets();"+ work.getNumberOfSheets());
        Sheet sheet  = work.getSheetAt(0);
        if(sheet==null){
            throw new Exception("创建Excel工作薄为空！");
        }
        List<WaimaoArea> jijiabiaos = new ArrayList<>();
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if(row==null||row.getFirstCellNum()==j){continue;}
            WaimaoArea jijiabiao = new WaimaoArea();
            jijiabiao.setRegions(row.getCell(0).getStringCellValue());
            jijiabiao.setDestinations(row.getCell(1).getStringCellValue());
            jijiabiao.setProducts((row.getCell(2).getStringCellValue()));
            jijiabiaos.add(jijiabiao);
        }
        waimaoAreaService.saveBatch(jijiabiaos);
        return ResultVo.success();
    }

    @ApiOperation(value = "查询外贸地区分类信息", notes = "参数:查询外贸地区分类信息")
    @PostMapping("/seleteWaimaoArea")
    public ResultVo seleteWaimaoFahuo(@ApiParam(value = "jdyRole", required = false)
                                      @RequestBody WaimaoArea jdyRole){
        List<WaimaoArea> list = waimaoAreaService.seletelist(jdyRole);
        return  ResultVo.success(list);
    }


    @ApiOperation("更新地区分类信息")
    @PostMapping("/updateWaimaoArea")
    public ResultVo updatefacility(@ApiParam(value = "jdyRole", required = true)
                                   @RequestBody WaimaoArea jdyRole){
        boolean b = waimaoAreaService.updateById(jdyRole);
        if(b){
            return ResultVo.success(jdyRole);
        }
        return ResultVo.failed();
    }

    @ApiOperation("新增外贸地区分类信息")
    @PostMapping("/addWaimaoArea")
    public ResultVo addWaimaoFahuo( @ApiParam(name = "jdyRole", required = true)
                                    @RequestBody WaimaoArea jdyRole){
        System.out.println("---------------");
        System.out.println(jdyRole);
        boolean save = waimaoAreaService.save(jdyRole);
        if(save){
            return ResultVo.success(jdyRole);
        }
        return ResultVo.failed();
    }

    @ApiOperation("删除外贸地区分类信息")
    @DeleteMapping("/deleteWaimaoA/{seid}")
    public ResultVo deleteTichengXishu(@ApiParam(value = "seid", name = "seid", required = true) @PathVariable String  seid){
        System.out.println("jindanshanchu huikaun xishu");
        System.out.println(seid);
        boolean b = waimaoAreaService.removeById(seid);
        if(b){
            return ResultVo.success();
        }
        return ResultVo.failed();
    }

}