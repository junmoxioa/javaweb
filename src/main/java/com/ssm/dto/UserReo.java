package com.ssm.dto;

/**
 * 接收用户模块请求参数实体类
 * @author ASUS
 *
 */
public class UserReo extends BaseReo {

	/**
     * 名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
    
    /**
     * 确认密码
     */
    private String password2;
    

    /**
     * 修改密码确认密码
     */
    private String password3;

    /**
     * 年龄
     */
    private Integer age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String password3) {
		this.password3 = password3;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
