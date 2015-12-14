package vn.com.ltv.trip.view;

import java.util.ArrayList;
import java.util.List;

import vn.com.ltv.adaptor.TripAdapter;
import vn.com.ltv.adaptor.TripAdapter.ITripItemClickListener;
import vn.com.ltv.common.DialogUtils;
import vn.com.ltv.dto.TripVO;
import vn.com.ltv.trip.R;
import vn.com.ltv.trip.TripInfoActivity;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

@SuppressLint("NewApi")
public class HomeFragment extends Fragment implements ITripItemClickListener {
	private ListView listViewTours;

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_home, container, false);
		listViewTours = (ListView) view.findViewById(R.id.lst_view_tour);

		List<TripVO> trips = new ArrayList<TripVO>();
		trips.add(new TripVO(1, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"20-01-2014"));
		trips.add(new TripVO(2, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"17-01-2014"));
		trips.add(new TripVO(3, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));
		trips.add(new TripVO(4, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));
		trips.add(new TripVO(5, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));
		trips.add(new TripVO(6, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));
		trips.add(new TripVO(7, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));
		trips.add(new TripVO(8, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));
		trips.add(new TripVO(9, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));
		trips.add(new TripVO(10, "Du lich xuyen viet 2014", "", 20, 50, 5,
				"02-01-2014"));

		TripAdapter mAdapter = new TripAdapter(getActivity()
				.getApplicationContext(), trips, this);
		listViewTours.setAdapter(mAdapter);
		return view;
	}

	@Override
	public void onItemClick(View view, TripVO trip) {
		Intent intent = new Intent(getActivity().getBaseContext(),
				TripInfoActivity.class);

		startActivity(intent);
	}

	@SuppressWarnings("static-access")
	@Override
	public void onCommentClick(View view, TripVO trip) {
		new DialogUtils().createDlgComment(getActivity(), null).show();
	}
}
