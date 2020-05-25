package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.service.CourseUserStudyLogAdminService;
import io.xxnjdg.notp.course.mapper.CourseUserStudyLogMapper;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import org.springframework.stereotype.Service;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 4:13
 */
@Service
public class CourseUserStudyLogAdminServiceImpl extends ServiceImpl<CourseUserStudyLogMapper, CourseUserStudyLog> implements CourseUserStudyLogAdminService {
}
