package com.laclife.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;

public class RequirementsActivity extends BaseActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_requirements);

		final Button btnContinue = (Button) findViewById(R.id.btnContinue);
		btnContinue.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent registerIntent = new Intent(this, YourDetailsActivity.class);
		startActivity(registerIntent);
	}

}
