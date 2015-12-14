package vn.com.ltv.tab;

import vn.com.ltv.trip.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class TabTripDetail extends Fragment implements OnTabChangeListener {

	private FragmentTabHost _tabHost;
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.tab_trip_detail, null);

		this.initTabHost();

		if (savedInstanceState != null) {
			_tabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}

		return view;
	}

	private void initTabHost() {
		_tabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
		_tabHost.setup(view.getContext(), getActivity()
				.getSupportFragmentManager(), android.R.id.tabcontent);
		// _tabHost.getTabWidget().setDividerDrawable(null);

		_tabHost.addTab(
				createTabSpec("Location Detail", R.drawable.ic_calendar,
						"Thong tin chuyen di"), TabLocation.class, null);

		_tabHost.addTab(createTabSpec("Info", R.drawable.ic_camera, "Xem lai"),
				TabLocation.class, null);

		// ad event
		_tabHost.setOnTabChangedListener(this);
	}

	private TabSpec createTabSpec(String tabId, int resourceId, String title) {
		TabSpec tabSpec = _tabHost.newTabSpec(tabId);
		View tabIndicator = LayoutInflater.from(getActivity()).inflate(
				R.layout.tab, null);
		((ImageView) tabIndicator.findViewById(R.id.btnImg))
				.setImageResource(resourceId);
		tabSpec.setIndicator(tabIndicator);
		return tabSpec;
	}

	// @Override
	// protected void onDestroy() {
	// super.onDestroy();
	// _tabHost = null;
	// }

	@Override
	public void onTabChanged(String tabId) {
		// int pos = this._tabHost.getCurrentTab();

	}

	// @Override
	// protected void onSaveInstanceState(Bundle outState) {
	// outState.putString("tab", _tabHost.getCurrentTabTag());
	// super.onSaveInstanceState(outState);
	// }
}
