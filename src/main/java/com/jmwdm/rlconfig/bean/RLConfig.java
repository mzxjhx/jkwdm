package com.jmwdm.rlconfig.bean;

import com.jmwdm.framework.BaseBean;

/**
 * RL测试参数
 * @author pc
 * @date 2020年6月26日
 */
public class RLConfig extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float levelA;
	private float levelB;
	private float maxVal;
	private float minVal;
	private boolean portC;	//C端口可选
	private boolean portP;	//p端口可选
	private boolean portR;	//R端口可选
	
	private String waveC;
	private String waveP;
	private String waveR;
	//三个端口，可单独选三个波长，互不冲突
	private boolean C1310;	//C端口选1310波长
	private boolean C1490;	//c端口选1490波长
	private boolean C1550;	//c端口选1550波长
	
	private boolean P1310;
	private boolean P1490;
	private boolean P1550;	
	
	private boolean R1310;
	private boolean R1490;
	private boolean R1550;	
	private String createTime;
	

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

	public float getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(float maxVal) {
		this.maxVal = maxVal;
	}

	public float getMinVal() {
		return minVal;
	}

	public void setMinVal(float minVal) {
		this.minVal = minVal;
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

	public String getWaveC() {
		return waveC;
	}

	public void setWaveC(String waveC) {
		this.waveC = waveC;
	}

	public String getWaveP() {
		return waveP;
	}

	public void setWaveP(String waveP) {
		this.waveP = waveP;
	}

	public String getWaveR() {
		return waveR;
	}

	public void setWaveR(String waveR) {
		this.waveR = waveR;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
