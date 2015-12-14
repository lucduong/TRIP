/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 LTV Co., Ltd
 *
 * Create Date  : Dec 13, 2013
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Dec 13, 2013    	   Luc Duong        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.trip;

import java.util.ArrayList;
import java.util.List;

import vn.com.ltv.adaptor.NavigationAdapter;
import vn.com.ltv.model.NavigationItem;
import vn.com.ltv.trip.view.HomeFragment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements
		ListView.OnItemClickListener {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private LinearLayout mNavWrapper;

	private List<NavigationItem> mNavigationItems;
	private NavigationAdapter mNavigationAdapter;

	private String[] mMenuTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		 Get menu titles
		mMenuTitles = getResources().getStringArray(R.array.navigation_items);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
		mNavWrapper = (LinearLayout) findViewById(R.id.left_drawer);

		// Menu items
		mNavigationItems = new ArrayList<NavigationItem>();
		mNavigationItems.add(new NavigationItem(mMenuTitles[0],
				R.drawable.ic_nav_home));
		mNavigationItems.add(new NavigationItem(mMenuTitles[1],
				R.drawable.ic_nav_notification, 100));
		mNavigationItems.add(new NavigationItem(mMenuTitles[2],
				R.drawable.ic_nav_calendar));
		mNavigationItems.add(new NavigationItem(mMenuTitles[3],
				R.drawable.ic_nav_location_add));
		mNavigationItems.add(new NavigationItem(mMenuTitles[4],
				R.drawable.ic_nav_search));
		mNavigationItems.add(new NavigationItem(mMenuTitles[5],
				R.drawable.ic_nav_location, 15));
		mNavigationItems.add(new NavigationItem(mMenuTitles[6],
				R.drawable.ic_nav_user));

		//
		mDrawerList.setOnItemClickListener(this);
		mNavigationAdapter = new NavigationAdapter(getApplicationContext(),
				mNavigationItems);
		mDrawerList.setAdapter(mNavigationAdapter);
		
		HomeFragment fragment = new HomeFragment();
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.frame_container, fragment).commit();
		mDrawerLayout.closeDrawer(mNavWrapper);
	}

	@SuppressLint("NewApi")
	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {
//		Fragment fragment = null;
//		switch (position) {
//		case 0:
//			fragment = new HomeFragment();
//			break;
//		case 1:
//			break;
//		case 2:
//			break;
//		case 3:
//			break;
//		case 4:
//			break;
//		case 5:
//			break;
//
//		default:
//			break;
//		}
//
//		if (fragment != null) {
//			FragmentManager fragmentManager = getFragmentManager();
//			fragmentManager.beginTransaction()
//					.replace(R.id.frame_container, fragment).commit();
//
//			Toast.makeText(getBaseContext(),
//					"Clicked to " + mMenuTitles[position], Toast.LENGTH_SHORT)
//					.show();
//			mDrawerLayout.closeDrawer(mNavWrapper);
//			mDrawerList.setItemChecked(position, true);
//			mDrawerList.setSelection(position);
//		} else {
//			// error in creating fragment
//			Log.e("MainActivity", "Error in creating fragment");
//		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			if (mDrawerLayout != null && mNavWrapper != null) {
				if (mDrawerLayout.isDrawerOpen(mNavWrapper)) {
					mDrawerLayout.closeDrawer(mNavWrapper);
				} else {
					mDrawerLayout.openDrawer(mNavWrapper);
				}
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
