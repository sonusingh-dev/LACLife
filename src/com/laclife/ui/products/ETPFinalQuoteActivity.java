package com.laclife.ui.products;

import java.util.List;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.laclife.Constant.Products;
import com.laclife.ui.R;

public class ETPFinalQuoteActivity extends HomeBaseActivity implements
		OnClickListener {

	private Intent mIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_quote_etp);

		mIntent = getIntent();
		String product = mIntent.getStringExtra(Products.KEY_NAME_SORT_QUOTE);
		setActionBarTitle(product);

	}

	@Override
	public void onClick(View view) {
		sendEmail();
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
