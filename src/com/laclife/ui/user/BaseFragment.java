package com.laclife.ui.user;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

public class BaseFragment extends Fragment {

	// set title for ActionBar
	protected void setActionBarTitle(String title) {
		getActivity().setTitle(title);
	}

	public void shortToast(String text) {
		Toast.makeText(getActivity().getApplicationContext(), text,
				Toast.LENGTH_SHORT).show();
	}

	protected void longToast(String text) {
		Toast.makeText(getActivity().getApplicationContext(), text,
				Toast.LENGTH_LONG).show();
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
}
