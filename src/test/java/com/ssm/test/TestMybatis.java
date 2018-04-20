package com.ssm.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ssm.dto.UploadFileReo;
import com.ssm.dto.UserReo;
import com.ssm.entity.Menu;
import com.ssm.entity.User;
import com.ssm.entity.UserMenu;
import com.ssm.service.IMenuService;
import com.ssm.service.IUploadFileService;
import com.ssm.service.IUserMenuService;
import com.ssm.service.IUserService;
import com.ssm.util.MD5Util;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMybatis {  
    private static Logger logger = Logger.getLogger(TestMybatis.class);  
//  private ApplicationContext ac = null;
    
    @Resource  
    private IUserService userService = null;
    
    @Resource
    private IMenuService menuService;
    
    @Resource
    private IUserMenuService userMenuService;
    
    @Resource
    private IUploadFileService uploadFileService;
  
//  @Before  
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() { 
    	UserReo dto = new UserReo();
    	dto.setAge(10);
    	dto.setUserName("测试");
        logger.info(JSON.toJSONString(userService.list(dto)));
    } 
    
    @Test
    public void menu(){
    	Menu eo = menuService.getById(1);
    	logger.info(JSON.toJSONString(eo));
    }
    
    @Test
    public void userMenu(){
    	List<UserMenu> list = userMenuService.getListByUserId(2);
    	logger.info(JSON.toJSONString(list));
    }
    
    @Test
    public void menu2(){
    	List<Menu> result = menuService.getAll();
    	logger.info(JSON.toJSONString(result));
    }
    
    @Test
    public void user(){
    	userService.check_username("君");
    }
    
    @Test
    public void user1(){
    	User user = userService.getById(3);
    	UserReo dto = new UserReo();
    	dto.setPassword("1");
    	dto.setPassword2("admin");
    	dto.setPassword3("admin");
    	userService.edit(dto, user);
    }
    
    @Test
    public void uploadFile(){
    	UploadFileReo dto = new UploadFileReo();
    	
    	dto.setFileName("1");
    	dto.setUserName("十年");
    	
    	Map<String, Object> result = uploadFileService.list(dto);
    	
    	logger.info(JSON.toJSONString(result));
    }
} 
