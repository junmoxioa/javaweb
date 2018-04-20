package com.ssm.dao;

import java.util.List;

import com.ssm.dto.UploadFileReo;
import com.ssm.entity.UploadFile;

public interface IUploadFileDao extends BaseDao<UploadFile>{
	
	/**
	 * 多条件查询
	 * @param dto
	 * @return
	 */
	List<UploadFile> selectByMap(UploadFileReo dto);

	/**
	 * 根据文件名删除
	 * @param fileName
	 */
	void deleteByFileName(String fileName);
}