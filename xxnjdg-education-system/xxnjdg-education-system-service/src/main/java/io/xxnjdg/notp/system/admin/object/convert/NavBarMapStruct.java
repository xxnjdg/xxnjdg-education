package io.xxnjdg.notp.system.admin.object.convert;

import io.xxnjdg.notp.system.admin.object.business.NavBarBO;
import io.xxnjdg.notp.system.admin.object.data.transfer.NavBarDTO;
import io.xxnjdg.notp.system.admin.object.view.NavBarPageVO;
import io.xxnjdg.notp.system.admin.object.view.NavBarVO;
import io.xxnjdg.notp.system.object.persistent.NavBar;
import io.xxnjdg.notp.utils.response.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/20 16:20
 */
@Mapper
public interface NavBarMapStruct {
    NavBarMapStruct INSTANCE = Mappers.getMapper(NavBarMapStruct.class);

    /**
     * P2B
     * @param navBarDTO
     * @return
     */
    NavBar DTO2P(NavBarDTO navBarDTO);

    /**
     * P2B
     * @param navBar
     * @return
     */
    NavBarBO P2B(NavBar navBar);


    /**
     * P2B
     * @param navBarList
     * @return
     */
    List<NavBarBO> P2B(List<NavBar> navBarList);

    /**
     * B2V
     * @param navBarBO
     * @return
     */
    NavBarVO B2V(NavBarBO navBarBO);

    /**
     * B2V
     * @param navBarBO
     * @return
     */
    NavBarPageVO B2PV(NavBarBO navBarBO);

    /**
     * B2V
     * @param navBarBOList
     * @return
     */
    List<NavBarPageVO> B2PV(List<NavBarBO> navBarBOList);

    /**
     * B2V
     * @param result
     * @return
     */
    PageResult<NavBarPageVO> B2PV(PageResult<NavBarBO> result);
}