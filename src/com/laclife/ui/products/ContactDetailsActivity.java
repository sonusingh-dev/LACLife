package com.laclife.ui.products;

import java.util.Calendar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.laclife.LACLifeApplication;
import com.laclife.ui.R;

public class ContactDetailsActivity extends HomeBaseActivity implements
		OnClickListener {

	private final static int DATE_DIALOG_ID = 78;

	private int mYear;
	private int mMonth;
	private int mDay;

	private int selectedGender = -1;

	private EditText edtFName;
	private EditText edtLName;
	private EditText edtPhone;
	private EditText edtEmail;
	private EditText edtBirthday;

	private TextView btnGender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_details);

		String product = ((LACLifeApplication) getApplication())
				.getProductQuote();
		setActionBarTitle(product);

		edtFName = (EditText) findViewById(R.id.edtFName);
		edtLName = (EditText) findViewById(R.id.edtLName);
		edtPhone = (EditText) findViewById(R.id.edtPhone);
		edtEmail = (EditText) findViewById(R.id.edtEmail);
		edtBirthday = (EditText) findViewById(R.id.edtBirthday);

		btnGender = (TextView) findViewById(R.id.btnGender);

		Button btnNext = (Button) findViewById(R.id.btnNext);

		edtBirthday.setOnClickListener(this);
		btnGender.setOnClickListener(this);
		btnNext.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btnNext:
			Intent intent = new Intent(this, SavingAmountActivity.class);
			startActivity(intent);
			// validate();
			break;
		case R.id.btnGender:
			showGenderDialog();
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

		if (TextUtils.isEmpty(edtFName.getText().toString())) {
			shortToast("Please enter First Name");
			return;
		}

		if (TextUtils.isEmpty(edtLName.getText().toString())) {
			shortToast("Please enter Last Name");
			return;
		}

		if (TextUtils.isEmpty(edtPhone.getText().toString())) {
			shortToast("Please enter Phone number");
			return;
		}

		if (!Patterns.PHONE.matcher(edtPhone.getText().toString()).matches()) {
			shortToast("Inavlide Phone Number");
			return;
		}

		if (TextUtils.isEmpty(edtEmail.getText().toString())) {
			shortToast("Please enter Email");
			return;
		}

		if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString())
				.matches()) {
			shortToast("Inavlide Email");
			return;
		}

		if (TextUtils.isEmpty(edtBirthday.getText().toString())) {
			shortToast("Please enter Date of Birth");
			return;
		}

		// Intent intent = new Intent(this, SavingAmountActivity.class);
		// startActivity(intent);
	}

	private void showGenderDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.title_select_gender));

		final String[] gender = getResources().getStringArray(
				R.array.gender_array);

		builder.setSingleChoiceItems(gender, selectedGender,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						selectedGender = which;
						btnGender.setText(gender[which]);
						dialog.dismiss();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
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
