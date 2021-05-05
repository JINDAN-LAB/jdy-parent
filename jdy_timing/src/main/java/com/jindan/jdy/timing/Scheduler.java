package com.jindan.jdy.timing;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jindan.jdy.common.dto.JdyAppletFoodSafetyProblemsReultDto;
import com.jindan.jdy.common.dto.JdyClassroomDto;
import com.jindan.jdy.common.pojo.*;
import com.jindan.jdy.service.foodsafety.JdyAppletFoodSafetyProblemsReultService;
import com.jindan.jdy.service.foodsafety.JdyAppletFoodSafetyProblemsService;
import com.jindan.jdy.service.foodsafety.JdyAppletFootSafetyPersonService;
import com.jindan.jdy.service.sys.JdyClassroomService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@EnableScheduling
public class Scheduler{

        @Reference(version = "${service.version}", check = false)
        JdyAppletFoodSafetyProblemsReultService jdyAppletFoodSafetyProblemsReultService;

        @Reference(version = "${service.version}", check = false)
        JdyAppletFootSafetyPersonService jdyAppletFootSafetyPersonService;

        @Reference(version = "${service.version}", check = false)
        JdyClassroomService jdyClassroomService;

        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        @Scheduled(cron = "0 05 03 ? * *")
        public void testTasks1(){
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
                String str = sdf.format(d);
                JdyClassroomDto jdyClassroomDto =new JdyClassroomDto();
                jdyClassroomDto.setEndtime(str+"点");
                List<JdyClassroom> seletelist = jdyClassroomService.seleteAlllist(jdyClassroomDto);
                List<String> lis =new ArrayList<>();
                for (int i =0;i< seletelist.size();i++){
                        lis.add(seletelist.get(i).getId());
                }
                if(lis.size() > 0){
                        boolean b = jdyClassroomService.removeByIds(lis);
                }
        }



        @Scheduled(cron = "0 05 05 ? * *")
        public void testTas1() {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
                String str = sdf.format(d);
                List<JdyAppletFoodSafetyProblemsReult> seletelist =  jdyAppletFoodSafetyProblemsReultService.seleteProList();
        }


    @Scheduled(cron = "0 05 03 ? * *")
    public void testAppletFlldSalety() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        String str = sdf.format(d);
        JdyClassroomDto jdyClassroomDto =new JdyClassroomDto();
        jdyClassroomDto.setEndtime(str+"点");
        List<JdyClassroom> seletelist = jdyClassroomService.seleteAlllist(jdyClassroomDto);
        List<String> lis =new ArrayList<>();
        for (int i =0;i< seletelist.size();i++){
            lis.add(seletelist.get(i).getId());
        }
        if(lis.size() > 0){
            boolean b = jdyClassroomService.removeByIds(lis);
        }
    }

}