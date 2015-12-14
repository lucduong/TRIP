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

import java.util.Map;

public interface ILTVRest {
	/**
	 * Get data from service by doing GET, return to CallBack instance
	 * 
	 * @param url
	 * @param urlVariables
	 * @param callBack
	 * @throws LTVRestException
	 */
//	public void get(String url, Map<String, ?> urlVariables, ICallBack callBack)
//			throws LTVRestException;

	/**
	 * Get data from service by doing POST, return to CallBack instance
	 * 
	 * @param url
	 * @param urlVariables
	 * @param request
	 * @param callBack
	 * @throws LTVRestException
	 */
//	public void post(String url, Map<String, ?> urlVariables, Object request,
//			ICallBack callBack) throws LTVRestException;

	/**
	 * Get data from service by Get/Post method
	 * @param url
	 * @param urlVariables
	 * @param request
	 * @param method
	 * @param callBack
	 * @throws LTVRestException
	 */
	public void executeURL(String url, Map<String, ?> urlVariables,
			Object request, String method, ICallBack callBack)
			throws LTVRestException;

	// public void download(String url);
	//
	// public void upload();
}
