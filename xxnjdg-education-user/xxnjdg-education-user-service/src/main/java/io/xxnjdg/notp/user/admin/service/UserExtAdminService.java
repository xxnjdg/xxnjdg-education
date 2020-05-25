package io.xxnjdg.notp.user.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.admin.object.business.UserExtBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.UserExtDTO;
import io.xxnjdg.notp.user.object.persistent.UserExt;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 2:59
 */
public interface UserExtAdminService extends IService<UserExt> {

    /**
     * 获取
     * @param mobile
     * @return
     */
    UserExt getUserExtByMobile(String mobile);

    /**
     * 更新
     * @param mobile
     * @param userNo
     * @return
     */
    Boolean updateUserByUserNo(String mobile,Long userNo);

    /**
     * 分页查询列表
     * @param userExtDTO
     * @return
     */
    PageResult<UserExtBO> listUserExtByPage(UserExtDTO userExtDTO);

    /**
     * 更新
     * @param userExtDTO
     * @return
     */
    Boolean updateUserExt(UserExtDTO userExtDTO);

    /**
     * 查询
     * @param userExtDTO
     * @return
     */
    UserExtBO getUserExt(UserExtDTO userExtDTO);
}
