package com.laclife.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.slidingmenu.actionbar.ActionBarActivity;

/*
 * All activity extends BaseActivity and it set background image for ActionBar.
 */
public class BaseActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// set title for ActionBar
	protected void setActionBarTitle(String title) {
		// setTitle(title);
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
