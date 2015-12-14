package vn.com.ltv.adaptor;

import java.util.List;

import vn.com.ltv.model.NavigationItem;
import vn.com.ltv.trip.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationAdapter extends BaseAdapter {

	private Context mContext;
	private List<NavigationItem> mItems;

	public NavigationAdapter(Context context, List<NavigationItem> items) {
		this.mContext = context;
		this.mItems = items;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (view == null) {
			LayoutInflater mInflater = (LayoutInflater) mContext
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			view = mInflater.inflate(R.layout.navigation_item, null);
		}
		ImageView ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
		TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
		TextView tvCounter = (TextView) view.findViewById(R.id.tv_counter);
		ivIcon.setImageResource(mItems.get(position).getIcon());
		tvTitle.setText(mItems.get(position).getTitle());
		int count = mItems.get(position).getCount();
		if (count > 0) {
			tvCounter.setText(count < 100 ? count + "" : "99+");
		} else {
			tvCounter.setVisibility(View.GONE);
		}
		return view;
	}
}
