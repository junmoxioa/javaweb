package com.ssm.dto;

/**
 * 基本请求参数实体类
 * @author ASUS
 *
 */
public class BaseReo {

	/**
	 * 当前页数
	 */
	private int page;
	
	/**
	 * 一页多少条
	 */
	private int limit;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
