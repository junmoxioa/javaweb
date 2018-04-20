package com.ssm.entity;

import java.util.Date;

public class UploadFile {
	
	/**
	 * 主键
	 */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 上传时间
     */
    private Date uploadTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}