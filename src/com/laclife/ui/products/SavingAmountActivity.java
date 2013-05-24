package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.laclife.LACLifeApplication;
import com.laclife.ui.R;

public class SavingAmountActivity extends HomeBaseActivity implements
		OnClickListener, OnItemSelectedListener {

	private EditText edtSavings;

	private Spinner spnCoverPeriod;
	private Spinner spnPayFrequency;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_savings_amount);

		String product = ((LACLifeApplication) getApplication())
				.getProductQuote();
		setActionBarTitle(product);

		TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
		
		edtSavings = (EditText) findViewById(R.id.edtSavings);

		spnCoverPeriod = (Spinner) findViewById(R.id.spnCoverPeriod);
		spnPayFrequency = (Spinner) findViewById(R.id.spnPayFrequency);

		Button btnNext = (Button) findViewById(R.id.btnNext);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> coverPeriodAdapter = ArrayAdapter
				.createFromResource(this, R.array.covder_period_array,
						android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> payFrequencyAdapter = ArrayAdapter
				.createFromResource(this, R.array.pay_frequency_array,
						android.R.layout.simple_spinner_item);

		// Specify the layout to use when the list of choices appears
		coverPeriodAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		payFrequencyAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// Apply the adapter to the spinner
		spnCoverPeriod.setAdapter(coverPeriodAdapter);
		spnPayFrequency.setAdapter(payFrequencyAdapter);

		spnCoverPeriod.setOnItemSelectedListener(this);
		btnNext.setOnClickListener(this);
		
		txtTitle.setText(R.string.des_tell_us_how_);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, AddRiskActivity.class);
		startActivity(intent);
	}

	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// An item was selected. You can retrieve the selected item using
		// parent.getItemAtPosition(pos)
	}

	public void onNothingSelected(AdapterView<?> parent) {
		// Another interface callback
	}

	private void validate() {

	}

}
