package io.xxnjdg.notp.utils.response;

import io.xxnjdg.notp.utils.constant.HttpStatus;
import io.xxnjdg.notp.utils.interfaces.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午3:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 7927983260804314646L;

    /** 状态码 */
    private Integer status;

    /** 返回内容 */
    private String statusText;

    /** 数据对象 */
    private T data;

    /**
     * 自定义返回结果
     * @param baseResponse 状态
     * @param data 数据
     * @return 返回结果
     */
    public static ResponseResult customResult(BaseResponse baseResponse, Object data){
        return customResult(baseResponse.status(), baseResponse.statusText(), data);
    }

    public static ResponseResult customResult(int status, String statusText ,Object data){
        return new ResponseResult(status, statusText, data);
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
    public static ResponseResult error(BaseResponse baseResponse,Object data)
    {
        return customResult(baseResponse,data);
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static ResponseResult error(String message)
    {
        return customResult(HttpStatus.ERROR.getStatus(),message,"");
    }


    /**
     * 失败
     * @param baseResponse
     * @return
     */
    public static ResponseResult error(BaseResponse baseResponse)
    {
        return error(baseResponse,null);
    }
}
