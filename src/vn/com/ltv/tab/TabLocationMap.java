package vn.com.ltv.tab;

import java.util.ArrayList;
import java.util.List;

import vn.com.ltv.adaptor.LocationAdapter;
import vn.com.ltv.dto.StationVO;
import vn.com.ltv.trip.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TabLocationMap extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.tab_location_map, null);

		String[] values = new String[] { "Sai gon", "Vung tau",
				"Hoi An", "Hue", "Quang tri", "Ha noi", "Sapa" };

		List<StationVO> lstDataView = new ArrayList<StationVO>();

		for (int i = 0; i < values.length; ++i) {
			StationVO obj = new StationVO();
			obj.setStationNm(values[i]);
			lstDataView.add(obj);
		}
		ListView lstViewStation = (ListView) view.findViewById(R.id.lst_view_location);
		LocationAdapter adapter = new LocationAdapter(getActivity(), lstDataView);
		lstViewStation.setAdapter(adapter);

		return view;
	}

}
