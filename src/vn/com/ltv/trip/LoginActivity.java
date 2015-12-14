package vn.com.ltv.trip;

import vn.com.ltv.common.Constants;
import vn.com.ltv.common.Decrypter;
import vn.com.ltv.common.HttpStatus;
import vn.com.ltv.http.HttpMethod;
import vn.com.ltv.model.User;
import vn.com.ltv.response.LTVResponse;
import vn.com.ltv.rest.ICallBack;
import vn.com.ltv.rest.LTVRest;
import vn.com.ltv.rest.LTVRestException;
import vn.com.ltv.utils.AbstractAsyncActivity;
import vn.com.ltv.utils.Utils;
import android.R.string;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AbstractAsyncActivity {

	private EditText txtUserName;
	private EditText txtPassword;
	private EditText txt_Message;
	private TextView txtForgetPwd;
	private Button txtRegister;
	private Button btnLogin;
	private Decrypter DecrypterObj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		try {
			DecrypterObj = new Decrypter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtUserName = (EditText) findViewById(R.id.txt_loginUserName);
		txtPassword = (EditText) findViewById(R.id.txt_loginPassword);
		// txt_Message = (EditText) findViewById(R.id.txt_loginMessage);

		//Get password
		txtForgetPwd = (TextView) findViewById(R.id.txtForgetPwd);
		txtForgetPwd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(getBaseContext(),
						RetrievePasswordActivity.class);
				startActivity(i);
			}
		});
		try{
		Long userID;
		SharedPreferences restoredText = getApplicationContext().getSharedPreferences("USER_INFO", MODE_PRIVATE);		
		if (restoredText != null) 
		{
			userID =	restoredText.getLong(Constants.USR_INFO.USER_ID, 0);		 
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		// add event click
		txtRegister = (Button) findViewById(R.id.btnRegister);
		txtRegister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i(LoginActivity.class.getName(), "onClick");

				Intent i = new Intent(getBaseContext(),
						UserRegistrationActivity.class);
				startActivity(i);
			}
		});

		// event login
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				btnLogin_click();
			}
		});
	}

	/***
	 * 
	 */
	private void btnLogin_click() {
		if ("".equals(txtUserName.getText().toString())) {
			Toast.makeText(getApplicationContext(), "Nhap Ten",
					Toast.LENGTH_SHORT).show();
			txtUserName.requestFocus();
			return;
		}

		if ("".equals(txtPassword.getText().toString())) {
			Toast.makeText(getApplicationContext(), "Nhap Pass",
					Toast.LENGTH_SHORT).show();
			txtPassword.requestFocus();
			return;
		}

		User userObj = new User();

		// build the message object
		String passEncrypt = "";
		try {
			passEncrypt = DecrypterObj
					.encrypt(txtPassword.getText().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		userObj.setUsrEml(txtUserName.getText().toString());
		userObj.setUsrPwd(passEncrypt);

		LTVRest rest = new LTVRest();
		try {
			rest.executeURL(Constants.URL.USER_LOGIN, null, userObj,
					HttpMethod.POST.toString(), new ICallBack() {
						@Override
						public void complete(LTVResponse response) {
							dismissProgressDialog();
							if (response != null) {
								int status = (Integer) response.getAttribute(
										Constants.HttpStatus, Integer.class);
								if (HttpStatus.NO_CONTENT.value() ==status ) {
									Utils.showToast(getApplicationContext(),
											"Sai Ten Hoac Password!");
								} else {
									User usr= (User) response
											.getAttribute("user", User.class);
									try{
									 //give share memory name and mode
									SharedPreferences pref = getApplicationContext().getSharedPreferences("USER_INFO", MODE_PRIVATE);
									Editor editor = pref.edit();
									
									editor.putLong(Constants.USR_INFO.USER_ID, usr.getUsrId());
									editor.putString(Constants.USR_INFO.USER_NM, usr.getUsrNm());
									editor.putString(Constants.USR_INFO.USER_EML, usr.getUsrEml());
									editor.commit();
								    
									Intent i = new Intent(getBaseContext(),
											MainActivity.class);
									startActivity(i);
									}catch(Exception ex){
										ex.printStackTrace();
									}
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
}
