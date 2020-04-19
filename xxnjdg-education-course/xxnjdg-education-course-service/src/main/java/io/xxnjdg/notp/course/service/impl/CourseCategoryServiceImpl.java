package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.course.mapper.CourseCategoryMapper;
import io.xxnjdg.notp.course.object.view.CourseCategoryLevelVO;
import io.xxnjdg.notp.course.service.CourseCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.ItemStatus;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(CourseCategoryServiceImpl.class);

    @Override
    public List<CourseCategoryLevelVO> postCourseCategoryList() {

        LambdaQueryWrapper<CourseCategory> queryWrapper =
                new QueryWrapper<CourseCategory>().lambda().eq(CourseCategory::getStatusId, ItemStatus.ENABLE.getStatus());

        //全局扫描
        List<CourseCategory> list = this.list(queryWrapper);

        if (CollUtil.isEmpty(list)){
            return null;
        }

        ArrayList<CourseCategoryLevelVO> courseCategoryLevelVos = new ArrayList<>();

        //po -> vo
        list.forEach(courseCategory -> courseCategoryLevelVos.add(BeanUtil.copyProperties(courseCategory, CourseCategoryLevelVO.class)));

        List<CourseCategoryLevelVO> tree = null;

        try {
            // list -> sort tree
            tree = ListToTreeUtil.getTree(courseCategoryLevelVos,ParentId.ZERO_PARENT_ID.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info(tree.toString());

        return tree;
    }

}
