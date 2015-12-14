package vn.com.ltv.trip;

import java.util.List;
import java.util.Vector;

import vn.com.ltv.adaptor.PagerAdapter;
import vn.com.ltv.tab.TabCreateTrip;
import vn.com.ltv.tab.TabLocation;
import vn.com.ltv.tab.TabLocationMap;
import vn.com.ltv.tab.TabSchedule;
import vn.com.ltv.trip.view.LocationMapFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

//import vn.com.ltv.adaptor.PagerAdapter;

public class CreateTripActivity extends FragmentActivity implements
		OnTabChangeListener, OnPageChangeListener {
	// public class CreateTripActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;
	private ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trip_view_pager);

		this.initTabHost();

		if (savedInstanceState != null) {
			mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}
		this.initViewPager();
	}

	private void initTabHost() {
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		// mTabHost.setup(this, getSupportFragmentManager(),
		// R.id.realtabcontent);
		mTabHost.setup(this, getSupportFragmentManager());
		mTabHost.getTabWidget().setDividerDrawable(null);

		mTabHost.addTab(
				createTabSpec("Trip", R.drawable.btn_tab_search,
						"Thong tin chuyen di"), TabCreateTrip.class, null);

		mTabHost.addTab(
				createTabSpec("Info", R.drawable.btn_tab_search, "Xem lai"),
				TabSchedule.class, null);

		mTabHost.addTab(
				createTabSpec("Location", R.drawable.btn_tab_search, "Hoan tat"),
				TabLocation.class, null);

		mTabHost.addTab(
				createTabSpec("Map", R.drawable.btn_tab_search, "Ban do"),
				TabLocationMap.class, null);
		// ad event
		mTabHost.setOnTabChangedListener(this);
	}

	private void initViewPager() {

		List<Fragment> fragments = new Vector<Fragment>();
		fragments
				.add(Fragment.instantiate(this, TabCreateTrip.class.getName()));
		fragments.add(Fragment.instantiate(this, TabSchedule.class.getName()));
		fragments.add(Fragment.instantiate(this, TabLocation.class.getName()));
		fragments
				.add(Fragment.instantiate(this, TabLocationMap.class.getName()));

		this.mPagerAdapter = new PagerAdapter(
				super.getSupportFragmentManager(), fragments);
		this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
		this.mViewPager.setAdapter(this.mPagerAdapter);
		this.mViewPager.setOnPageChangeListener(this);
	}

	/**
	 * 
	 * Create TabSpec
	 * 
	 * @param resourceId
	 * @return
	 */
	private TabSpec createTabSpec(String tabId, int resourceId, String title) {
		TabSpec tabSpec = mTabHost.newTabSpec(tabId);
		View tabIndicator = LayoutInflater.from(this).inflate(
				R.layout.pager_tab, null);
		tabSpec.setIndicator(tabIndicator);
		return tabSpec;
	}

	//
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mTabHost = null;
		mViewPager = null;
		mPagerAdapter = null;
	}

	// @Override
	// public void onClick(String songId) {
	// Intent intent = new Intent(this, DetailActivity.class);
	// intent.putExtra("id", songId);
	// this.startActivity(intent);
	// }
	//
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {
		this.mTabHost.setCurrentTab(position);
	}

	@Override
	public void onTabChanged(String tabId) {
		int pos = this.mTabHost.getCurrentTab();
		this.mViewPager.setCurrentItem(pos);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("tab", mTabHost.getCurrentTabTag());
		super.onSaveInstanceState(outState);
	}

}
