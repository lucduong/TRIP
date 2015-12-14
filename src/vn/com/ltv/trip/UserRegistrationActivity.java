package vn.com.ltv.trip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vn.com.ltv.common.Constants;
import vn.com.ltv.common.Decrypter;
import vn.com.ltv.common.HttpStatus;
import vn.com.ltv.dto.Session;
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

public class UserRegistrationActivity extends AbstractAsyncActivity {
	
	Button btnReset;
	Button btnRegister;
	private EditText txtFullName;
	private EditText txtEmail;
	private EditText txtPassword;
	private EditText txtRepeatPassword;
	private EditText txtTelPhone;
	private Decrypter DecrypterObj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_registration);

		btnReset = (Button) findViewById(R.id.btnReset);
		btnRegister = (Button) findViewById(R.id.btnRegister);

		txtFullName = (EditText) findViewById(R.id.txtFullName);
		txtEmail = (EditText) findViewById(R.id.txtEmail);
		txtPassword = (EditText) findViewById(R.id.txtPassword);
		txtRepeatPassword = (EditText) findViewById(R.id.txtRepeatPassword);
		txtTelPhone = (EditText) findViewById(R.id.txtTelPhone);
		try {
			DecrypterObj = new Decrypter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				resetInforamtion();
			}
		});

		btnRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				btnRegister_click();
			}
		});
	}

	/**
	 * reset all information in User Register
	 */
	private void resetInforamtion() {

		txtEmail.setText("");
		txtPassword.setText("");
		txtRepeatPassword.setText("");
		txtFullName.setText("");
		txtTelPhone.setText("");
	}
	
	/***
	 * 
	 * */
	private void btnRegister_click() {
		// if (!validateForm()) {
		// return;
		// }

		User userObj = new User();
		userObj.setUsrEml(txtEmail.getText().toString());
		// build the message object
		String passEncrypt = "";
		try {
			passEncrypt = DecrypterObj
					.encrypt(txtPassword.getText().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		userObj.setUsrPwd(passEncrypt);
		userObj.setUsrNm(txtFullName.getText().toString());

		LTVRest rest = new LTVRest();
		try {
			rest.executeURL(Constants.URL.USER_REGISTER, null, userObj,HttpMethod.POST.toString(),
					new ICallBack() {
						@Override
						public void complete(LTVResponse response) {
							dismissProgressDialog();
							if (response != null) {
								int status = (Integer) response.getAttribute(
										Constants.HttpStatus, Integer.class);
								if (HttpStatus.NO_CONTENT.value() ==status ) {
									Utils.showToast(getApplicationContext(),
											"Account da ton tai, vui long nhap account khac");
								}else
								{
									Session.userInfo = (User) response.getAttribute(
											"user", User.class);
									Intent i = new Intent(getBaseContext(),
											CreateTripActivity.class);
									startActivity(i);
								}							
							} 
						}

						@Override
						public void onload() {
							showLoadingProgressDialog();

						}
					});
		} catch (LTVRestException e) {
			Log.e(TAG, e.getMessage());
		}
	}
	/**
	 * 
	 * @return
	 */
	private Boolean validateForm() {
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		CharSequence text = "";

		if ("".equals(txtEmail.getText().toString())) {
			text = "Nhap Email";
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			txtEmail.requestFocus();
			return false;
		} else if (!emailValidator(txtEmail.getText().toString())) {
			text = "invalid email";
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			txtEmail.requestFocus();
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
//		Intent view = new Intent(getBaseContext(), LoginActivity.class);
//		startActivity(view);
		finish();
	}
}
