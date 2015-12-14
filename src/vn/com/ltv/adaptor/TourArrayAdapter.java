package vn.com.ltv.adaptor;

import java.util.List;

import vn.com.ltv.dto.StationVO;
import vn.com.ltv.trip.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TourArrayAdapter extends ArrayAdapter<StationVO> {

	private final Context context;
	private final List<StationVO> values;
	private int itemLayoutId;

	public TourArrayAdapter(Context context, int itemLayoutId,
			List<StationVO> values) {
		super(context, itemLayoutId, values);
		this.context = context;
		this.values = values;
		this.itemLayoutId = itemLayoutId;

	}

	@SuppressLint("CutPasteId")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(this.itemLayoutId, parent, false);
		if (position == 0) {
			rowView.setSelected(true);
		}

		StationVO mVo = values.get(position);
		TextView mView = null;
		switch (this.itemLayoutId) {
		case R.layout.item_program:
			mView = (TextView) rowView.findViewById(R.id.txtPgmContent);
			break;
		case R.layout.item_day:
			mView = (TextView) rowView.findViewById(R.id.txtItemDay);
			// if(position == 0)
			// rowView.setBackgroundResource(R.drawable.selected_item_background);
			break;
		default:
			break;
		}

		if (mView != null) {
			mView.setText(mVo.getStationNm());
		}
		return rowView;
	}

	public interface ITourItemListener {
		public void itemClick(View view);

		public void commentClick(View view);
	}
}
