package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.course.mapper.CourseCategoryMapper;
import io.xxnjdg.notp.course.object.view.CourseCategoryLevelVo;
import io.xxnjdg.notp.course.service.CourseCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.ItemStatus;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 课程分类 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-17
 */
@Service
public class CourseCategoryServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory> implements CourseCategoryService {

    @Override
    public List<CourseCategoryLevelVo> postCourseCategoryList() {

        LambdaQueryWrapper<CourseCategory> queryWrapper =
                new QueryWrapper<CourseCategory>().lambda().eq(CourseCategory::getStatusId, ItemStatus.ENABLE.getStatus());

        List<CourseCategory> list = this.list(queryWrapper);

        if (CollUtil.isEmpty(list)){
            return null;
        }

        ArrayList<CourseCategoryLevelVo> courseCategoryLevelVos = new ArrayList<>();

        list.forEach(courseCategory -> courseCategoryLevelVos.add(BeanUtil.copyProperties(courseCategory,CourseCategoryLevelVo.class)));

        List<CourseCategoryLevelVo> tree = null;

        try {
            tree = ListToTreeUtil.getTree(courseCategoryLevelVos,ParentId.ZERO_PARENT_ID.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tree;
    }

}
