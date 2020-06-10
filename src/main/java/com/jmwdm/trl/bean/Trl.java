package com.jmwdm.trl.bean;

import com.jmwdm.framework.BaseBean;

/**
 * 回损值
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
	private float T1310;
	private float T1490;
	private float T1550;
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
		return T1310;
	}
	public void setT1310(float t1310) {
		T1310 = t1310;
	}
	public float getT1490() {
		return T1490;
	}
	public void setT1490(float t1490) {
		T1490 = t1490;
	}
	public float getT1550() {
		return T1550;
	}
	public void setT1550(float t1550) {
		T1550 = t1550;
	}
	
	
}
