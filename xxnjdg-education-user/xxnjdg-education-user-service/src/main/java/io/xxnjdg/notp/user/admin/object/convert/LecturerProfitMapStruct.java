package io.xxnjdg.notp.user.admin.object.convert;

import io.xxnjdg.notp.user.admin.object.business.LecturerProfitBO;
import io.xxnjdg.notp.user.admin.object.view.LecturerProfitPageVO;
import io.xxnjdg.notp.user.object.persistent.LecturerProfit;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/25 17:59
 */
@Mapper
public interface LecturerProfitMapStruct {
    LecturerProfitMapStruct INSTANCE = Mappers.getMapper(LecturerProfitMapStruct.class);

    /**
     * P2B
     * @param lecturerProfit
     * @return
     */
    LecturerProfitBO P2B(LecturerProfit lecturerProfit);


    /**
     * P2B
     * @param lecturerProfitList
     * @return
     */
    List<LecturerProfitBO> P2B(List<LecturerProfit> lecturerProfitList);


    /**
     * B2V
     * @param lecturerBO
     * @return
     */
    LecturerProfitPageVO B2PV(LecturerProfitBO lecturerBO);

    /**
     * B2V
     * @param lecturerBOList
     * @return
     */
    List<LecturerProfitPageVO> B2PV(List<LecturerProfitBO> lecturerBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<LecturerProfitPageVO> B2PV(PageResult<LecturerProfitBO> result);
}