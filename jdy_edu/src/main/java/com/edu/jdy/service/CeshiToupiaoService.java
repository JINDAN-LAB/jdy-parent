package com.edu.jdy.service;

import com.edu.jdy.entity.CeshiToupiao;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2020-09-23
 */
public interface CeshiToupiaoService extends IService<CeshiToupiao> {

    List<CeshiToupiao> seletelist();

    List<CeshiToupiao> seleteAllList(CeshiToupiao chapter);
}
