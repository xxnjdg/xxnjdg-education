package io.xxnjdg.notp.course.service.impl;

import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.mapper.CourseAuditMapper;
import io.xxnjdg.notp.course.service.CourseAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程信息-审核 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseAuditServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements CourseAuditService {

}
