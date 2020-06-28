package com.jmwdm.til.bean;

import com.jmwdm.framework.BaseBean;

/* 
 * 插损类
 * 2020年6月28日-下午4:51:45
 * 
 */
public class Til extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String serialNumber;// 'SN',
	String primitiveSn;// '原始sn，不唯一',
	String batchNumber;// '批次号',
	String table;// '工位',
	String createTime;
	String staff;// '工号',
	String level;// '合格与不合格',
	String type;// '测试类型 IL/RL/DIR',
	int wave1;// '测试波长',
	float il1;// '透射值',
	int wave2;// '反射波长',
	float il2;// '反射值',
	float ref1;// '参考值1',
	float ref2;// '参考值2',
	String config;// '测试工艺配置',
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWave1() {
		return wave1;
	}
	public void setWave1(int wave1) {
		this.wave1 = wave1;
	}
	public float getIl1() {
		return il1;
	}
	public void setIl1(float il1) {
		this.il1 = il1;
	}
	public int getWave2() {
		return wave2;
	}
	public void setWave2(int wave2) {
		this.wave2 = wave2;
	}
	public float getIl2() {
		return il2;
	}
	public void setIl2(float il2) {
		this.il2 = il2;
	}
	public float getRef1() {
		return ref1;
	}
	public void setRef1(float ref1) {
		this.ref1 = ref1;
	}
	public float getRef2() {
		return ref2;
	}
	public void setRef2(float ref2) {
		this.ref2 = ref2;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	
	
	
}
