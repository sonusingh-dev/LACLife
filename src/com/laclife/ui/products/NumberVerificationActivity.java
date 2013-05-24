package com.laclife.ui.products;

import android.os.Bundle;
import android.widget.Button;

import com.laclife.ui.R;

public class NumberVerificationActivity extends HomeBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_number_verification);

		Button btnGetQuote = (Button) findViewById(R.id.btnGetQuote);
	}

}
