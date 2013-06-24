package com.laclife.ui.login;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.laclife.ui.R;

public class BaseFragment extends Fragment implements OnCancelListener {

	private ProgressDialog mProgressDialog;

	// set title for ActionBar
	protected void setActionBarTitle(String title) {
		getActivity().setTitle(title);
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
		Toast.makeText(getActivity().getApplicationContext(), text,
				Toast.LENGTH_SHORT).show();
	}

	protected void longToast(String text) {
		Toast.makeText(getActivity().getApplicationContext(), text,
				Toast.LENGTH_LONG).show();
	}

	public void showProgressDialog() {
		mProgressDialog = ProgressDialog.show(getActivity(), "",
				getString(R.string.alert_please_wait), false, true, this);
	}

	public void showProgressDialog(String title) {
		mProgressDialog = ProgressDialog.show(getActivity(), title,
				getString(R.string.alert_please_wait), false, true, this);
	}

	public void showProgressDialog(String title, String message) {
		mProgressDialog = ProgressDialog.show(getActivity(), title, message,
				false, true, this);
	}

	public void dismissProgressDialog() {
		if (mProgressDialog != null && mProgressDialog.isShowing()) {
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		if (mProgressDialog != null && mProgressDialog.isShowing()) {
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}
}
