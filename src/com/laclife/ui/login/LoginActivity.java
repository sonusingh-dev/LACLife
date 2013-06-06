package com.laclife.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;

public class LoginActivity extends BaseActivity implements TextWatcher {

	private EditText edtPasscodeCode1;
	private EditText edtPasscodeCode2;
	private EditText edtPasscodeCode3;
	private EditText edtPasscodeCode4;
	private EditText edtPasscodeCode5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		edtPasscodeCode1 = (EditText) findViewById(R.id.edtPasscodeCode1);
		edtPasscodeCode2 = (EditText) findViewById(R.id.edtPasscodeCode2);
		edtPasscodeCode3 = (EditText) findViewById(R.id.edtPasscodeCode3);
		edtPasscodeCode4 = (EditText) findViewById(R.id.edtPasscodeCode4);
		edtPasscodeCode5 = (EditText) findViewById(R.id.edtPasscodeCode5);

		// InputMethodManager imm = (InputMethodManager)
		// getSystemService(Context.INPUT_METHOD_SERVICE);
		// imm.showSoftInput(edtPasscodeCode1,
		// InputMethodManager.SHOW_IMPLICIT);

		edtPasscodeCode1.addTextChangedListener(this);
		edtPasscodeCode2.addTextChangedListener(this);
		edtPasscodeCode3.addTextChangedListener(this);
		edtPasscodeCode4.addTextChangedListener(this);
		edtPasscodeCode5.addTextChangedListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.login, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuProducts:
			shortToast("Products");
			break;
		case R.id.menuContact:
			shortToast("Contact");
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	private void validate() {

		if (TextUtils.isEmpty(edtPasscodeCode1.getText().toString())) {
			shortToast("Enter Passcode");
			return;
		}

		if (TextUtils.isEmpty(edtPasscodeCode2.getText().toString())) {
			shortToast("Enter Passcode");
			return;
		}

		if (TextUtils.isEmpty(edtPasscodeCode3.getText().toString())) {
			shortToast("Enter Passcode");
			return;
		}

		if (TextUtils.isEmpty(edtPasscodeCode4.getText().toString())) {
			shortToast("Enter Passcode");
			return;
		}

		if (TextUtils.isEmpty(edtPasscodeCode5.getText().toString())) {
			shortToast("Enter Passcode");
			return;
		}

		Intent productsIntent = new Intent(this, SlidingMenuActivity.class);
		startActivity(productsIntent);
	}

	@Override
	public void afterTextChanged(Editable s) {

		if (edtPasscodeCode1.hasFocus()) {
			if (!TextUtils.isEmpty(edtPasscodeCode1.getText().toString())) {
				edtPasscodeCode2.requestFocus();
			}
		} else if (edtPasscodeCode2.hasFocus()) {
			if (!TextUtils.isEmpty(edtPasscodeCode2.getText().toString())) {
				edtPasscodeCode3.requestFocus();
			} else {
				edtPasscodeCode1.requestFocus();
			}
		} else if (edtPasscodeCode3.hasFocus()) {
			if (!TextUtils.isEmpty(edtPasscodeCode3.getText().toString())) {
				edtPasscodeCode4.requestFocus();
			} else {
				edtPasscodeCode2.requestFocus();
			}
		} else if (edtPasscodeCode4.hasFocus()) {
			if (!TextUtils.isEmpty(edtPasscodeCode4.getText().toString())) {
				edtPasscodeCode5.requestFocus();
			} else {
				edtPasscodeCode3.requestFocus();
			}
		} else if (edtPasscodeCode5.hasFocus()) {
			if (!TextUtils.isEmpty(edtPasscodeCode5.getText().toString())) {
				edtPasscodeCode5.clearFocus();
				validate();
			} else {
				edtPasscodeCode4.requestFocus();
			}
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

}
