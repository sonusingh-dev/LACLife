package com.laclife.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;

public class RegisterActivity extends BaseActivity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		final Button btnGetStarted = (Button) findViewById(R.id.btnGetStarted);
		btnGetStarted.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent registerIntent = new Intent(this, RequirementsActivity.class);
		startActivity(registerIntent);
	}

}
