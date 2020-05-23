package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.convert.CourseIntroduceAuditMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseIntroduceAuditDTO;
import io.xxnjdg.notp.course.admin.object.error.CourseIntroduceAuditEnum;
import io.xxnjdg.notp.course.admin.service.CourseIntroduceAuditAdminService;
import io.xxnjdg.notp.course.mapper.CourseIntroduceAuditMapper;
import io.xxnjdg.notp.course.object.persistent.CourseIntroduceAudit;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/22 12:40
 */
@Service
public class CourseIntroduceAuditAdminServiceImpl extends ServiceImpl<CourseIntroduceAuditMapper, CourseIntroduceAudit> implements CourseIntroduceAuditAdminService {
    @Override
    public Boolean updateCourseIntroduceAuditById(CourseIntroduceAuditDTO courseIntroduceAuditDTO) {
        CourseIntroduceAudit courseIntroduceAudit = CourseIntroduceAuditMapStruct.INSTANCE.DT2P(courseIntroduceAuditDTO);
        boolean update = this.updateById(courseIntroduceAudit);
        if (!update){
            throw new BaseException(CourseIntroduceAuditEnum.GET_ERROR);
        }
        return true;
    }

}
