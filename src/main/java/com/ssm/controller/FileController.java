package com.ssm.controller;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.ssm.dto.Result;
import com.ssm.dto.UploadFileReo;
import com.ssm.entity.Login;
import com.ssm.entity.UploadFile;
import com.ssm.entity.User;
import com.ssm.service.IUploadFileService;
import com.ssm.util.Base;

@Controller  
@RequestMapping("/file")
public class FileController extends BaseController{

	@Resource
	IUploadFileService service;
	
	/**
	 * 文件上传页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(HttpServletRequest request,Model model){
        return "file/upload";
    }
	
	/**
	 * 文件上传
	 * @param request
	 * @param model
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST,
			produces = {"application/json; charset=utf-8" })
    public String upload(HttpServletRequest request,Model model,
    		@RequestParam("file") MultipartFile file){
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "");
		
        try{
        	//上传文件路径
    		String path = request.getServletContext().getRealPath(Base.UPLOAD_FILE_PATH);
    		
        	//上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            long fileSize = file.getSize();
            
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            
    		//将文件信息保存到数据库中
            Login login = getUserInfo(request);
            fileAdd(filename, fileSize, login.getUser());
            
            return JSON.toJSONString(new Result<Map<String, Object>>(result, ""));
        }catch(Exception e){
        	e.printStackTrace();
        	return JSON.toJSONString(new Result<String>(e.getMessage()));
        }
    }
	
	/**
	 * 文件下载页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String download(HttpServletRequest request,Model model){
        return "file/list";
    }
	
	/**
	 * 提供展示的数据
	 * @param request
	 * @param model
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST,
			produces = {"application/json; charset=utf-8" })
    public String download(HttpServletRequest request,Model model,
    		UploadFileReo dto){

		Map<String,Object> result = service.list(dto);
		
        return JSON.toJSONString(result);
    }
	
	/**
	 * 文件下载
	 * @param request
	 * @param model
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, Model model,
            String fileName)throws Exception {
    	
       //下载文件路径
       String path = request.getServletContext().getRealPath(Base.UPLOAD_FILE_PATH);
       File file = new File(path + File.separator + fileName);
       HttpHeaders headers = new HttpHeaders();
       
       //下载显示的文件名，解决中文名称乱码问题  
       String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
       
       //通知浏览器以attachment（下载方式）打开图片
       headers.setContentDispositionFormData("attachment", downloadFielName);
       
       //application/octet-stream ： 二进制流数据（最常见的文件下载）。
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       
       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
               headers, HttpStatus.CREATED);
    }
	
    /**
     * 删除上传的文件
     * @param request
     * @param model
     * @param fileName
     * @return
     */
    @ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST,
			produces = {"application/json; charset=utf-8" })
    public String del(HttpServletRequest request,Model model,
    		String fileName){
    	
    	try{
    		String path = request.getServletContext().getRealPath(Base.UPLOAD_FILE_PATH);
            File file = new File(path + File.separator + fileName);
            
            //删除文件
            if (file.exists()) {
                file.delete();
            }
            
            //删除数据库中的信息
            service.delByFileName(fileName);
            
            return JSON.toJSONString(new Result<Object>(null, "操作成功"));
    	}catch(Exception e){
    		e.printStackTrace();
    		return JSON.toJSONString(new Result<Object>(e.getMessage()));
    	}
    }
    
    /**
     * 将文件信息保存到数据库
     * @param fileNma
     * @param fileSize
     */
    private void fileAdd(String fileName, long fileSize, User user){
    	String fileSize_s = getSize(fileSize);
    	
    	UploadFile eo = new UploadFile();
    	
    	eo.setFileName(fileName);
    	eo.setFileSize(fileSize_s);
    	eo.setUserId(user.getId());
    	eo.setUserName(user.getUserName());
    	eo.setUploadTime(new Date());
    	
    	service.add(eo);
    }
    
    /**
     * 将字节转换为KB/MB/GB
     * @param size
     */
    private String getSize(long size) {  
    	
    	long GB = 1024 * 1024 * 1024;	//定义GB的计算常量  
    	long MB = 1024 * 1024;	//定义MB的计算常量  
    	long KB = 1024;	//定义KB的计算常量  
    	
        DecimalFormat df = new DecimalFormat("0.00");	//格式化小数  
        String resultSize = "";
        
        if (size / GB >= 1) {
            //如果当前Byte的值大于等于1GB  
            resultSize = df.format(size / (float) GB) + "GB";  
        } else if (size / MB >= 1) {  
            //如果当前Byte的值大于等于1MB  
            resultSize = df.format(size / (float) MB) + "MB";  
        } else if (size / KB >= 1) {  
            //如果当前Byte的值大于等于1KB  
            resultSize = df.format(size / (float) KB) + "KB";  
        } else {  
            resultSize = size + "B"; 
        }  
        return resultSize;  
    }
    
}
