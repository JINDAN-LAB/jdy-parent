package com.edu.jdy.service.impl;

import com.edu.jdy.entity.CeshiToupiaoImg;
import com.edu.jdy.mapper.CeshiToupiaoImgMapper;
import com.edu.jdy.service.CeshiToupiaoImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2020-09-25
 */
@Service
public class CeshiToupiaoImgServiceImpl extends ServiceImpl<CeshiToupiaoImgMapper, CeshiToupiaoImg> implements CeshiToupiaoImgService {

    @Autowired
    CeshiToupiaoImgMapper ceshiToupiaoImgMapper;


    @Override
    public List<CeshiToupiaoImg> listindex() {
        return ceshiToupiaoImgMapper.selectList(null);
    }


}
