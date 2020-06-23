package com.jmwdm.irlconfig.bean;

import com.jmwdm.framework.BaseBean;

/* 
 * 配置文件类
 * 2020年6月23日-下午3:57:17
 * 
 */
public class IRLConfig extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private int type;
	private float levelA;
	private float levelB;
	private boolean portC;
	private boolean portP;
	private boolean portR;
	//三个端口，可单独选三个波长，互不冲突
	private boolean C1310;
	private boolean C1490;
	private boolean C1550;
	
	private boolean P1310;
	private boolean P1490;
	private boolean P1550;	
	
	private boolean R1310;
	private boolean R1490;
	private boolean R1550;	
	
	private String ilType;	//IL/RL/DIR
	private boolean bothPort; //是否测两根
	private boolean ilPortP;	//pass端口可选
	private float  il1;			//通道1合格值
	private boolean ilPortR;	//ref端口可选
	private float  il2;			//通道2合格
	private String createTime;	//
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
	public boolean isPortC() {
		return portC;
	}
	public void setPortC(boolean portC) {
		this.portC = portC;
	}
	public boolean isPortP() {
		return portP;
	}
	public void setPortP(boolean portP) {
		this.portP = portP;
	}
	public boolean isPortR() {
		return portR;
	}
	public void setPortR(boolean portR) {
		this.portR = portR;
	}
	public boolean isC1310() {
		return C1310;
	}
	public void setC1310(boolean c1310) {
		C1310 = c1310;
	}
	public boolean isC1490() {
		return C1490;
	}
	public void setC1490(boolean c1490) {
		C1490 = c1490;
	}
	public boolean isC1550() {
		return C1550;
	}
	public void setC1550(boolean c1550) {
		C1550 = c1550;
	}
	public boolean isP1310() {
		return P1310;
	}
	public void setP1310(boolean p1310) {
		P1310 = p1310;
	}
	public boolean isP1490() {
		return P1490;
	}
	public void setP1490(boolean p1490) {
		P1490 = p1490;
	}
	public boolean isP1550() {
		return P1550;
	}
	public void setP1550(boolean p1550) {
		P1550 = p1550;
	}
	public boolean isR1310() {
		return R1310;
	}
	public void setR1310(boolean r1310) {
		R1310 = r1310;
	}
	public boolean isR1490() {
		return R1490;
	}
	public void setR1490(boolean r1490) {
		R1490 = r1490;
	}
	public boolean isR1550() {
		return R1550;
	}
	public void setR1550(boolean r1550) {
		R1550 = r1550;
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
	
	
	
}
