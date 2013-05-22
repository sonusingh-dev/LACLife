package com.laclife.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;

/*
 * All activity extends BaseActivity and it set background image for ActionBar.
 */
public class HomeBaseActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock);
		super.onCreate(savedInstanceState);

		// // set background image for ActionBar
		// ActionBar actionBar = getSupportActionBar();
		// actionBar.setBackgroundDrawable(getResources().getDrawable(
		// R.drawable.et_actionbar_background));
		//
		// // register for logout.
		// registerReceiver(logoutReceiver, new IntentFilter(
		// Constants.ACTION_LOGOUT));
		//
		// if (!Utilities.isNetworkAvailable(this)) {
		// AlertsUtilities.showNetworkToast(this);
		// }

	}

	// once user click on logout button it will destroy all activity as well as
	// session.
	private BroadcastReceiver logoutReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			finish();
		}
	};

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// int itemId = item.getItemId();
	// if (itemId == android.R.id.home) {
	// Intent intent = new Intent(this, HomeActivity.class);
	// intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	// startActivity(intent);
	// }
	// return super.onOptionsItemSelected(item);
	// }

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
		// unregisterReceiver(logoutReceiver);
	}
}
