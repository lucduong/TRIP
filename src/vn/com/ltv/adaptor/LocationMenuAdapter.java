package vn.com.ltv.adaptor;

import vn.com.ltv.trip.R;
import vn.com.ltv.utils.Utils;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Load data for List view on activity_location UI
 * @author tu.tran
 *
 */
public class LocationMenuAdapter extends BaseAdapter{

	private Context _context;
	private ILocationMenuItemClickListener _locationMenuListener;
	private int[] _imgRscMenuId;
	public LocationMenuAdapter(Context context,int [] imgRscMenuId)
	{
		this._context = context;
		this._imgRscMenuId = imgRscMenuId;
	}
	public LocationMenuAdapter(Context context, int [] imgRscMenuId,ILocationMenuItemClickListener listener)
	{
		this._context = context;
		this._locationMenuListener = listener;
		this._imgRscMenuId = imgRscMenuId;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _imgRscMenuId.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return _imgRscMenuId[position];
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = Utils.getView(_context, R.layout.item_location_menu);
			
			LinearLayout lnlLocationMenu = (LinearLayout) convertView.findViewById(R.id.lnl_location_menu);
			lnlLocationMenu.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(_locationMenuListener != null)
						_locationMenuListener.onItemLocationMenuClick(v,position);
				}
			});
			
			// set image
			ImageView imgMenu = (ImageView) convertView.findViewById(R.id.img_location_menu);
			imgMenu.setImageResource(_imgRscMenuId[position]);
		}
		return convertView;
	}

	/**
	 * Interface definition for a dispatch event location menu item click to UI caller
	 * 
	 * 
	 */
	public interface ILocationMenuItemClickListener{
		public void onItemLocationMenuClick(View view, int position);
		
	}
}
