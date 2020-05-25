package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseCategoryBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseCategoryMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseCategoryDTO;
import io.xxnjdg.notp.course.admin.object.error.CourseCategoryEnum;
import io.xxnjdg.notp.course.admin.service.CourseCategoryAdminService;
import io.xxnjdg.notp.course.mapper.CourseCategoryMapper;
import io.xxnjdg.notp.course.object.persistent.CourseCategory;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.constant.ParentId;
import io.xxnjdg.notp.utils.custom.utils.ListToTreeUtil;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/21 17:50
 */
@Service
public class CourseCategoryAdminServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory> implements CourseCategoryAdminService {

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public List<CourseCategoryBO> listCourseCategory() {
        return CourseCategoryMapStruct.INSTANCE.P2B(this.list());
    }

    @Override
    public PageResult<CourseCategoryBO> listCourseCategoryByPage(CourseCategoryDTO courseCategoryDTO) {
        PageResult<CourseCategoryBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<CourseCategory> wrapper = new QueryWrapper<CourseCategory>()
                .lambda();

        Integer statusId = courseCategoryDTO.getStatusId();
        Integer floor = courseCategoryDTO.getFloor();
        Integer categoryType = courseCategoryDTO.getCategoryType();
        Long parentId = courseCategoryDTO.getParentId();

        String categoryName = null;


        if (statusId != null) {
            wrapper.eq(CourseCategory::getStatusId, statusId);
        }

        if (floor != null) {
            wrapper.eq(CourseCategory::getFloor, floor);
        }

        if (categoryType != null) {
            wrapper.eq(CourseCategory::getCategoryType, categoryType);
        }

        if (parentId != null) {
            wrapper.eq(CourseCategory::getParentId, parentId);
        }

        if (StrUtil.isNotBlank(courseCategoryDTO.getCategoryName())) {
            categoryName = courseCategoryDTO.getCategoryName();
            wrapper.like(CourseCategory::getCategoryName, categoryName);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                courseCategoryDTO.getPageCurrent(), courseCategoryDTO.getPageSize(), count);

        //查询分类
        List<CourseCategory> courseCategoryList =
                this.baseMapper.listCourseCategoryByPage(
                        statusId, floor, categoryType, parentId, categoryName, pageObject.getOffset(), pageObject.getSize());

        List<CourseCategoryBO> courseCategoryBOList =
                CourseCategoryMapStruct.INSTANCE.P2B(courseCategoryList);

        List<CourseCategoryBO> list = this.listCourseCategory();

        try {
            ListToTreeUtil.fillTree(courseCategoryBOList, list, ParentId.ZERO_PARENT_ID.getStatus(), false);
        } catch (Exception e) {
            throw new BaseException(HttpStatus.ERROR.getStatus(),e.getMessage());
        }

        return result
                .setCurrentList(courseCategoryBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) courseCategoryList.size());
    }

    @Override
    public Boolean saveCourseCategory(CourseCategoryDTO courseCategoryDTO) {

        CourseCategory courseCategory =
                CourseCategoryMapStruct.INSTANCE.DT2P(courseCategoryDTO)
                .setFloor(1)
                .setParentId(0L);

        if (!ObjectUtil.equal(courseCategoryDTO.getParentId(),0)){
            CourseCategory category = this.getById(courseCategoryDTO.getParentId());
            if (category == null){
                throw new BaseException(CourseCategoryEnum.SAVE_ERROR);
            }

            courseCategory
                    .setFloor(category.getFloor()+1);
        }

        getByParentIdAndCategoryName(courseCategoryDTO.getParentId(),
                courseCategoryDTO.getCategoryName());

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        courseCategory.setId(id);
        boolean save = this.save(courseCategory);
        if (!save){
            throw new BaseException(CourseCategoryEnum.SAVE_ERROR);
        }

        return true;
    }

    @Override
    public Boolean updateCourseCategory(CourseCategoryDTO courseCategoryDTO) {
        CourseCategory courseCategory = this.getById(courseCategoryDTO.getId());
        if (courseCategory == null){
            throw new BaseException(CourseCategoryEnum.UPDATE_ERROR);
        }

        getByParentIdAndCategoryName(courseCategory.getParentId(),
                courseCategoryDTO.getCategoryName());

        CourseCategory newCourseCategory = CourseCategoryMapStruct.INSTANCE
                .DT2P(courseCategoryDTO);

        boolean update = this.updateById(newCourseCategory);
        if (!update){
            throw new BaseException(CourseCategoryEnum.UPDATE_ERROR);
        }

        return true;
    }

    @Override
    public Boolean deleteCourseCategory(CourseCategoryDTO courseCategoryDTO) {
        LambdaQueryWrapper<CourseCategory> wrapper = new QueryWrapper<CourseCategory>()
                .lambda()
                .eq(CourseCategory::getParentId, courseCategoryDTO.getId());

        List<CourseCategory> list = this.list(wrapper);
        if(CollUtil.isNotEmpty(list)){
            throw new BaseException(CourseCategoryEnum.DELETE_ERROR);
        }

        boolean remove = this.removeById(courseCategoryDTO.getId());
        if (!remove){
            throw new BaseException(CourseCategoryEnum.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public CourseCategoryBO getCourseCategory(CourseCategoryDTO courseCategoryDTO) {
        CourseCategory courseCategory = this.getById(courseCategoryDTO.getId());
        if (courseCategory == null){
            throw new BaseException(CourseCategoryEnum.GET_ERROR);
        }
        return CourseCategoryMapStruct.INSTANCE.P2B(courseCategory);
    }

    private void getByParentIdAndCategoryName(Long parentId,String categoryName) {
        LambdaQueryWrapper<CourseCategory> wrapper = new QueryWrapper<CourseCategory>()
                .lambda()
                .eq(CourseCategory::getParentId, parentId)
                .eq(CourseCategory::getCategoryName, categoryName);

        CourseCategory one = this.getOne(wrapper);
        if (one != null){
            throw new BaseException(CourseCategoryEnum.SAVE_ERROR);
        }
    }
}
