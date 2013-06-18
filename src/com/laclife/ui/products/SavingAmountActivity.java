package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.laclife.Constant.CalculateQuote;
import com.laclife.LACLifeApplication;
import com.laclife.model.calculatequote.CalculateQuoteModel;
import com.laclife.ui.R;

public class SavingAmountActivity extends HomeBaseActivity implements
		OnClickListener, OnItemSelectedListener {

	int cover;
	int frequency;

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

		edtSavings = (EditText) findViewById(R.id.edtSavings);

		spnCoverPeriod = (Spinner) findViewById(R.id.spnCoverPeriod);
		spnPayFrequency = (Spinner) findViewById(R.id.spnPayFrequency);

		Button btnNext = (Button) findViewById(R.id.btnNext);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> coverPeriodAdapter = ArrayAdapter
				.createFromResource(this, R.array.cover_period_array,
						R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> payFrequencyAdapter = ArrayAdapter
				.createFromResource(this, R.array.pay_frequency_array,
						R.layout.simple_spinner_item);

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

	}

	@Override
	public void onClick(View v) {
		// Intent intent = new Intent(this, AddRiskActivity.class);
		// startActivity(intent);

		validate();
	}

	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		if (view == spnCoverPeriod) {
			cover = pos;
		} else if (view == spnPayFrequency) {
			frequency = pos;
		}
		// An item was selected. You can retrieve the selected item using
		// parent.getItemAtPosition(pos)
	}

	public void onNothingSelected(AdapterView<?> parent) {
		// Another interface callback
	}

	private void validate() {

		String savings = edtSavings.getText().toString();
		if (TextUtils.isEmpty(savings)) {
			shortToast("Please enter the desired yearly savings");
			return;
		}

		String[] coverPeriodArray = getResources().getStringArray(
				R.array.sort_cover_period_array);
		String[] payFrequencyArray = getResources().getStringArray(
				R.array.sort_pay_frequency_array);

		Intent intent = getIntent();
		CalculateQuoteModel calculateQuote = (CalculateQuoteModel) intent
				.getSerializableExtra(CalculateQuote.KEY_QUOTE);
		calculateQuote.setMaturityYears(coverPeriodArray[cover]);
		calculateQuote.setPremiumFrequency(payFrequencyArray[frequency]);

		intent.setClass(this, AddRiskActivity.class);
		intent.putExtra(CalculateQuote.KEY_QUOTE, calculateQuote);
		startActivity(intent);
	}
}
