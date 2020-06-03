package io.xxnjdg.notp.course.portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.mapper.CourseMapper;
import io.xxnjdg.notp.course.object.persistent.Course;
import io.xxnjdg.notp.course.portal.service.CoursePortalService;
import org.springframework.stereotype.Service;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 18:03
 */
@Service
public class CoursePortalServiceImpl extends ServiceImpl<CourseMapper, Course> implements CoursePortalService {
}
