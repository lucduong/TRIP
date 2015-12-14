package vn.com.ltv.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class Utils {

	/***
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email) {

		Pattern pattern;
		Matcher matcher;
		String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();

	}

	/***
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String toString(InputStream inputStream) throws IOException {
		StringBuilder builder = new StringBuilder();
		if (inputStream == null) {
			return null;
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		String line = "";
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}

		return builder.toString();
	}

	/**
	 * Get view from xml file
	 * 
	 * @param context
	 * @return View
	 */
	public static View getView(Context context, int view) {
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		return mInflater.inflate(view, null);
	}

	public static void showToast(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}

	public static String convertStreamToString(InputStream inputStream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * merge url and params
	 * 
	 * @param url
	 * @param params
	 * @return String
	 */
	public static String getURL(String url, String... params) {
		StringBuilder urlBuilder = new StringBuilder();
		String[] urlSplit = url.split("%s");
		if (urlSplit.length == 1)
			return url;
		for (int i = 0; i < urlSplit.length - 1; i++) {
			urlBuilder.append(urlSplit[i]).append(params[i]);
		}
		urlBuilder.append(urlSplit[urlSplit.length - 1]);
		return urlBuilder.toString();
	}
}
