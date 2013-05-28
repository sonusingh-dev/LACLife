package com.laclife.ui.products;

import java.util.List;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.LACLifeApplication;
import com.laclife.ui.R;

public class ProductDescriptionActivity extends HomeBaseActivity implements
		OnClickListener {

	// private String product;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_description);

		String productQuote = ((LACLifeApplication) getApplication())
				.getProduct();
		setActionBarTitle(productQuote);

		// String product = getIntent().getStringExtra(Products.NAME);

		Button btnGetQuote = (Button) findViewById(R.id.btnGetQuote);
		Button btnMailUs = (Button) findViewById(R.id.btnMailUs);

		btnGetQuote.setOnClickListener(this);
		btnMailUs.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.btnGetQuote:
			// ((LACLifeApplication) getApplication()).setProductQuote(product);
			Intent intent = new Intent(this, ContactDetailsActivity.class);
			startActivity(intent);

			break;
		case R.id.btnMailUs:
			sendEmail();
			break;

		default:
			break;
		}
	}

	/**
	 * Invokes android Gmail mailing client for sending email.
	 */
	private void sendEmail() {

		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
		intent.setType("text/html");
		List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(
				intent, 0);

		if (!resInfo.isEmpty()) {
			for (ResolveInfo info : resInfo) {
				if (info.activityInfo.packageName.toLowerCase().contains(
						"gmail")
						|| info.activityInfo.name.toLowerCase().contains(
								"gmail")) {
					intent.putExtra(android.content.Intent.EXTRA_SUBJECT,
							"Subject");
					intent.putExtra(android.content.Intent.EXTRA_TEXT,
							"Email Body");
					intent.setPackage(info.activityInfo.packageName);
					startActivity(Intent.createChooser(intent, "Email:"));
				}
			}
		}

	}

}
