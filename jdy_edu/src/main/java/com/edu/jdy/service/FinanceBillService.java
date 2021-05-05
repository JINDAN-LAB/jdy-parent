package com.edu.jdy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.jdy.entity.EduTeacher;
import com.edu.jdy.entity.FinanceBill;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2020-11-27
 */
public interface FinanceBillService extends IService<FinanceBill> {

      void pageListCondition(Page<FinanceBill> page1, FinanceBill queryTeacher);

      int getOneFinanceBill(FinanceBill eduTeacher);

      boolean removeDeleteById(String fapiaoId);

}
