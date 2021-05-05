package com.edu.jdy.mapper;

import com.edu.jdy.entity.CeshiToupiao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kong
 * @since 2020-09-23
 */
@Mapper
public interface CeshiToupiaoMapper extends BaseMapper<CeshiToupiao> {

    List<CeshiToupiao> seletelist();
}
