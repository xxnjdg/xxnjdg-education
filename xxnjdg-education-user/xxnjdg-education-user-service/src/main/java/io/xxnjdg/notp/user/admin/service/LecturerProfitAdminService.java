package io.xxnjdg.notp.user.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xxnjdg.notp.user.admin.object.business.LecturerProfitBO;
import io.xxnjdg.notp.user.admin.object.data.transfer.LecturerProfitDTO;
import io.xxnjdg.notp.user.object.persistent.LecturerProfit;
import io.xxnjdg.notp.utils.response.PageResult;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 17:54
 */
public interface LecturerProfitAdminService extends IService<LecturerProfit> {
    /**
     * 分页查询列表
     * @param lecturerProfitDTO
     * @return
     */
    PageResult<LecturerProfitBO> listLecturerProfitByPage(LecturerProfitDTO lecturerProfitDTO);
}
