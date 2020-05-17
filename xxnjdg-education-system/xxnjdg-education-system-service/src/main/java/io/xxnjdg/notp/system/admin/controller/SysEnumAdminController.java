package io.xxnjdg.notp.system.admin.controller;

import io.xxnjdg.notp.system.admin.object.data.transfer.SysEnumDTO;
import io.xxnjdg.notp.utils.custom.utils.EnumUtil;
import io.xxnjdg.notp.utils.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/17 20:51
 */
@RestController
public class SysEnumAdminController {

    @RequestMapping(value = "/system/pc/api/sys/enum/list", method = RequestMethod.POST)
    public ResponseResult getEnumInfo(@RequestBody SysEnumDTO sysEnumDTO) {
        String className = "io.xxnjdg.notp.utils.enums."+sysEnumDTO.getEnumName();
        try {
            Class clazz = Class.forName(className);
            if(clazz == null) {
                return ResponseResult.error("找不到该枚举信息");
            }
            return ResponseResult.success(new ArrayList<>(EnumUtil.toList(clazz)));
        } catch (ClassNotFoundException e) {
            return ResponseResult.error("获取枚举失败");
        }
    }
}
