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
package vn.com.ltv.http;

import android.annotation.SuppressLint;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/**
 * 
 * @author Luc Duong
 * 
 */
@SuppressLint("NewApi")
public class HttpRequestWithEntity extends HttpEntityEnclosingRequestBase {

	private String method;

	/**
	 * New instance of HttpRequestWithEntity with URL and method for request
	 * 
	 * @param url
	 * @param method
	 */
	public HttpRequestWithEntity(String url, String method) {
		if (method == null || (method != null && method.isEmpty())) {
			this.method = HttpMethod.GET.toString();
		} else {
			this.method = method;
		}
		try {
			setURI(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * New instance of HttpRequestWithEntity with URL and method for request
	 * 
	 * @param url
	 * @param method
	 */
	public HttpRequestWithEntity(String url, HttpMethod method) {
		if (method == null || (method != null && method.toString().isEmpty())) {
			this.method = HttpMethod.GET.toString();
		} else {
			this.method = method.toString();
		}
		try {
			setURI(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getMethod() {
		return this.method;
	}
}