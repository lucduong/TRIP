package vn.com.ltv.adaptor;

import java.util.List;

import vn.com.ltv.dto.StationVO;
import vn.com.ltv.trip.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ScheduleAdapter extends ArrayAdapter<StationVO>{



	private final Context context;
	private final List<StationVO> values;
	
	
	public ScheduleAdapter(Context context, List<StationVO> values) {
		super(context, R.layout.item_schedule, values);
		this.context = context;
		this.values = values;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.item_schedule, parent, false);
		
		TextView textView = (TextView) rowView.findViewById(R.id.station_nm);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img_item);
		imageView.setBackgroundResource(R.drawable.ic_bicycle);
		
		StationVO obj = values.get(position);
		textView.setText(obj.getStationNm());

		return rowView;
	}

}
