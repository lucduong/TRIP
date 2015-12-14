/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd
 *
 * Created  : Feb 21, 2014
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Feb 21, 2014    	   jack        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private long usrId;
	private String usrNm;
	private String usrPwd;
	private String usrEml;

	public User() {

	}

	public long getUsrId() {
		return usrId;
	}

	public void setUsrId(long usrId) {
		this.usrId = usrId;
	}

	public String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public String getUsrPwd() {
		return usrPwd;
	}

	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}

	public String getUsrEml() {
		return usrEml;
	}

	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	@Override
	public String toString() {
		return "User [usrId=" + usrId + ", usrNm=" + usrNm + ", usrPwd="
				+ usrPwd + ", usrEml=" + usrEml + "]";
	}
}
