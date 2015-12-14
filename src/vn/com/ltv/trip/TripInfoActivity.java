package vn.com.ltv.trip;

import java.util.ArrayList;
import java.util.List;

import vn.com.ltv.adaptor.LocationAdapter;
import vn.com.ltv.dto.StationVO;
import vn.com.ltv.tab.TabTripDetail;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class TripInfoActivity extends Activity {

	private ListView lstViewStation;
	private Button btnAddLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trip_info);
		lstViewStation = (ListView) findViewById(R.id.listViewStation);

		String[] values = new String[] { "Sài Gòn", "Đà Nẵng", "Hội An",
				"Huế", "Vũng Tàu", "Nha Trang", "Sapa"};

		List<StationVO> lstDataView = new ArrayList<StationVO>();
		
	    for (int i = 0; i < values.length; ++i) {
	    	StationVO obj = new StationVO();
	    	obj.setStationNm(values[i]);
	    	lstDataView.add(obj);
	    }
		
		LocationAdapter adapter = new LocationAdapter(this,lstDataView);
		lstViewStation.setAdapter(adapter);
		
		//event item click
		
		lstViewStation.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Intent intent = new Intent(TripInfoActivity.this,
						TouristPlaceActivity.class);

				startActivity(intent);
				
			}
		});
		
		// add event button add location click 
		btnAddLocation = (Button)findViewById(R.id.btn_add_location);
		btnAddLocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent(getBaseContext(), TabTripDetail.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.trip_info, menu);
		return true;
	}

}
