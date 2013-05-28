package com.laclife.ui.registration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;

public class EnterDetailsActivity1 extends BaseActivity implements
		OnClickListener {

	private EditText edtMobileNumber;
	private EditText edtMobileConfirm;
	private EditText edtPolicyNumber;
	private EditText edtEmailAddr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_details_1);

		edtMobileNumber = (EditText) findViewById(R.id.edtMobileNumber);
		edtMobileConfirm = (EditText) findViewById(R.id.edtMobileConfirm);
		edtPolicyNumber = (EditText) findViewById(R.id.edtPolicyNumber);
		edtEmailAddr = (EditText) findViewById(R.id.edtEmailAddr);

		final Button btnContinue = (Button) findViewById(R.id.btnContinue);
		btnContinue.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent registerIntent = new Intent(this, EnterDetailsActivity2.class);
		startActivity(registerIntent);
	}

	private void validate() {

		if (TextUtils.isEmpty(edtMobileNumber.getText().toString())) {
			shortToast("Please enter Phone number");
			return;
		}

		if (!Patterns.PHONE.matcher(edtMobileNumber.getText().toString())
				.matches()) {
			shortToast("Inavlide Phone Number");
			return;
		}

		if (!TextUtils.equals(edtMobileConfirm.getText().toString(),
				edtMobileNumber.getText().toString())) {
			shortToast("Mobile Number do not match");
			return;
		}

		if (TextUtils.isEmpty(edtPolicyNumber.getText().toString())) {
			shortToast("Please enter Policy Number");
			return;
		}

		if (TextUtils.isEmpty(edtEmailAddr.getText().toString())) {
			shortToast("Please enter Email");
			return;
		}

		if (!Patterns.EMAIL_ADDRESS.matcher(edtEmailAddr.getText().toString())
				.matches()) {
			shortToast("Inavlide Email");
			return;
		}
	}

}
