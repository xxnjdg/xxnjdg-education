package io.xxnjdg.notp.course.model;

import java.io.Serializable;
import java.util.Date;

public class FileStorage implements Serializable {
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
     * 文件编号
     *
     * @mbg.generated
     */
    private Long fileNo;

    /**
     * 文件名称
     *
     * @mbg.generated
     */
    private String fileName;

    /**
     * 文件地址
     *
     * @mbg.generated
     */
    private String fileUrl;

    /**
     * 文件类型(1:附件;2;图片;3:视频)
     *
     * @mbg.generated
     */
    private Byte fileType;

    /**
     * 文件大小
     *
     * @mbg.generated
     */
    private Long fileSize;

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

    public Long getFileNo() {
        return fileNo;
    }

    public void setFileNo(Long fileNo) {
        this.fileNo = fileNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Byte getFileType() {
        return fileType;
    }

    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", fileNo=").append(fileNo);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}