package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.ui.R;

public class AddRiskActivity extends HomeBaseActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_risk);

		Button btnGetQuote = (Button) findViewById(R.id.btnGetQuote);
		btnGetQuote.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent = new Intent(this, NumberVerificationActivity.class);
		startActivity(intent);
	}

}
