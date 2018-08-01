package com.apollo.vo;

import java.sql.Date;

public class MemberDTO {

	private String mid;
	private String mname;
	private String pwd;
	private Date rday;
	private String pnum;
	private String image;
	private String deptname;
	private String apollokey;
	private String position;
	private String emailcheckkey;
	private String ischecked;
	
	public String getIschecked() {
		return ischecked;
	}
	public void setIschecked(String ischecked) {
		this.ischecked = ischecked;
	}
	public String getEmailcheck() {
		return emailcheckkey;
	}
	public void setEmailcheck(String emailcheckkey) {
		this.emailcheckkey = emailcheckkey;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRday() {
		return rday;
	}
	public void setRday(Date rday) {
		this.rday = rday;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getApollokey() {
		return apollokey;
	}
	public void setApollokey(String apollokey) {
		this.apollokey = apollokey;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mname=" + mname + ", pwd=" + pwd + ", rday=" + rday + ", pnum=" + pnum
				+ ", image=" + image + ", deptname=" + deptname + ", apollokey=" + apollokey + ", position=" + position
				+ "]";
	}
	
	
}
