/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd
 *
 * Created  : Jan 19, 2014
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Jan 19, 2014    	   jack        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.adaptor;

import java.util.List;

import vn.com.ltv.dto.TripVO;
import vn.com.ltv.trip.R;
import vn.com.ltv.utils.Utils;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A common class extends from BaseAdapter that can be used for ListView for
 * contains Array Trip
 * 
 * @author Luc Duong
 * 
 */
public class TripAdapter extends BaseAdapter {
	private Context mContext;
	private List<TripVO> mTrips;
	private ITripItemClickListener mListener;

	public TripAdapter(Context context, List<TripVO> trips) {
		this.mContext = context;
		this.mTrips = trips;
	}

	public TripAdapter(Context context, List<TripVO> trips,
			ITripItemClickListener listener) {
		this.mContext = context;
		this.mTrips = trips;
		this.mListener = listener;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		if (view == null) {
			view = Utils.getView(mContext, R.layout.item_tour);
		}

		// ##### SET DATA #####
		//get item data
		TripVO tripVO = mTrips.get(position);
		
		LinearLayout imgThumb = (LinearLayout) view
				.findViewById(R.id.lnl_trp_thumb);
		imgThumb.setBackgroundResource(R.drawable.phuquoc);

		TextView txtDay = (TextView) view.findViewById(R.id.txt_day);
		txtDay.setText("10");
		TextView txtMnth = (TextView) view.findViewById(R.id.txt_month);
		txtMnth.setText("JANUARY");

		TextView txtNm = (TextView) view.findViewById(R.id.txt_trp_nm);
		txtNm.setText(tripVO.getTrpNm());
		
		TextView txtDuration = (TextView) view.findViewById(R.id.txt_duration);
		txtDuration.setText(tripVO.getStDt() +" ~ "+tripVO.getEndDt());
		
		TextView txtLike = (TextView) view.findViewById(R.id.txt_tour_like);
		if(tripVO.getLikeNo() != null &&  tripVO.getLikeNo() > 0)
			txtLike.setText(tripVO.getLikeNo()+"");
		
		TextView txtCmt = (TextView) view.findViewById(R.id.txt_cmt);
		if(tripVO.getCmtCnt() >0)
			txtCmt.setText(tripVO.getCmtCnt()+"");
		
		TextView txtMember = (TextView) view.findViewById(R.id.txt_member);
		if(tripVO.getMemCnt() >0)
			txtMember.setText(tripVO.getMemCnt()+"");
		
		// ##### END SET DATA #####

		// Set onCommentClick
		LinearLayout lnlCmt = (LinearLayout) view.findViewById(R.id.lnl_cmt);
		lnlCmt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mListener != null) {
					mListener.onCommentClick(v, mTrips.get(position));
				}
			}
		});

		// Set onItemClick
		LinearLayout lnlWrapper = (LinearLayout) view
				.findViewById(R.id.lnl_wrapper);
		lnlWrapper.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mListener != null) {
					mListener.onItemClick(v, mTrips.get(position));
				}
			}
		});

		return view;
	}

	@Override
	public int getCount() {
		return mTrips.size();
	}

	@Override
	public TripVO getItem(int position) {
		return mTrips.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mTrips.get(position).getTrpId();
	}

	/**
	 * Interface definition for a callback to be invoked when a trip is clicked
	 * 
	 * @author Luc Duong
	 * 
	 */
	public interface ITripItemClickListener {
		/**
		 * On trip click
		 * 
		 * @param view
		 * @param trip
		 */
		public void onItemClick(View view, TripVO trip);

		/**
		 * On trip comment click
		 * 
		 * @param view
		 * @param trip
		 */
		public void onCommentClick(View view, TripVO trip);
	}

}
