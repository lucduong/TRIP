package vn.com.ltv.trip;

import java.util.ArrayList;
import java.util.List;

import vn.com.ltv.adaptor.TourArrayAdapter;
import vn.com.ltv.dto.StationVO;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TouristPlaceActivity extends Activity implements
		OnItemClickListener {

	private ListView listProgram;
	private ListView listViewDay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tourist_place);

		listProgram = (ListView) findViewById(R.id.listViewProgram);

		String[] values = new String[] { "Ăn sáng", "Đi tham quan vịnh",
				"Đi chơi lòng vòng", "Ăn cơm trưa", "Giờ tự do", "Trả phòng",
				"Quay lại bến tàu" };

		String[] hours = new String[] { "07:00", "08:00", "10:00", "11:30",
				"12:00", "01:30", "02:00" };

		String[] days = new String[] { "22", "23", "24", "25" };

		List<StationVO> lstDataView = new ArrayList<StationVO>();

		for (int i = 0; i < values.length; ++i) {
			StationVO obj = new StationVO();
			obj.setStationNm(values[i]);
			obj.setDescription(hours[i]);
			lstDataView.add(obj);
		}

		List<StationVO> lstDays = new ArrayList<StationVO>();

		for (int i = 0; i < days.length; ++i) {
			StationVO obj = new StationVO();
			obj.setStationNm(days[i]);
			lstDays.add(obj);
		}


		TourArrayAdapter adapter = new TourArrayAdapter(this,
				R.layout.item_program, lstDataView);
		listProgram.setAdapter(adapter);

		listViewDay = (ListView) findViewById(R.id.listViewDay);
		TourArrayAdapter adapterDay = new TourArrayAdapter(this,
				R.layout.item_day, lstDays);
		listViewDay.setAdapter(adapterDay);
		
		listViewDay.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {
            	
            }
        });
		
		listViewDay.setItemChecked(0, true);
		listViewDay.setSelection(0);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {

	}
}
