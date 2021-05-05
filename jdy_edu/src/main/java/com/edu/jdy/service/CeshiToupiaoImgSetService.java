package com.edu.jdy.service;

import com.edu.jdy.entity.CeshiToupiaoImgSet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2020-09-26
 */
public interface CeshiToupiaoImgSetService extends IService<CeshiToupiaoImgSet> {

    List<CeshiToupiaoImgSet> listindex();
}
