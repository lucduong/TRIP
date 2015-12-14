/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd
 *
 * Created  : Dec 20, 2013
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Dec 20, 2013    	   Luc Duong        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import vn.com.ltv.trip.R;

public class FavoriteView extends ImageView {

	private boolean isLiked;
	private Drawable mImgUnlike;
	private Drawable mImgLiked;
	private IFavoriteChangeListener mListener;

	/**
	 * Initialization an object with context
	 * 
	 * @param context
	 */
	public FavoriteView(Context context) {
		super(context);
		setLiked(false);
	}

	/**
	 * Initialization an object with context, attribute
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public FavoriteView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setLiked(false);
	}

	/**
	 * Initialization an object with context, attribute
	 * 
	 * @param context
	 * @param attrs
	 */
	public FavoriteView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.FavoriteView, 0, 0);
		mImgLiked = typedArray.getDrawable(R.styleable.FavoriteView_imageLiked);
		mImgUnlike = typedArray
				.getDrawable(R.styleable.FavoriteView_imageUnlike);
		setLiked(false);
		typedArray.recycle();
	}

	/**
	 * Check status of this favorite
	 * 
	 * @return true / false
	 */
	public boolean isLiked() {
		return isLiked;
	}

	/**
	 * Set favorite status (like or unlike)
	 * 
	 * @param true / false
	 */
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
		this.setImageDrawable(this.isLiked ? mImgLiked : mImgUnlike);
		this.invalidate();
		if (mListener != null) {
			mListener.onChange(this.isLiked);
		}
	}

	/**
	 * Register a callback to be invoked when favorite is changed.
	 * 
	 * @param listener
	 */
	public void setOnFavoriteChangeListener(IFavoriteChangeListener listener) {
		this.mListener = listener;
	}

	/**
	 * Interface definition for a callback to be invoked when favorite is
	 * changed.
	 * 
	 * @author Luc.Duong
	 * 
	 */
	public interface IFavoriteChangeListener {
		/**
		 * Called when favorite has been changed.
		 * 
		 * @param value
		 */
		void onChange(boolean value);
	}
}