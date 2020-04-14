package io.xxnjdg.notp.system.model;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * 操作人
     *
     * @mbg.generated
     */
    private Long userNo;

    /**
     * 真实姓名
     *
     * @mbg.generated
     */
    private String realName;

    /**
     * IP地址
     *
     * @mbg.generated
     */
    private String ip;

    /**
     * 用户操作
     *
     * @mbg.generated
     */
    private String operation;

    /**
     * 请求方法
     *
     * @mbg.generated
     */
    private String method;

    /**
     * 请求路径
     *
     * @mbg.generated
     */
    private String path;

    /**
     * 请求参数
     *
     * @mbg.generated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", userNo=").append(userNo);
        sb.append(", realName=").append(realName);
        sb.append(", ip=").append(ip);
        sb.append(", operation=").append(operation);
        sb.append(", method=").append(method);
        sb.append(", path=").append(path);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}