package vn.com.ltv.trip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.com.ltv.common.Constants;
import vn.com.ltv.common.HttpStatus;
import vn.com.ltv.http.HttpMethod;
import vn.com.ltv.model.User;
import vn.com.ltv.response.LTVResponse;
import vn.com.ltv.rest.ICallBack;
import vn.com.ltv.rest.LTVRest;
import vn.com.ltv.rest.LTVRestException;
import vn.com.ltv.utils.AbstractAsyncActivity;
import vn.com.ltv.utils.Utils;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RetrievePasswordActivity extends AbstractAsyncActivity {

	private EditText tvEmail;
	private Button back_to_main;
	private Button send_me;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retrieve_password);

		tvEmail = (EditText) findViewById(R.id.editTextEmail);
		back_to_main = (Button) findViewById(R.id.btnBack);
		send_me = (Button) findViewById(R.id.btnSend);

		send_me.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				send_me_click();
			}
		});

		back_to_main.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				back_to_main_click();
			}
		});
	}

	/***
	 * 
	 */
	private void send_me_click() {
		// if (!validateForm()) {
		// return;
		// }

		User userObj = new User();
		userObj.setUsrEml(tvEmail.getText().toString());

		LTVRest ltvRest = new LTVRest();
		try {
			ltvRest.executeURL(Constants.URL.USER_RETRIVE_PASSWORD, null,
					userObj, HttpMethod.POST.toString(), new ICallBack() {

						@Override
						public void onload() {
							// TODO Auto-generated method stub

						}

						@Override
						public void complete(LTVResponse response) {
							dismissProgressDialog();
							if (response != null) {
								int status = (Integer) response.getAttribute(
										Constants.HttpStatus, Integer.class);
								if (HttpStatus.NO_CONTENT.value() ==status ) {
									Utils.showToast(getApplicationContext(),
											 "Sai Ten Hoac Password!");
								}else
								{
									Utils.showToast(getApplicationContext(),
											 "Mat khau da goi toi email cua ban");
								}
							}
						}
					});
		} catch (LTVRestException e) {
			Log.e(TAG, e.getMessage());
		}
		//
		// try {
		// rest.post(Constants.URL.USER_RETRIVE_PASSWORD, null, userObj,
		// new ICallBack<User>() {
		// @Override
		// public void complete(User result) {
		// if (result != null) {
		// Utils.showToast(getApplicationContext(),
		// "Mat khau da goi toi email cua ban");
		// } else {
		// Utils.showToast(getApplicationContext(),
		// "Sai Ten Hoac Password!");
		// }
		// }
		// });
		// } catch (LTVRestException e) {
		// Log.e(TAG, e.getMessage());
		// }
	}

	/**
	 * 
	 * @return
	 */
	private Boolean validateForm() {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		CharSequence text = "";

		if ("".equals(tvEmail.getText().toString())) {
			text = "Nhap Email";
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			tvEmail.requestFocus();
			return false;
		} else if (!emailValidator(tvEmail.getText().toString())) {
			text = "invalid email";
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			tvEmail.requestFocus();
			return false;
		}
		return true;
	}

	/***
	 * 
	 * @param email
	 * @return
	 */
	public boolean emailValidator(String email) {
		Pattern pattern;
		Matcher matcher;
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/***
	 * 
	 */
	private void back_to_main_click() {
		Log.i("RetrievePasswordActivity", "back_to_main_click");
		Intent view = new Intent(getBaseContext(), LoginActivity.class);
		startActivity(view);
		finish();
	}
}
