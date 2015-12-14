package vn.com.ltv.trip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.com.ltv.adaptor.TripAdapter;
import vn.com.ltv.adaptor.TripAdapter.ITripItemClickListener;
import vn.com.ltv.common.Constants;
import vn.com.ltv.dto.TripVO;
import vn.com.ltv.http.HttpMethod;
import vn.com.ltv.response.LTVResponse;
import vn.com.ltv.rest.ICallBack;
import vn.com.ltv.rest.LTVRest;
import vn.com.ltv.rest.LTVRestException;
import vn.com.ltv.utils.AbstractAsyncActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class HomeActivity extends AbstractAsyncActivity implements
		ITripItemClickListener {
	private static final String TAG = HomeActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		LTVRest rest = new LTVRest();
		try {
			Map<String,Object> usr = new HashMap<String, Object>();
			usr.put("usrNm", "tutran");
			TripVO obj = new TripVO();
			obj.setTrpNm("tao lao mia lao");
			usr.put("trip", obj);
			rest.executeURL(Constants.URL.USER_GET_TRIP, usr, null,
					HttpMethod.GET.toString(), new ICallBack() {
						@SuppressWarnings("unchecked")
						@Override
						public void complete(LTVResponse response) {
							dismissProgressDialog();
							ListView listViewTours = (ListView) findViewById(R.id.lst_view_tour);
							List<TripVO> trips = (List<TripVO>) response
									.getAttribute("trips", TripVO.class);

							// [S] dtluc - Fixed: Could not click on ListView Item 
							TripAdapter adapter = new TripAdapter(
									getBaseContext(), trips, HomeActivity.this);
							// [E] dtluc - Fixed: Could not click on ListView Item 
							listViewTours.setAdapter(adapter);
						}

						@Override
						public void onload() {
							showLoadingProgressDialog();

						}
					});
		} catch (LTVRestException e) {
			Log.e(TAG, e.getMessage());
		}

	}

	@Override
	public void onItemClick(View view, TripVO trip) {
		Intent intent = new Intent(HomeActivity.this, TripInfoActivity.class);
		startActivity(intent);
	}

	@Override
	public void onCommentClick(View view, TripVO trip) {

	}
}
