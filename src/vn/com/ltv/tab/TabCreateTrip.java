package vn.com.ltv.tab;

import java.util.ArrayList;
import java.util.List;

import vn.com.ltv.adaptor.CreateTripLocationAdapter;
import vn.com.ltv.component.FavoriteView;
import vn.com.ltv.dto.StationVO;
import vn.com.ltv.trip.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TabCreateTrip extends Fragment {

	private View view;

	// private View calendarView;
	// private Dialog calendar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = LayoutInflater.from(getActivity()).inflate(
				R.layout.tab_create_trip, null);

		ListView lstViewStation = (ListView) view
				.findViewById(R.id.listView_attraction);

		String[] values = new String[] { "SÃ i GÃ²n", "Ä�Ã  Náºµng", "Há»™i An" };

		List<StationVO> lstDataView = new ArrayList<StationVO>();

		for (int i = 0; i < values.length; ++i) {
			StationVO obj = new StationVO();
			obj.setStationNm(values[i]);
			lstDataView.add(obj);
		}

		CreateTripLocationAdapter adapter = new CreateTripLocationAdapter(
				view.getContext(), lstDataView);
		lstViewStation.setAdapter(adapter);

		FavoriteView fvtView = (FavoriteView) view.findViewById(R.id.cmp_title);
		fvtView.setLiked(true);

		return view;
	}

}
