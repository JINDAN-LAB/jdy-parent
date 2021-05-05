package com.edu.test.service.impl;

import com.edu.test.entity.Students;
import com.edu.test.mapper.StudentsMapper;
import com.edu.test.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2021-03-05
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {

}
