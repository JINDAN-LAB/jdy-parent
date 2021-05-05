package com.edu.jdy.service.impl;
import com.edu.jdy.entity.CeshiToupiaoImgSet;
import com.edu.jdy.mapper.CeshiToupiaoImgSetMapper;
import com.edu.jdy.service.CeshiToupiaoImgSetService;
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
 * @since 2020-09-26
 */
@Service
public class CeshiToupiaoImgSetServiceImpl extends ServiceImpl<CeshiToupiaoImgSetMapper, CeshiToupiaoImgSet> implements CeshiToupiaoImgSetService {

    @Autowired
    CeshiToupiaoImgSetMapper ceshiToupiaoImgSetMapper;

    @Override
    public List<CeshiToupiaoImgSet> listindex() {
        return ceshiToupiaoImgSetMapper.selectList(null);
    }


}
