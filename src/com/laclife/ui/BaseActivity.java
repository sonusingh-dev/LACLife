package com.laclife.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.slidingmenu.actionbar.ActionBarActivity;

public class BaseActivity extends ActionBarActivity implements OnCancelListener {

	private ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// set title for ActionBar
	protected void setActionBarTitle(String title) {
		setTitle(title);
	}

	protected void log(Object msg) {
		Log.d(getClass().getCanonicalName(), "" + msg);
	}

	protected void logD(String tag, String msg) {
		Log.d(tag, msg);
	}

	protected void logE(String tag, String msg) {
		Log.e(tag, msg);
	}

	protected void logI(String tag, String msg) {
		Log.i(tag, msg);
	}

	public void shortToast(String text) {
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
				.show();
	}

	protected void longToast(String text) {
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
	}

	public void showProgressDialog() {
		mProgressDialog = ProgressDialog.show(this, "",
				getString(R.string.alert_please_wait), false, true, this);
	}

	public void showProgressDialog(String title) {
		mProgressDialog = ProgressDialog.show(this, title,
				getString(R.string.alert_please_wait), false, true, this);
	}

	public void showProgressDialog(String title, String message) {
		mProgressDialog = ProgressDialog.show(this, title, message, false,
				true, this);
	}

	public void dismissProgressDialog() {
		if (mProgressDialog != null && mProgressDialog.isShowing()) {
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
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

	@Override
	public void onCancel(DialogInterface dialog) {
		if (mProgressDialog != null && mProgressDialog.isShowing()) {
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}
}
