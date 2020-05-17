package io.xxnjdg.notp.system.object.convert;

import io.xxnjdg.notp.system.object.business.SysMenuBO;
import io.xxnjdg.notp.system.object.persistent.SysMenu;
import io.xxnjdg.notp.system.object.view.ButtonVO;
import io.xxnjdg.notp.system.object.view.DirectoryAndMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/15 20:57
 */
@Mapper
public interface SysMenuMapStruct {
    SysMenuMapStruct INSTANCE = Mappers.getMapper(SysMenuMapStruct.class);

    /**
     * DO -> BO
     * @param sysMenuRoles
     * @return
     */
    List<SysMenuBO> convertD2B(List<SysMenu> sysMenuRoles);

    /**
     * BO -> VO
     * @param sysMenuBO
     * @return
     */
    @Mappings({
            @Mapping(source = "menuName",target = "name")
    })
    ButtonVO convertButtonVO(SysMenuBO sysMenuBO);

    /**
     * BO -> VO
     * @param sysMenuBOS
     * @return
     */
    List<ButtonVO> convertListButtonVO(List<SysMenuBO> sysMenuBOS);

    /**
     * BO -> VO
     * @param sysMenuBO
     * @return
     */
    @Mappings({
            @Mapping(source = "menuName",target = "name"),
            @Mapping(source = "menuUrl",target = "path"),
            @Mapping(source = "menuIcon",target = "icon")
    })
    DirectoryAndMenuVO convertDirectoryAndMenuVO(SysMenuBO sysMenuBO);

    /**
     * BO -> VO
     * @param sysMenuBOS
     * @return
     */
    List<DirectoryAndMenuVO> convertListDirectoryAndMenuVO(List<SysMenuBO> sysMenuBOS);
}