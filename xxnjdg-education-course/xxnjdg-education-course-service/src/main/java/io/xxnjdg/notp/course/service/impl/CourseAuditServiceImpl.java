package io.xxnjdg.notp.course.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.xxnjdg.notp.course.object.business.CourseAuditBO;
import io.xxnjdg.notp.course.object.business.CourseIntroduceAuditBO;
import io.xxnjdg.notp.course.object.convert.CourseAuditMapStruct;
import io.xxnjdg.notp.course.object.data.transfer.CourseAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.InsertCourseAuditDTO;
import io.xxnjdg.notp.course.object.data.transfer.ListCourseAuditBTO;
import io.xxnjdg.notp.course.object.error.CourseAuditEnum;
import io.xxnjdg.notp.course.object.persistent.CourseAudit;
import io.xxnjdg.notp.course.mapper.CourseAuditMapper;
import io.xxnjdg.notp.course.service.CourseAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.service.CourseIntroduceAuditService;
import io.xxnjdg.notp.utils.config.SnowFlakeId;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.exception.BaseException;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @Autowired
    private CourseIntroduceAuditService courseIntroduceAuditService;

    @Autowired
    private SnowFlakeId snowFlakeId;

    @Override
    public PageResult<CourseAuditBO> listCourseAuditByPage(ListCourseAuditBTO listCourseAuditBTO) {

        Long lecturerUserNo = new Long(listCourseAuditBTO.getLecturerUserNo());
        Integer auditStatus = null;
        PageResult<CourseAuditBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<CourseAudit> wrapper = new QueryWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getLecturerUserNo,lecturerUserNo)
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE);

        if (listCourseAuditBTO.getAuditStatus() != null){
            auditStatus = new Integer(listCourseAuditBTO.getAuditStatus());
            wrapper.eq(CourseAudit::getAuditStatus,auditStatus);
        }else {
            wrapper.lt(CourseAudit::getAuditStatus,3);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0){
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                listCourseAuditBTO.getPageCurrent(), listCourseAuditBTO.getPageSize(), count);

        //查询
        List<CourseAudit> courseAudits =
                this.baseMapper.listCourseAuditByPage(lecturerUserNo, auditStatus,pageObject.getOffset(), pageObject.getSize());

        List<CourseAuditBO> courseAuditBOS = CourseAuditMapStruct.INSTANCE.convertD2B(courseAudits);

        // TODO: 20-5-9 xxnjdg 没写完
        if (courseAuditBOS!=null){
            courseAuditBOS.forEach(courseAuditBO -> {
                courseAuditBO.setIsDelete(1);
                if (ObjectUtil.equal(courseAuditBO.getAuditStatus(),1)){
                    courseAuditBO.setIsDelete(0);
                }
            });
            result.setCurrentListSize((long) courseAuditBOS.size());
        }

        return result
                .setCurrentList(courseAuditBOS)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage());
    }

    @Override
    @Transactional
    public CourseAuditBO insertCourseAudit(InsertCourseAuditDTO insertCourseAuditDTO) {
        // 如果课程收费，价格不能为空
        if (ObjectUtil.equal(insertCourseAuditDTO.getIsFree(),"0") && insertCourseAuditDTO.getCourseOriginal() == null){
            throw new BaseException(CourseAuditEnum.INSERT_ERROR);
        }

        //插入简介
        CourseIntroduceAuditBO courseIntroduceAuditBO =
                courseIntroduceAuditService.insertCourseIntroduceAudit(
                        insertCourseAuditDTO.getIntroduce());

        CourseAudit courseAudit = CourseAuditMapStruct.INSTANCE.convertBTO2D(insertCourseAuditDTO);

        if (ObjectUtil.equal(courseAudit.getIsFree(),1)){
            courseAudit.setCourseOriginal(BigDecimal.valueOf(0));
        }

        //生成主键id
        Snowflake snowflake = IdUtil.createSnowflake(snowFlakeId.getWorkerId(), snowFlakeId.getDataCenterId());
        long id = snowflake.nextId();

        courseAudit
                .setId(id)
                .setGmtCreate(LocalDateTime.now())
                .setGmtModified(LocalDateTime.now())
                .setStatusId(RowStatus.ENABLE)
                .setSort(1)
                .setAuditStatus(0)
                .setIntroduceId(courseIntroduceAuditBO.getId())
                .setCourseDiscount(courseAudit.getCourseOriginal())
                .setIsPutaway(1);

        //插入
        boolean save = this.save(courseAudit);

        if (!save){
            throw new BaseException(CourseAuditEnum.INSERT_ERROR);
        }

        return CourseAuditMapStruct.INSTANCE.convertD2B(courseAudit);
    }

    @Override
    public CourseAuditBO getCourseAuditById(CourseAuditDTO courseAuditDTO) {
        LambdaQueryWrapper<CourseAudit> wrapper = new QueryWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseAudit::getId, courseAuditDTO.getId());

        CourseAudit courseAudit = this.getOne(wrapper);
        if (courseAudit == null){
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }

        return CourseAuditMapStruct.INSTANCE.convertD2B(courseAudit);
    }

    @Override
    public boolean updateCourseAudit(CourseAuditDTO courseAuditDTO) {

        LambdaUpdateWrapper<CourseAudit> wrapper = new UpdateWrapper<CourseAudit>()
                .lambda()
                .eq(CourseAudit::getStatusId, RowStatus.ENABLE)
                .eq(CourseAudit::getId, courseAuditDTO.getId())
                .set(CourseAudit::getAuditStatus, courseAuditDTO.getAuditStatus());

        boolean update = this.update(wrapper);
        if (!update){
            throw new BaseException(CourseAuditEnum.GET_ERROR);
        }
        return true;
    }
}
