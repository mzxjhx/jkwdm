package com.jmwdm.ilconfig.bean;

import com.jmwdm.framework.BaseBean;

/* 
 *  a插损测试配置
 * 2020年6月23日-下午3:57:17
 * 
 */
public class ILConfig extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private int type;
		
	private String ilType;	//IL/RL/DIR
	private boolean bothPort; //是否测两根
	private boolean ilPortP;	//pass端口可选
	private float  il1;			//通道1合格值
	private boolean ilPortR;	//ref端口可选
	private float  il2;			//通道2合格
	private String createTime;	//
	
	private String ILRL;	//IL或RL

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

	public String getIlType() {
		return ilType;
	}

	public void setIlType(String ilType) {
		this.ilType = ilType;
	}

	public boolean isBothPort() {
		return bothPort;
	}

	public void setBothPort(boolean bothPort) {
		this.bothPort = bothPort;
	}

	public boolean isIlPortP() {
		return ilPortP;
	}

	public void setIlPortP(boolean ilPortP) {
		this.ilPortP = ilPortP;
	}

	public float getIl1() {
		return il1;
	}

	public void setIl1(float il1) {
		this.il1 = il1;
	}

	public boolean isIlPortR() {
		return ilPortR;
	}

	public void setIlPortR(boolean ilPortR) {
		this.ilPortR = ilPortR;
	}

	public float getIl2() {
		return il2;
	}

	public void setIl2(float il2) {
		this.il2 = il2;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getILRL() {
		return ILRL;
	}

	public void setILRL(String iLRL) {
		ILRL = iLRL;
	}
	
	
	
}
