package com.laclife.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

/*
 * All activity extends BaseActivity and it set background image for ActionBar.
 */
public class BaseActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock);
		super.onCreate(savedInstanceState);

		setActionBarBackground(R.drawable.horizontal_yellow_bar);
	}

	// set title for ActionBar
	protected void setActionBarTitle(String title) {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(title);
	}

	// set background image for ActionBar
	protected void setActionBarBackground(int drawable) {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.horizontal_yellow_bar));
	}

	// set background image for ActionBar
	protected void setActionBarBackgroundColor(int color) {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(color));
	}

	public void shortToast(String text) {
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
				.show();
	}

	protected void longToast(String text) {
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
	}

	protected void log(Object msg) {
		Log.d(getClass().getCanonicalName(), "" + msg);
	}

	protected void logDebug(String tag, String msg) {
		Log.d(tag, msg);
	}

	protected void logError(String tag, String msg) {
		Log.e(tag, msg);
	}

	protected void logInfo(String tag, String msg) {
		Log.i(tag, msg);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
