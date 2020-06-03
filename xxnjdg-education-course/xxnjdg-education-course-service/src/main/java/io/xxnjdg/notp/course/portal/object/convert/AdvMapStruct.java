package io.xxnjdg.notp.course.portal.object.convert;

import io.xxnjdg.notp.course.object.persistent.Adv;
import io.xxnjdg.notp.course.portal.object.business.AdvBO;
import io.xxnjdg.notp.course.portal.object.view.adv.AdvPageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/27 2:19
 */
@Mapper
public interface AdvMapStruct {
    AdvMapStruct INSTANCE = Mappers.getMapper(AdvMapStruct.class);

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
     * @param advBOList
     * @return
     */
    List<AdvPageVO> B2PV(List<AdvBO> advBOList);
}