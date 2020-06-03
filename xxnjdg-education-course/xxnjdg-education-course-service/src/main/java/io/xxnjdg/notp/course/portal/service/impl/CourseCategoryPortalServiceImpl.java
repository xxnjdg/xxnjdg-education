package io.xxnjdg.notp.course.portal.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.mapper.CourseCategoryMapper;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.course.portal.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.portal.object.convert.CourseCategoryMapStruct;
import io.xxnjdg.notp.course.portal.service.CourseCategoryPortalService;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/29 18:50
 */
@Service
public class CourseCategoryPortalServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory> implements CourseCategoryPortalService {
    @Override
    public List<CourseCategoryBO> listCourseCategory() {
        LambdaQueryWrapper<CourseCategory> wrapper = new QueryWrapper<CourseCategory>()
                        .lambda()
                        .eq(CourseCategory::getStatusId, RowStatus.ENABLE);

        //全局扫描
        List<CourseCategory> list = this.list(wrapper);

        if (CollUtil.isEmpty(list)){
            return null;
        }

        List<CourseCategoryBO> courseCategoryBOList =
                CourseCategoryMapStruct.INSTANCE.P2B(list);

        try {
            // list -> sort tree
            courseCategoryBOList = ListToTreeUtil.getTree(courseCategoryBOList, ParentId.ZERO_PARENT_ID.getStatus());
        } catch (Exception e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(),e.getMessage());
        }

        return courseCategoryBOList;
    }
}
