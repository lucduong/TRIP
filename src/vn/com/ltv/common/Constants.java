/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 LTV Co., Ltd
 *
 * Create Date  : Dec 13, 2013
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Dec 13, 2013    	   Luc Duong        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.common;

public class Constants {
	// public static String URL_BASE = "http://10.0.0.144:8080";
	 public static String URL_BASE = "http://192.168.2.105:8080";
//	public static String URL_BASE = "http://10.0.0.153:8080";
	public static String ENCODING_UTF8 = "UTF-8";
	public static String HttpStatus = "status";

	public interface MIME {
		public static final String APPLICATION_JSON = "application/json";
	}

	public interface URL {
		public static String USER_REGISTER = URL_BASE + "/user/register";
		public static String USER_LOGIN = URL_BASE + "/user/login";
		public static String USER_LIST = URL_BASE + "/user/list";
		public static String USER_RETRIVE_PASSWORD = URL_BASE
				+ "/user/retrivePassword";

		public static String USER_GET_TRIP = URL_BASE + "/trip/list";
		public static String USER_RESPONSE_TRIP = URL_BASE
				+ "/response/trip/list";
		public static String USER_GET_PROFILE = URL_BASE
				+ "/user/{usrId}/profile";
	}

	public interface USR_INFO {
		public static String USER_ID = "usrId";
		public static String USER_NM = "usrNm";
		public static String USER_EML = "usrNm";
	}
}
