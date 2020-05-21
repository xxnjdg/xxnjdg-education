package io.xxnjdg.notp.course.admin.object.convert;

import io.xxnjdg.notp.course.admin.object.business.AdvBO;
import io.xxnjdg.notp.course.admin.object.data.transfer.AdvDTO;
import io.xxnjdg.notp.course.admin.object.view.AdvPageVO;
import io.xxnjdg.notp.course.admin.object.view.AdvVO;
import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 13:55
 */
@Mapper
public interface AdvMapStruct {
    AdvMapStruct INSTANCE = Mappers.getMapper(AdvMapStruct.class);

    /**
     * P2B
     * @param advDTO
     * @return
     */
    Adv DTO2P(AdvDTO advDTO);

    /**
     * P2B
     * @param adv
     * @return
     */
    AdvBO P2B(Adv adv);


    /**
     * P2B
     * @param advList
     * @return
     */
    List<AdvBO> P2B(List<Adv> advList);

    /**
     * B2V
     * @param advBO
     * @return
     */
    AdvPageVO B2PV(AdvBO advBO);

    /**
     * B2V
     * @param advBO
     * @return
     */
    AdvVO B2V(AdvBO advBO);

    /**
     * B2V
     * @param advBOList
     * @return
     */
    List<AdvPageVO> B2PV(List<AdvBO> advBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<AdvPageVO> B2PV(PageResult<AdvBO> result);
}