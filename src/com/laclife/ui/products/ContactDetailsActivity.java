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

import com.laclife.Constant.Products;
import com.laclife.model.calculatequote.CalculateQuoteModel;
import com.laclife.model.calculatequote.OwnerModel;
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

	private Intent mIntent;

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

		mIntent = getIntent();
		String product = mIntent.getStringExtra(Products.KEY_NAME_SORT_QUOTE);
		setActionBarTitle(product);

		edtFName = (EditText) findViewById(R.id.edtFName);
		edtLName = (EditText) findViewById(R.id.edtLName);
		edtPhone = (EditText) findViewById(R.id.edtPhone);
		edtEmail = (EditText) findViewById(R.id.edtEmail);
		edtBirthday = (EditText) findViewById(R.id.edtBirthday);

		txtGender = (TextView) findViewById(R.id.txtGender);

	}

	public void onNext(View v) {
		next(null);
		// validate();
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

		String firstName = edtFName.getText().toString();
		if (TextUtils.isEmpty(firstName)) {
			shortToast("Please enter First Name");
			return;
		}

		String lastName = edtLName.getText().toString();
		if (TextUtils.isEmpty(lastName)) {
			shortToast("Please enter Last Name");
			return;
		}

		String phone = edtPhone.getText().toString();
		if (TextUtils.isEmpty(phone)) {
			shortToast("Please enter Phone number");
			return;
		}

		if (!Patterns.PHONE.matcher(phone).matches()) {
			shortToast("Inavlide Phone Number");
			return;
		}

		String email = edtEmail.getText().toString();
		if (TextUtils.isEmpty(email)) {
			shortToast("Please enter Email");
			return;
		}

		if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
			shortToast("Inavlide Email");
			return;
		}

		String birthDate = edtBirthday.getText().toString();
		if (TextUtils.isEmpty(birthDate)) {
			shortToast("Please enter Date of Birth");
			return;
		}

		OwnerModel owner = new OwnerModel();
		owner.setFirstName(firstName);
		owner.setLastName(lastName);
		owner.setMobilePhoneNo(phone);
		owner.setEmail(email);
		owner.setBirthDate(birthDate);

		next(owner);
	}

	private void next(OwnerModel owner) {
		
		CalculateQuoteModel calculateQuote = new CalculateQuoteModel();
		calculateQuote.setOwner(owner);

		String className = mIntent.getStringExtra(Products.KEY_CLASS);

		try {
			Class<?> cls = Class.forName(className);
			mIntent.setClass(this, cls);
			mIntent.putExtra(Products.KEY_QUOTE, calculateQuote);
			startActivity(mIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
