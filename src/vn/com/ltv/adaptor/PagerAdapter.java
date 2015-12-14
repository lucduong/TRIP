/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd
 *
 * Created  : Feb 9, 2013
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Feb 9, 2013    	   Luc Duong        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.adaptor;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> fragments;

	public PagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return this.fragments.get(position);
	}

	@Override
	public int getCount() {
		return this.fragments.size();
	}
}
