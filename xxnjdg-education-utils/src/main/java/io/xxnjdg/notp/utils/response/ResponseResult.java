package io.xxnjdg.notp.utils.response;

import io.xxnjdg.notp.utils.constant.HttpStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午3:02
 */
@Data
@NoArgsConstructor
public class ResponseResult extends HashMap<String,Object> {

    /** 状态码 */
    public static final String STATUS = "status";

    /** 返回内容 */
    public static final String STATUS_TEXT = "statusText";

    /** 数据对象 */
    public static final String DATA = "data";

    /**
     *
     * @param code 状态码
     * @param msg 返回内容
     */
    public ResponseResult(int code, String msg)
    {
        super.put(STATUS, code);
        super.put(STATUS_TEXT, msg);
    }


    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResponseResult(int code, String msg, Object data)
    {
        super.put(STATUS, code);
        super.put(STATUS_TEXT, msg);
        if (data != null)
        {
            super.put(DATA, data);
        }
    }

    /**
     * 自定义返回结果
     * @param httpStatus 状态
     * @param data 数据
     * @return 返回结果
     */
    public static ResponseResult customResult(HttpStatus httpStatus,Object data){
        return new ResponseResult(httpStatus.getStatus(), httpStatus.getStatusText(), data);
    }

    /**
     * 成功
     * @return 返回结果
     */
    public static ResponseResult success()
    {
        return customResult(HttpStatus.SUCCESS,"");
    }

    /**
     * 成功代参数
     * @param data 参数
     * @return 返回结果
     */
    public static ResponseResult success(Object data)
    {
        return customResult(HttpStatus.SUCCESS,data);
    }

    /**
     * 失败
     * @return 返回结果
     */
    public static ResponseResult error()
    {
        return customResult(HttpStatus.ERROR,"");
    }

    /**
     * 失败代参数
     * @param data 参数
     * @return 返回结果
     */
    public static ResponseResult error(HttpStatus httpStatus,Object data)
    {
        return customResult(HttpStatus.ERROR,data);
    }

}
