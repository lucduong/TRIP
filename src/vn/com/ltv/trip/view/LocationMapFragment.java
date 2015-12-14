package vn.com.ltv.trip.view;

import vn.com.ltv.trip.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

public class LocationMapFragment extends Fragment {

	public LocationMapFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.item_location_menu_map,
				container, false);

		SupportMapFragment sup = (SupportMapFragment) getActivity()
				.getSupportFragmentManager().findFragmentById(R.id.map);
		sup.getMap();

		return view;
	}
}
