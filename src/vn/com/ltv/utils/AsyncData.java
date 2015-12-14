package vn.com.ltv.utils;

import vn.com.ltv.common.LTVJson;
import android.os.AsyncTask;

public class AsyncData extends AsyncTask<String, Void, LTVJson> {

	@Override
	protected LTVJson doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		return null;
	}
//	private ILoadDataListener mListener;
//	private Object object;
//	private String url;
//	private String action = "GET";
//
//	public AsyncData(ILoadDataListener mListener, String method) {
//		this.mListener = mListener;
//	}
//
//	public AsyncData(ILoadDataListener mListener, String action, String url,
//			Object obj) {
//		this.mListener = mListener;
//		this.object = obj;
//		this.url = url;
//		this.action = action;
//	}
//
//	public AsyncData(ILoadDataListener mListener, String method, String url) {
//		this.mListener = mListener;
//		this.url = url;
//	}
//
//	@Override
//	protected void onPreExecute() {
//		if (mListener != null) {
//			mListener.onLoad();
//		}
//	}
//
//	@Override
//	protected LTVJson doInBackground(String... params) {
//		RestTemplate rest = new RestTemplate();
//		if ("GET".equals(action)) {
//			// Add the Jackson and String message converters
//			rest.getMessageConverters().add(new StringHttpMessageConverter());
//
//			return rest.getForObject(url, LTVJson.class);
//		}
//		// POST
//		else {
//			// Add the Jackson and String message converters
//			rest.getMessageConverters().add(
//					new MappingJacksonHttpMessageConverter());
//
//			return rest.postForObject(url, this.object, LTVJson.class);
//		}
//	}
//
//	@Override
//	protected void onPostExecute(LTVJson jsonResult) {
//		if (mListener != null) {
//			ObjectMapper mapper = new ObjectMapper();
//			if(jsonResult == null){
//				jsonResult = new LTVJson();
//			}
//			
//			if (jsonResult.getData() == null) {
//				jsonResult.setData(null);
//			} else {
//				if (jsonResult.getData() instanceof List<?>) {
//					List<Object> lstJson = mapper.convertValue(
//							jsonResult.getData(),
//							new TypeReference<List<Object>>() {
//							});
//
//					List<Object> lstResult = new ArrayList<Object>();
//					for (Object jsonObject : lstJson) {
//						lstResult.add(mapper.convertValue(jsonObject,
//								object.getClass()));
//					}
//					jsonResult.setData(lstResult);
//				} else {
//					jsonResult.setData(mapper.convertValue(
//							jsonResult.getData(), object.getClass()));
//				}
//			}
//			mListener.onCompleted(jsonResult);
//
//		}
//	}
}
