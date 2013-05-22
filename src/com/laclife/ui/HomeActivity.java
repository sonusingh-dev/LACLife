package com.laclife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.laclife.ui.products.ProductsActivity;

public class HomeActivity extends SherlockActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.Theme_Sherlock);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		Button btnMyLAC = (Button) findViewById(R.id.btnMyLAC);
		Button btnProducts = (Button) findViewById(R.id.btnProducts);
		Button btnContactUs = (Button) findViewById(R.id.btnContactUs);
		Button btnUtilities = (Button) findViewById(R.id.btnUtilities);

		btnMyLAC.setOnClickListener(this);
		btnProducts.setOnClickListener(this);
		btnContactUs.setOnClickListener(this);
		btnUtilities.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.btnMyLAC:

			break;
		case R.id.btnProducts:
			Intent intent = new Intent(this, ProductsActivity.class);
			startActivity(intent);

			break;
		case R.id.btnContactUs:

			break;
		case R.id.btnUtilities:

			break;

		default:
			break;
		}
	}
}
