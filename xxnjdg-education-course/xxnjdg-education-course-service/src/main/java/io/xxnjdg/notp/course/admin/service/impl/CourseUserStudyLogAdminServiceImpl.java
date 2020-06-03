package io.xxnjdg.notp.course.admin.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.course.admin.object.business.CourseUserStudyLogBO;
import io.xxnjdg.notp.course.admin.object.convert.CourseUserStudyLogMapStruct;
import io.xxnjdg.notp.course.admin.object.data.transfer.CourseUserStudyLogDTO;
import io.xxnjdg.notp.course.admin.service.CourseUserStudyLogAdminService;
import io.xxnjdg.notp.course.mapper.CourseUserStudyLogMapper;
import io.xxnjdg.notp.course.object.persistent.CourseUserStudyLog;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/26 4:13
 */
@Service
public class CourseUserStudyLogAdminServiceImpl extends ServiceImpl<CourseUserStudyLogMapper, CourseUserStudyLog> implements CourseUserStudyLogAdminService {
    @Override
    public PageResult<CourseUserStudyLogBO> listCourseUserStudyLogByPage(CourseUserStudyLogDTO courseUserStudyLogDTO) {
        PageResult<CourseUserStudyLogBO> result = new PageResult<>();

        Long userNo = courseUserStudyLogDTO.getUserNo();
        //算总数
        LambdaQueryWrapper<CourseUserStudyLog> wrapper = new QueryWrapper<CourseUserStudyLog>()
                .lambda()
                .eq(CourseUserStudyLog::getUserNo, userNo);

        DateTime beginGmtCreate = null;
        DateTime endGmtCreate = null;


        if (StrUtil.isNotBlank(courseUserStudyLogDTO.getBeginGmtCreate())) {
            beginGmtCreate = DateUtil.parse(courseUserStudyLogDTO.getBeginGmtCreate());
            beginGmtCreate.offset(DateField.HOUR, 24);
            wrapper.ge(CourseUserStudyLog::getGmtCreate, beginGmtCreate);
        }

        if (StrUtil.isNotBlank(courseUserStudyLogDTO.getEndGmtCreate())) {
            endGmtCreate = DateUtil.parse(courseUserStudyLogDTO.getEndGmtCreate());
            endGmtCreate.offset(DateField.HOUR, 48);
            wrapper.le(CourseUserStudyLog::getGmtCreate, endGmtCreate);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                courseUserStudyLogDTO.getPageCurrent(), courseUserStudyLogDTO.getPageSize(), count);

        //查询
        List<CourseUserStudyLog> courseUserStudyLogList =
                this.baseMapper.listCourseUserStudyLogAdminByPage(userNo,beginGmtCreate, endGmtCreate, pageObject.getOffset(), pageObject.getSize());

        List<CourseUserStudyLogBO> courseUserStudyLogBOList = CourseUserStudyLogMapStruct.INSTANCE.P2B(courseUserStudyLogList);

        return result
                .setCurrentList(courseUserStudyLogBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) courseUserStudyLogBOList.size());
    }
}
