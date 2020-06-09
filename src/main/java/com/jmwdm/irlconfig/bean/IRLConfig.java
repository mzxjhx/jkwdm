package com.jmwdm.irlconfig.bean;

import com.jmwdm.framework.BaseBean;

/* 
 * @author
 * 2020年6月9日-上午8:46:44
 * 测试配置文件
 */
public class IRLConfig extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int type;
	private float levelA;
	private float levelB;
	private boolean port_c;
	private boolean port_p;
	private boolean port_r;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public float getLevelA() {
		return levelA;
	}
	public void setLevelA(float levelA) {
		this.levelA = levelA;
	}
	public float getLevelB() {
		return levelB;
	}
	public void setLevelB(float levelB) {
		this.levelB = levelB;
	}
	public boolean isPort_c() {
		return port_c;
	}
	public void setPort_c(boolean port_c) {
		this.port_c = port_c;
	}
	public boolean isPort_p() {
		return port_p;
	}
	public void setPort_p(boolean port_p) {
		this.port_p = port_p;
	}
	public boolean isPort_r() {
		return port_r;
	}
	public void setPort_r(boolean port_r) {
		this.port_r = port_r;
	}
	
	
}
