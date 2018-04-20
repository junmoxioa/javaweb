package com.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.dao.IUploadFileDao;
import com.ssm.dto.UploadFileReo;
import com.ssm.entity.UploadFile;
import com.ssm.service.IUploadFileService;

/**
 * 上传文件业务实现类
 * @author ASUS
 *
 */
@Service("uploadFileService")
public class UploadFileServiceImpl implements IUploadFileService {

	@Resource
	IUploadFileDao dao;
	
	/**
	 * 多条件查询
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> list(UploadFileReo dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Page<UploadFile> page = PageHelper.startPage(dto.getPage(), dto.getLimit());
		List<UploadFile> list = dao.selectByMap(dto);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", list);
		map.put("count", page.getTotal());
		
		return map;
	}

	/**
	 * 根据文件名删除
	 */
	public void delByFileName(String fileName) {
		dao.deleteByFileName(fileName);
	}

	public UploadFile getById(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public int add(UploadFile eo) {
		return dao.insert(eo);
	}

	public void edit(UploadFile eo) {
		
	}

	public void del(String ids) {
		
	}

}
