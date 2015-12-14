/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd
 *
 * Created  : Jan 16, 2014
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Jan 16, 2014    	   Luc Duong        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.common;

import java.io.Serializable;

public class LTVJsonError implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
