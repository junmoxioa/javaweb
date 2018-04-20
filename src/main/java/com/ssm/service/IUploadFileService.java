package com.ssm.service;

import java.util.Map;

import com.ssm.dto.UploadFileReo;
import com.ssm.entity.UploadFile;

public interface IUploadFileService extends BaseService<UploadFile>{
	
	/**
	 * 多条件查询
	 * @param dto
	 * @return
	 */
	Map<String, Object> list(UploadFileReo dto);

	/**
	 * 根据文件名删除
	 * @param fileName
	 */
	void delByFileName(String fileName);

}
