package com.edu.jdy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.jdy.entity.EduCourse;
import com.edu.jdy.entity.EduSubject;
import com.edu.jdy.entity.dto.SubjectOneVo;
import com.edu.jdy.entity.dto.SubjectTwoVo;
import com.edu.jdy.mapper.EduSubjectMapper;
import com.edu.jdy.service.EduSubjectService;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author kong
 * @since 2019-12-21
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Autowired
    EduSubjectMapper eduSubjectMapper;
    

    @Transactional
    @Override
    public List<String> batchImport(MultipartFile file) {
        List<String> msg = new ArrayList<>();
        return msg;
    }

    @Override
    public List<SubjectOneVo> nestedList() {
        System.out.println("----------------------");
        ArrayList<SubjectOneVo> subjectNestedVoArrayList = new ArrayList<>();
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        queryWrapper.orderByAsc("sort", "id");
        List<EduSubject> subjects = eduSubjectMapper.selectList(queryWrapper);
        //获取二级分类数据记录
        QueryWrapper<EduSubject> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.ne("parent_id", 0);
        queryWrapper2.orderByAsc("sort", "id");
        List<EduSubject> subSubjects = eduSubjectMapper.selectList(queryWrapper2);
        //填充一级分类vo数据
        int count = subjects.size();
        for (int i = 0; i < count; i++) {
            EduSubject subject = subjects.get(i);
            //  创建一级类别vo对象
            SubjectOneVo subjectNestedVo = new SubjectOneVo();
            BeanUtils.copyProperties(subject, subjectNestedVo);
            subjectNestedVoArrayList.add(subjectNestedVo);
            //填充二级分类vo数据
            ArrayList<SubjectTwoVo> subjectVoArrayList = new ArrayList<>();
            int count2 = subSubjects.size();
            for (int j = 0; j < count2; j++) {
                EduSubject subSubject = subSubjects.get(j);
                if(subject.getId().equals(subSubject.getParentId())){
                    //创建二级类别vo对象
                    SubjectTwoVo subjectVo = new SubjectTwoVo();
                    BeanUtils.copyProperties(subSubject, subjectVo);
                    subjectVoArrayList.add(subjectVo);
                    System.out.println(subjectVo.toString());
                }
            }
            subjectNestedVo.setChildren(subjectVoArrayList);
        }
        return subjectNestedVoArrayList;
    }

    @Override
    public boolean saveLevelOne(EduSubject subject) {
        EduSubject subjectLevelOne = this.exitsoneSubject(subject.getTitle());
        if(subjectLevelOne == null){
            return super.save(subject);
        }
        return false;
    }



    @Override
    public boolean saveLevelTwo(EduSubject subject) {
        EduSubject subjectLevelTwo = this.exitstwoSubject(subject.getTitle(), subject.getParentId());
        if(subjectLevelTwo == null){
            return this.save(subject);
        }else{
            return false;
        }
    }

    @Override
    public List<EduSubject> nestedSinleLikeList(EduSubject subject) {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("insert_time");
        String title = subject.getTitle();
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title", title);
        }
       return baseMapper.selectList( queryWrapper);
    }

    private EduSubject exitstwoSubject(String name,String parentId){
        QueryWrapper<EduSubject> wrapper =new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",parentId);
        EduSubject eduSubject = baseMapper.selectOne(wrapper);
        return  eduSubject;
    }


 private EduSubject exitsoneSubject(String name){
     QueryWrapper<EduSubject> wrapper =new QueryWrapper<>();
     wrapper.eq("title",name);
     wrapper.eq("parent_id","0");
     EduSubject eduSubject = baseMapper.selectOne(wrapper);
     return  eduSubject;
 }
    

}
