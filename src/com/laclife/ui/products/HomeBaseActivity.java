package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.HomeActivity;

/*
 * All activity extends BaseActivity and it set background image for ActionBar.
 */
public class HomeBaseActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			Intent intent = new Intent(this, HomeActivity.class);
			// intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
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
