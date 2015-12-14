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

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import vn.com.ltv.common.Constants;
import vn.com.ltv.http.HttpMethod;
import vn.com.ltv.http.HttpRequestWithEntity;
import vn.com.ltv.response.LTVResponse;
import vn.com.ltv.utils.Utils;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LTVRest implements ILTVRest {
	private static final String TAG = LTVRest.class.getName();
	private static final String QUESTION_MARK = "?";
	private static final String EQUAL_MARK = "=";
	private static final String AMPERSAND_MARK = "&"; // &amp;
	private Object objectForRequest;

	/**
	 * Request to server by Get method
	 * @param url
	 * @param urlVariables
	 * @param callBack
	 * @throws LTVRestException
	 */
	private void get(String url, Map<String, ?> urlVariables, ICallBack callBack)
			throws LTVRestException {
		new LTVAsync(callBack).execute(buildUrl(url, urlVariables),
				HttpMethod.GET.toString());
	}

	/**
	 * Request to server by Post method
	 * @param url
	 * @param urlVariables
	 * @param request
	 * @param callBack
	 * @throws LTVRestException
	 */
	private void post(String url, Map<String, ?> urlVariables, Object request,
			ICallBack callBack) throws LTVRestException {
		this.objectForRequest = request;
		new LTVAsync(callBack).execute(buildUrl(url, urlVariables),
				HttpMethod.POST.toString());
	}

	public class LTVAsync extends AsyncTask<String, Void, LTVResponse> {
		private ICallBack callBack;

		public LTVAsync(ICallBack callBack) {
			this.callBack = callBack;
		}

		@Override
		protected LTVResponse doInBackground(String... params) {
			String url = params[0];
			HttpMethod method = HttpMethod.valueOf(params[1]);

			HttpClient client = new DefaultHttpClient();
			HttpRequestWithEntity request = new HttpRequestWithEntity(url,
					method);
			HttpResponse response;

			switch (method) {
			case GET:
				break;
			case POST:
				if (objectForRequest != null) {
					try {
						Gson gson = new Gson();
						StringEntity stringEntity = new StringEntity(
								gson.toJson(objectForRequest));
						stringEntity
								.setContentEncoding(Constants.ENCODING_UTF8);
						stringEntity
								.setContentType(Constants.MIME.APPLICATION_JSON);
						request.setEntity(stringEntity);
					} catch (UnsupportedEncodingException ue) {
						Log.e(TAG, ue.getMessage());
					}
				}
				break;
			default:
				break;
			}

			try {
				response = client.execute((HttpUriRequest) request);
				if (response != null) {
					InputStream inputStream = response.getEntity().getContent();
					String jsonResult = Utils
							.convertStreamToString(inputStream);
					GsonBuilder builder = new GsonBuilder();
					Gson gson = builder.enableComplexMapKeySerialization()
							.create();
					LTVResponse data = gson.fromJson(jsonResult,
							LTVResponse.class);
					
					return data;
				}
			} catch (ClientProtocolException e) {
				Log.e(TAG, e.getMessage());
			} catch (IOException e) {
				Log.e(TAG, e.getMessage());
			}
			catch (Exception e) {
				Log.e(TAG, e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(LTVResponse result) {
			if (callBack != null) {
				callBack.complete(result);
			}
		}
	}

	private String buildUrl(String baseUrl, Map<String, ?> urlVariables) {
		if (urlVariables == null) {
			return baseUrl;
		}

		StringBuilder urlBuilder = new StringBuilder(baseUrl);
		urlBuilder.append(QUESTION_MARK);

		Set<String> keys = urlVariables.keySet();
		Iterator<String> keyIterator = keys.iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			urlBuilder.append(AMPERSAND_MARK);
			urlBuilder.append(key);
			urlBuilder.append(EQUAL_MARK);
			urlBuilder.append(urlVariables.get(key));
		}
		return urlBuilder.toString().replaceFirst("&", "");
	}

	@Override
	public void executeURL(String url, Map<String, ?> urlVariables,
			Object request,String method,ICallBack callBack)
			throws LTVRestException {

		if ("GET".equals(method)) {
			this.get(url, urlVariables, callBack);
		} else if ("POST".equals(method)) {
			this.post(url, urlVariables, request, callBack);
		}
	}
}