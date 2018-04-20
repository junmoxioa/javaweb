package com.ssm.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ssm.dto.MenuReo;
import com.ssm.dto.Result;
import com.ssm.entity.Menu;
import com.ssm.service.IMenuService;

@Controller  
@RequestMapping("/menu")
public class MenuController {

	@Resource
	IMenuService iMenuService;
	
	/**
	 * 页面
	 * @param request
	 * @param model 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request,Model model){
        return "menu/list";
    }
	
	/**
	 * 获取数据
	 * @param request
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST,
			produces = {"application/json; charset=utf-8" })
    public String list(HttpServletRequest request,Model model,
    		MenuReo dto){
		
		Map<String,Object> result = iMenuService.list(dto);
		
        return JSON.toJSONString(result);
    }
	
	/**
	 * 新增
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request, Model model){
        return "menu/add_or_edit";
    }
	
	/**
	 * 新增保存
	 * @param request
	 * @param model
	 * @param eo
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model,
			Menu eo){
		
		try{
			iMenuService.add(eo);
			model.addAttribute("result", JSON.toJSONString(new Result<String>(null,"操作成功")));
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(e.getMessage())));
		}
		
        return "menu/add_or_edit";
    }
	
	/**
	 * 修改
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, Model model,
			int id){
		try{
			Menu eo = iMenuService.getById(id);
			model.addAttribute("result", JSON.toJSONString(new Result<Menu>(eo,"")));
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(e.getMessage())));
		}
        return "menu/add_or_edit";
    }
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(HttpServletRequest request, Model model,
			Menu eo){
		try{
			iMenuService.edit(eo);
			model.addAttribute("result", JSON.toJSONString(new Result<String>(null,"操作成功")));
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("result", JSON.toJSONString(new Result<Object>(e.getMessage())));
		}
		
        return "menu/add_or_edit";
    }
	
	/**
	 * 删除
	 * @param request
	 * @param model
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST,
			produces = {"application/json; charset=utf-8" })
    public String del(HttpServletRequest request,Model model,
    		String ids){
		try{
			iMenuService.del(ids);
			return JSON.toJSONString(new Result<String>(null, "操作成功"));
		}catch (Exception e){
			e.printStackTrace();
			return JSON.toJSONString(new Result<Object>(e.getMessage()));
		}
		
    }
	
}
