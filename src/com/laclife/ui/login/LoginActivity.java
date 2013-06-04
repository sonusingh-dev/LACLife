package com.laclife.ui.login;

import android.content.Intent;
import android.os.Bundle;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;

public class LoginActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	private void validate() {
		Intent productsIntent = new Intent(this, SlidingMenuBaseActivity.class);
		startActivity(productsIntent);
	}

}
