package vn.com.ltv.adaptor;

import vn.com.ltv.trip.R;
import vn.com.ltv.utils.Utils;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemDayAdapter extends BaseAdapter{
	private int[] days;
	private Context mContext;
	private ItemDayListener mListener;

	public ItemDayAdapter(Context context, int[]days) {
		this.mContext = context;
		this.days = days;
	}
	public ItemDayAdapter(Context context, int[]days, ItemDayListener listener) {
		this.mContext = context;
		this.days = days;
		mListener = listener;
	}
	
	@Override
	public int getCount() {
		return days.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return days[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		if (view == null) {
			view = Utils.getView(mContext, R.layout.item_day);
		}
		TextView mView = (TextView) view.findViewById(R.id.txtItemDay);
		mView.setText(days[position]+"");
		
		LinearLayout lnl = (LinearLayout) view.findViewById(R.id.lnl_itemDay);
		lnl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v !=null)
					mListener.onItemDayClick(v, (Integer)getItem(position));
				
			}
		});
		return view;
	}

	public interface ItemDayListener{
		public void onItemDayClick(View view, int key);
	}
}
