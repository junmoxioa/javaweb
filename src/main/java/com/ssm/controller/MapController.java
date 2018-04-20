package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
@RequestMapping("/map")
public class MapController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request,Model model){
        return "map/index";
    }
	
}
