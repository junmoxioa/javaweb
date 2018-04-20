package com.ssm.dto;

import java.util.Date;

/**
 * 接受上传文件管理模块参数实体类
 * @author ASUS
 *
 */
public class UploadFileReo extends BaseReo {

	/**
	 * 开始时间
	 */
	private Date startTime;
	
	/**
	 * 结束时间
	 */
	private Date endTime;
	
	/**
	 * 上传人(用户名称)
	 */
	private String userName;
	
	/**
	 * 文件名称
	 */
	private String fileName;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
