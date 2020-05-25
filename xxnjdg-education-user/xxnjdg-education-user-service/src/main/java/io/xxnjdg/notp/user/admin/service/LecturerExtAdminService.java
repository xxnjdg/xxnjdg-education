package io.xxnjdg.notp.user.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.admin.object.business.LecturerExtBO;
import io.xxnjdg.notp.user.object.persistent.LecturerExt;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 4:50
 */
public interface LecturerExtAdminService extends IService<LecturerExt> {
    /**
     * 查询
     * @param userNo
     * @return
     */
    LecturerExt getLecturerExtByUserNo(Long userNo);
}
