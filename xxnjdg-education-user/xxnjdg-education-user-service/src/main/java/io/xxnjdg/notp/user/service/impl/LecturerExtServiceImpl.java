package io.xxnjdg.notp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.xxnjdg.notp.user.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.object.convert.LecturerExtDOToBO;
import io.xxnjdg.notp.user.object.data.transfer.LecturerUserNoDTO;
import io.xxnjdg.notp.user.object.error.LecturerExtEnum;
import io.xxnjdg.notp.user.object.persistent.LecturerExt;
import io.xxnjdg.notp.user.mapper.LecturerExtMapper;
import io.xxnjdg.notp.user.service.LecturerExtService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.utils.constant.RowStatus;
import io.xxnjdg.notp.utils.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师账户信息表 服务实现类
 * </p>
 *
 * @author xxnjdg
 * @since 2020-04-20
 */
@Service
public class LecturerExtServiceImpl extends ServiceImpl<LecturerExtMapper, LecturerExt> implements LecturerExtService {

    @Override
    public LecturerExtBO getLecturerExtByLecturerUserNo(LecturerUserNoDTO lecturerUserNoDTO) {

        LambdaQueryWrapper<LecturerExt> lecturerExtLambdaQueryWrapper = new QueryWrapper<LecturerExt>().lambda()
                .eq(LecturerExt::getStatusId, RowStatus.ENABLE)
                .eq(LecturerExt::getLecturerUserNo, new Long(lecturerUserNoDTO.getLecturerUserNo()));

        LecturerExt lecturerExt = this.getOne(lecturerExtLambdaQueryWrapper);

        if (lecturerExt == null){
            throw new BaseException(LecturerExtEnum.LECTURER_EXT_NULL);
        }

        return LecturerExtDOToBO.INSTANCE.convert(lecturerExt);
    }
}
