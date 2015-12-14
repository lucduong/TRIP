/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd  All rights reserved
 *
 * Created  : Feb 23, 2014
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Feb 23, 2014    	   jack        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.rest;

import vn.com.ltv.response.LTVResponse;

public interface ICallBack {
	public void complete(LTVResponse response);
	public void onload();
}
