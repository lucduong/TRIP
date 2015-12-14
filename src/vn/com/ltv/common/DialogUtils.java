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
package vn.com.ltv.common;

import vn.com.ltv.trip.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class DialogUtils {

	public static Dialog createDlgComment(Context context,
			final IDialogCommentListener listener) {
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_comment);
		final EditText edtCmt = (EditText) dialog.findViewById(R.id.edt_cmt);
		final Button btnCmt = (Button) dialog.findViewById(R.id.btn_cmt);
		btnCmt.setVisibility(View.GONE);

		edtCmt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btnCmt.setVisibility(View.VISIBLE);
			}
		});

		btnCmt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if (listener != null) {
					listener.onCommented(edtCmt.getText());
				}
			}
		});
		return dialog;
	}

	public static Dialog createDlgComment(Context context, int view,
			final IDialogCommentListener listener) {
		Dialog dialog = new Dialog(context);
		dialog.setContentView(view);
		final EditText edtCmt = (EditText) dialog.findViewById(R.id.edt_cmt);
		Button btnCmt = (Button) dialog.findViewById(R.id.btn_cmt);
		btnCmt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (listener != null) {
					listener.onCommented(edtCmt.getText());
				}
			}
		});
		return dialog;
	}

	public interface IDialogListener {
		public void onClosed();
	}

	public interface IDialogCommentListener {
		public void onCommented(Object data);
	}
}
