package com.laclife.ui.registration;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;

public class EnterDetailsActivity2 extends BaseActivity implements
		OnClickListener {

	private final static int DATE_DIALOG_ID = 79;

	private int mYear;
	private int mMonth;
	private int mDay;

	private EditText edtTitle;
	private EditText edtFName;
	private EditText edtLName;
	private EditText edtBirthday;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_details_2);

		edtTitle = (EditText) findViewById(R.id.edtTitle);
		edtFName = (EditText) findViewById(R.id.edtFName);
		edtLName = (EditText) findViewById(R.id.edtLName);
		edtBirthday = (EditText) findViewById(R.id.edtBirthday);

		final Button btnContinue = (Button) findViewById(R.id.btnContinue);
		
		edtBirthday.setOnClickListener(this);
		btnContinue.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btnContinue:
			Intent registerIntent = new Intent(this,
					ReviewDetailsActivity.class);
			startActivity(registerIntent);
			// validate();
			break;

		case R.id.edtBirthday:
			final Calendar c = Calendar.getInstance();
			mYear = c.get(Calendar.YEAR);
			mMonth = c.get(Calendar.MONTH);
			mDay = c.get(Calendar.DAY_OF_MONTH);
			showDialog(DATE_DIALOG_ID);
			break;

		default:
			break;
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		}
		return null;
	}

	private void validate() {

		if (TextUtils.isEmpty(edtTitle.getText().toString())) {
			shortToast("Please enter Title");
			return;
		}

		if (TextUtils.isEmpty(edtFName.getText().toString())) {
			shortToast("Please enter First Name");
			return;
		}

		if (TextUtils.isEmpty(edtLName.getText().toString())) {
			shortToast("Please enter Last Name");
			return;
		}

		if (TextUtils.isEmpty(edtBirthday.getText().toString())) {
			shortToast("Please enter Date of Birth");
			return;
		}
	}

	// updates the date in the TextView
	private void updateDisplay() {
		edtBirthday.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(mMonth + 1).append("-").append(mDay).append("-")
				.append(mYear).append(" "));
	}

	// the callback received when the user "sets" the date in the dialog
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}
	};

}
