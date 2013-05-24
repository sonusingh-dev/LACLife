package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.ui.R;

public class SavingAmountActivity extends HomeBaseActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_savings_amount);

		Button btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, AddRiskActivity.class);
		startActivity(intent);
	}

}
