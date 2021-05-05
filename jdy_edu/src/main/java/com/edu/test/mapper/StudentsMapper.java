package com.edu.test.mapper;

import com.edu.test.entity.Students;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kong
 * @since 2021-03-05
 */
@Mapper
public interface StudentsMapper extends BaseMapper<Students> {

}
