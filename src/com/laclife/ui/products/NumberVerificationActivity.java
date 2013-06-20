package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.Constant.Products;
import com.laclife.ui.R;

public class NumberVerificationActivity extends HomeBaseActivity implements
		OnClickListener {

	private Intent mIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number_verification);

		mIntent = getIntent();
		String product = mIntent.getStringExtra(Products.KEY_NAME_SORT_QUOTE);
		setActionBarTitle(product);

		Button btnGetQuote = (Button) findViewById(R.id.btnGetQuote);
		btnGetQuote.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		mIntent.setClass(this, FinalQuoteActivity.class);
		startActivity(mIntent);
	}

	private void validate() {

	}

}
