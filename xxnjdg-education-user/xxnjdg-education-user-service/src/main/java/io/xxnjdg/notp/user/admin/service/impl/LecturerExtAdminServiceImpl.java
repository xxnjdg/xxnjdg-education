package io.xxnjdg.notp.user.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xxnjdg.notp.user.admin.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.admin.object.convert.LecturerExtMapStruct;
import io.xxnjdg.notp.user.admin.service.LecturerExtAdminService;
import io.xxnjdg.notp.user.mapper.LecturerExtMapper;
import io.xxnjdg.notp.user.object.persistent.LecturerExt;
import org.springframework.stereotype.Service;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 4:51
 */
@Service
public class LecturerExtAdminServiceImpl extends ServiceImpl<LecturerExtMapper, LecturerExt> implements LecturerExtAdminService {
    @Override
    public LecturerExt getLecturerExtByUserNo(Long userNo) {
        LambdaQueryWrapper<LecturerExt> wrapper = new QueryWrapper<LecturerExt>()
                .lambda()
                .eq(LecturerExt::getLecturerUserNo, userNo);

        return this.getOne(wrapper);
    }
}
