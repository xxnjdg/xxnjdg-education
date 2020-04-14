package io.xxnjdg.notp.utils.constant;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午3:03
 */
public enum HttpStatus {

    /**
     * 操作成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 资源，服务未找到
     */
    NOT_FOUND(404,"服务未找到"),
    /**
     * 系统内部错误
     */
    ERROR(500,"系统内部错误");

    private int status;
    private String statusText;

    HttpStatus(int status, String statusText) {
        this.status = status;
        this.statusText = statusText;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }


}
