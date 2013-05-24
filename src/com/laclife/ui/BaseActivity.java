package com.laclife.ui;

import android.os.Bundle;

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
	}

	// set title for ActionBar
	protected void setActionBarTitle(String title) {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(title);
	}

	// set background image for ActionBar
	protected void setActionBarTitle(int drawable) {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(drawable));
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
