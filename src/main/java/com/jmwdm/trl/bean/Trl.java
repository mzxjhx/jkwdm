package com.jmwdm.trl.bean;

import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;

import com.jmwdm.framework.BaseBean;

/**
 * a回损值
 * @author HP
 * 2020-06-05
 */
public class Trl extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;	
	private String serialNumber;	
	private String primitiveSn;
	private String batchNumber;
	private String table;
	private String createTime;	
	private String staff;
	String level;
	private float t1310;
	private float t1490;
	private float t1550;
	
	private float r1310;
	private float r1490;
	private float r1550;
	
	private float c1310;
	private float c1490;
	private float c1550;
	
	private float rlC;
	private float rlT;
	private float rlR;
	private String config;	//关联测试参数配置
	
	private String beginTime;
	private String endTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPrimitiveSn() {
		return primitiveSn;
	}
	public void setPrimitiveSn(String primitiveSn) {
		this.primitiveSn = primitiveSn;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public float getT1310() {
		return t1310;
	}
	public void setT1310(float t1310) {
		this.t1310 = t1310;
	}
	public float getT1490() {
		return t1490;
	}
	public void setT1490(float t1490) {
		this.t1490 = t1490;
	}
	public float getT1550() {
		return t1550;
	}
	public void setT1550(float t1550) {
		this.t1550 = t1550;
	}
	public float getR1310() {
		return r1310;
	}
	public void setR1310(float r1310) {
		this.r1310 = r1310;
	}
	public float getR1490() {
		return r1490;
	}
	public void setR1490(float r1490) {
		this.r1490 = r1490;
	}
	public float getR1550() {
		return r1550;
	}
	public void setR1550(float r1550) {
		this.r1550 = r1550;
	}
	public float getC1310() {
		return c1310;
	}
	public void setC1310(float c1310) {
		this.c1310 = c1310;
	}
	public float getC1490() {
		return c1490;
	}
	public void setC1490(float c1490) {
		this.c1490 = c1490;
	}
	public float getC1550() {
		return c1550;
	}
	public void setC1550(float c1550) {
		this.c1550 = c1550;
	}
	public float getRlC() {
		return rlC;
	}
	public void setRlC(float rlC) {
		this.rlC = rlC;
	}
	public float getRlT() {
		return rlT;
	}
	public void setRlT(float rlT) {
		this.rlT = rlT;
	}
	public float getRlR() {
		return rlR;
	}
	public void setRlR(float rlR) {
		this.rlR = rlR;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
