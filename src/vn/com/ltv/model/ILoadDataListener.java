package vn.com.ltv.model;

import vn.com.ltv.common.LTVJson;


public interface ILoadDataListener {
	public void onLoad();

	//public void onLoading();

	public void onCompleted(LTVJson jsonResult);
}
