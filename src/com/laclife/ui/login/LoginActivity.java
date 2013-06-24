package com.laclife.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.laclife.ui.BaseActivity;
import com.laclife.ui.R;
import com.laclife.ui.products.ProductsActivity;

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
			Intent intent = new Intent(this, ProductsActivity.class);
			startActivity(intent);
			break;
		case R.id.menuContact:
			shortToast("Contact");
			showContactPopup(new View(this));
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

		Intent intent = new Intent(this, SlidingMenuActivity.class);
		startActivity(intent);
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

	// PopupWindow for Photo and Video
	private void showContactPopup(View view) {

		LayoutInflater inflater = LayoutInflater.from(this);
		View popupView = inflater.inflate(R.layout.layout_contact_popup, null);
		popupView.measure(View.MeasureSpec.UNSPECIFIED,
				View.MeasureSpec.UNSPECIFIED);

		Display display = getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height = popupView.getMeasuredHeight() + 10;

		final PopupWindow popupWindow = new PopupWindow(popupView, width,
				height);
		popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
		popupWindow.setOutsideTouchable(true);
		popupWindow.setTouchable(true);

		Button btnEmailFeedback = (Button) popupView
				.findViewById(R.id.btnEmailFeedback);
		Button btnContactUs = (Button) popupView
				.findViewById(R.id.btnContactUs);
		Button btnCancel = (Button) popupView.findViewById(R.id.btnCancel);

		btnEmailFeedback.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				popupWindow.dismiss();

			}
		});

		btnContactUs.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				popupWindow.dismiss();

			}
		});

		btnCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				popupWindow.dismiss();
			}
		});

	}

}
