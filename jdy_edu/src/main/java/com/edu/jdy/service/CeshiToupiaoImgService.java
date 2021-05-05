package com.edu.jdy.service;

import com.edu.jdy.entity.CeshiToupiaoImg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2020-09-25
 */
public interface CeshiToupiaoImgService extends IService<CeshiToupiaoImg> {

    List<CeshiToupiaoImg> listindex();
}
