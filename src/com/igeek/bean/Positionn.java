package com.igeek.bean;
/**
   * 职位表相关信息
 * 
 * @author 小 k 
 * @date 2018年10月30日 上午10:30:28 
 *
 */
public class Positionn {
	/**
	 *      职位id			positionid
	 *      职位名称			positionname
	*/
	
	private int positionid;
	private String positionname;
	public Positionn() {
	}
	public Positionn(int positionid, String positionname) {
		this.positionid = positionid;
		this.positionname = positionname;
	}
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	@Override
	public String toString() {
		return "Positionn [positionid=" + positionid + ", positionname=" + positionname + "]";
	}
	

}
