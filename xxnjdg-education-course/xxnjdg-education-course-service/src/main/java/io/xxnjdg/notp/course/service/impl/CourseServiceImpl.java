package io.xxnjdg.notp.course.service.impl;

import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.mapper.CourseMapper;
import io.xxnjdg.notp.course.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程信息 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
