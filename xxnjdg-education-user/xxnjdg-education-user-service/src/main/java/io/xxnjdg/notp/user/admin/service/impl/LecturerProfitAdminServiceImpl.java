package io.xxnjdg.notp.user.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.LecturerProfitBO;
import io.xxnjdg.notp.user.admin.object.convert.LecturerProfitMapStruct;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerProfitDTO;
import io.xxnjdg.notp.user.admin.service.LecturerAdminService;
import io.xxnjdg.notp.user.admin.service.LecturerProfitAdminService;
import io.xxnjdg.notp.user.mapper.LecturerProfitMapper;
import io.xxnjdg.notp.user.object.persistent.Lecturer;
import io.xxnjdg.notp.user.object.persistent.LecturerProfit;
import io.xxnjdg.notp.utils.custom.utils.PageObjectUtil;
import io.xxnjdg.notp.utils.objects.PageObject;
import io.xxnjdg.notp.utils.response.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 17:54
 */
@Service
public class LecturerProfitAdminServiceImpl extends ServiceImpl<LecturerProfitMapper, LecturerProfit> implements LecturerProfitAdminService {

    @Autowired
    private LecturerAdminService lecturerAdminService;

    @Override
    public PageResult<LecturerProfitBO> listLecturerProfitByPage(LecturerProfitDTO lecturerProfitDTO) {
        PageResult<LecturerProfitBO> result = new PageResult<>();

        //算总数
        LambdaQueryWrapper<LecturerProfit> wrapper = new QueryWrapper<LecturerProfit>()
                .lambda();

        DateTime beginDate = null;
        DateTime endDate = null;
        Integer profitStatus = lecturerProfitDTO.getProfitStatus();

        Collection<Long> userNoList = null;

        String lecturerName = lecturerProfitDTO.getLecturerName();
        if (StrUtil.isNotBlank(lecturerName)) {
            List<Lecturer> lecturerList = lecturerAdminService
                    .listLecturerByLecturerName(lecturerName);

            if (CollUtil.isNotEmpty(lecturerList)) {
                userNoList = lecturerList.stream().map(Lecturer::getLecturerUserNo)
                        .collect(Collectors.toList());

                wrapper.in(LecturerProfit::getLecturerUserNo, userNoList);
            }
        }

        if (StrUtil.isNotBlank(lecturerProfitDTO.getBeginDate())) {
            beginDate = DateUtil.parse(lecturerProfitDTO.getBeginDate());
            beginDate.offset(DateField.HOUR, 24);
            wrapper.ge(LecturerProfit::getGmtCreate, beginDate);
        }

        if (StrUtil.isNotBlank(lecturerProfitDTO.getEndDate())) {
            endDate = DateUtil.parse(lecturerProfitDTO.getEndDate());
            endDate.offset(DateField.HOUR, 48);
            wrapper.le(LecturerProfit::getGmtCreate, endDate);
        }

        if (profitStatus != null) {
            wrapper.eq(LecturerProfit::getProfitStatus, profitStatus);
        }

        int count = this.count(wrapper);

        //条数为0
        if (count == 0) {
            return result;
        }

        PageObject pageObject = PageObjectUtil.countPageOffsetAndSize(
                lecturerProfitDTO.getPageCurrent(), lecturerProfitDTO.getPageSize(), count);

        //查询
        List<LecturerProfit> lecturerProfitList =
                this.baseMapper.listLecturerProfitByPage(userNoList, beginDate, endDate, profitStatus, pageObject.getOffset(), pageObject.getSize());

        List<LecturerProfitBO> lecturerProfitBOList =
                LecturerProfitMapStruct.INSTANCE.P2B(lecturerProfitList);

        List<Long> collect = lecturerProfitBOList.stream().map(
                LecturerProfitBO::getLecturerUserNo).collect(Collectors.toList());

        List<Lecturer> lecturerList = lecturerAdminService.listLecturerByUserNos(collect);

        if (CollUtil.isNotEmpty(lecturerList)) {
            for (LecturerProfitBO lecturerProfitBO : lecturerProfitBOList) {
                for (Lecturer lecturer : lecturerList) {
                    if (ObjectUtil.equal(lecturerProfitBO.getLecturerUserNo(),
                            lecturer.getLecturerUserNo())) {
                        lecturerProfitBO
                                .setLecturerName(lecturer.getLecturerName())
                                .setLecturerMobile(lecturer.getLecturerMobile());
                        break;
                    }
                }

            }
        }

        return result
                .setCurrentList(lecturerProfitBOList)
                .setTotalCount((long) count)
                .setTotalPage(pageObject.getTotalPage())
                .setCurrentPage(pageObject.getCurrentPage())
                .setCurrentListSize((long) lecturerProfitBOList.size());
    }
}
