package io.xxnjdg.notp.course.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseCategoryMapStruct;
import io.xxnjdg.notp.course.admin.service.CourseCategoryAdminService;
import io.xxnjdg.notp.course.mapper.CourseCategoryMapper;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 17:50
 */
@Service
public class CourseCategoryAdminServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory> implements CourseCategoryAdminService {
    @Override
    public List<CourseCategoryBO> listCourseCategory() {
        return CourseCategoryMapStruct.INSTANCE.P2B(this.list());
    }
}
