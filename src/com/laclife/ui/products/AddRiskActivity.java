package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

import com.laclife.LACLifeApplication;
import com.laclife.ui.R;

public class AddRiskActivity extends HomeBaseActivity implements
		OnClickListener, OnCheckedChangeListener {

	private EditText edtSumInsured1;
	private EditText edtSumInsured2;
	private EditText edtSumInsured3;

	// private CheckBox chkRiskOption1;
	// private CheckBox chkRiskOption2;
	// private CheckBox chkRiskOption3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_risk);

		String product = ((LACLifeApplication) getApplication())
				.getProductQuote();
		setActionBarTitle(product);

		edtSumInsured1 = (EditText) findViewById(R.id.edtSumInsured1);
		edtSumInsured2 = (EditText) findViewById(R.id.edtSumInsured2);
		edtSumInsured3 = (EditText) findViewById(R.id.edtSumInsured3);

		final CheckBox chkRiskOption1 = (CheckBox) findViewById(R.id.chkRiskOption1);
		final CheckBox chkRiskOption2 = (CheckBox) findViewById(R.id.chkRiskOption2);
		final CheckBox chkRiskOption3 = (CheckBox) findViewById(R.id.chkRiskOption3);

		final Button btnGetQuote = (Button) findViewById(R.id.btnGetQuote);

		chkRiskOption1.setOnCheckedChangeListener(this);
		chkRiskOption2.setOnCheckedChangeListener(this);
		chkRiskOption3.setOnCheckedChangeListener(this);
		btnGetQuote.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		Intent intent = new Intent(this, NumberVerificationActivity.class);
		startActivity(intent);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		int id = buttonView.getId();
		switch (id) {
		case R.id.chkRiskOption1:

			break;
		case R.id.chkRiskOption2:
			if (isChecked) {
				setEditable(edtSumInsured2, isChecked);
			} else {
				setEditable(edtSumInsured2, isChecked);
			}
			break;
		case R.id.chkRiskOption3:
			if (isChecked) {
				setEditable(edtSumInsured3, isChecked);
			} else {
				setEditable(edtSumInsured3, isChecked);
			}
			break;
		default:
			break;
		}
	}

	private void setEditable(EditText editText, boolean edibility) {
		if (edibility) {
			editText.requestFocus();
		} else {
			editText.setText("");
		}

		editText.setEnabled(edibility);
	}

}
