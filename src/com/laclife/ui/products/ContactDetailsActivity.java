package com.laclife.ui.products;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.laclife.LACLifeApplication;
import com.laclife.ui.R;
import com.laclife.ui.dialog.DatePickerFragment;
import com.laclife.ui.dialog.DatePickerFragment.DateSetDialogListener;
import com.laclife.ui.dialog.GenderSelectionFragment;
import com.laclife.ui.dialog.GenderSelectionFragment.ItemClickDialogListener;

public class ContactDetailsActivity extends HomeBaseActivity implements
		DateSetDialogListener, ItemClickDialogListener {

	private int mYear;
	private int mMonth;
	private int mDay;

	private int mSelectedGender = -1;

	private EditText edtFName;
	private EditText edtLName;
	private EditText edtPhone;
	private EditText edtEmail;
	private EditText edtBirthday;

	private TextView txtGender;

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

		txtGender = (TextView) findViewById(R.id.txtGender);

	}

	public void onNext(View v) {
		// Intent intent = new Intent(this, SavingAmountActivity.class);
		// startActivity(intent);
		validate();
	}

	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = DatePickerFragment.newInstance();
		newFragment.show(getSupportFragmentManager(), "datePicker");
	}

	public void showGenderSelectionDialog(View v) {
		DialogFragment newFragment = GenderSelectionFragment
				.newInstance(mSelectedGender);
		newFragment.show(getSupportFragmentManager(), "genderSelection");
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

		Intent intent = new Intent(this, SavingAmountActivity.class);
		startActivity(intent);
	}

	// updates the date in the TextView
	private void updateDisplay() {
		edtBirthday.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(mMonth + 1).append("-").append(mDay).append("-")
				.append(mYear).append(" "));
	}

	@Override
	public void onDialogDateSet(DatePicker view, int year, int month, int day) {
		mYear = year;
		mMonth = month;
		mDay = day;
		updateDisplay();
	}

	@Override
	public void onDialogItemClick(DialogInterface dialog, String item, int which) {
		mSelectedGender = which;
		txtGender.setText(item);
	}

}
