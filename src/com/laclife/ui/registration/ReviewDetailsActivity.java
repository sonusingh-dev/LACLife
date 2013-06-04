package com.laclife.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;
import com.laclife.ui.login.LoginActivity;

public class ReviewDetailsActivity extends BaseActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review_details);

		Button btnSubmitDetails = (Button) findViewById(R.id.btnSubmitDetails);
		btnSubmitDetails.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		validate();
	}
	
	private void validate() {
		Intent productsIntent = new Intent(this, LoginActivity.class);
		startActivity(productsIntent);
	}

}
