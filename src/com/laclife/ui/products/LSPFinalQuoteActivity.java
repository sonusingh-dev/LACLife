package com.laclife.ui.products;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.laclife.Constant.Products;
import com.laclife.model.calculatequote.CalculateQuoteResponse;
import com.laclife.model.calculatequote.CoverageDataModel;
import com.laclife.model.calculatequote.OwnerModel;
import com.laclife.model.calculatequote.QuoteDataModel;
import com.laclife.net.CalculateQuoteWS;
import com.laclife.net.GetDataCallBack;
import com.laclife.ui.R;

public class LSPFinalQuoteActivity extends HomeBaseActivity implements
		OnClickListener, GetDataCallBack {

	private Intent mIntent;

	private TextView txtOverview, txtPlan, txtDetails, txtDeath, txtCritical,
			txtTPD, txtRisk, txtTotal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_quote_lsp);

		mIntent = getIntent();
		String product = mIntent.getStringExtra(Products.KEY_NAME_SORT_QUOTE);
		setActionBarTitle(product);

		txtOverview = (TextView) findViewById(R.id.txtOverview);
		txtPlan = (TextView) findViewById(R.id.txtPlan);
		txtDetails = (TextView) findViewById(R.id.txtDetails);
		txtDeath = (TextView) findViewById(R.id.txtDeath);
		txtCritical = (TextView) findViewById(R.id.txtCritical);
		txtTPD = (TextView) findViewById(R.id.txtTPD);
		txtRisk = (TextView) findViewById(R.id.txtRisk);
		txtTotal = (TextView) findViewById(R.id.txtTotal);

		Button btnEmail = (Button) findViewById(R.id.btnEmail);
		btnEmail.setOnClickListener(this);

		OwnerModel owner = new OwnerModel();
		owner.setCompany(false);
		owner.setFirstName("Ponle");
		owner.setLastName("Holloway");
		owner.setGender("M");

		List<CoverageDataModel> coverageDataList = new ArrayList<CoverageDataModel>();

		CoverageDataModel coverageData1 = new CoverageDataModel();
		coverageData1.setProductCode("RSP");
		coverageData1.setPremiumAmount("5000");
		coverageData1.setFaceAmount("0");

		coverageDataList.add(coverageData1);

		showProgressDialog();

		new CalculateQuoteWS("603", "M", "10", owner, coverageDataList)
				.getDataInBackground(this);
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

	@Override
	public void done(Object result) {
		dismissProgressDialog();
		if (result != null) {
			CalculateQuoteResponse response = (CalculateQuoteResponse) result;
			Log.e("quoteData", "quoteNo: " + response.getQuoteNo());
			Log.e("quoteData", "quoteData: " + response.getQuoteDataList());
			List<QuoteDataModel> quoteDataList = response.getQuoteDataList();
			int risk = 0;
			if (quoteDataList != null) {
				for (QuoteDataModel quoteDataModel : quoteDataList) {
					if (TextUtils.equals(quoteDataModel.getName(),
							"RSP_PREMIUM")) {
						txtOverview.setText("N " + quoteDataModel.getValue());
						txtTotal.setText("# " + quoteDataModel.getValue());
					} else if (TextUtils.equals(quoteDataModel.getName(),
							"FREQUENCY")) {
						// risk = risk
						// + Integer.valueOf(quoteDataModel.getValue());
						txtPlan.setText(quoteDataModel.getValue());
						txtDetails.setText(quoteDataModel.getValue());
					} else if (TextUtils.equals(quoteDataModel.getName(),
							"RSP_L_PREMIUM")) {
						// risk = risk
						// + Integer.valueOf(quoteDataModel.getValue());
						txtDeath.setText("# " + quoteDataModel.getValue());
					} else if (TextUtils.equals(quoteDataModel.getName(),
							"RSP_CI_PREMIUM")) {
						// risk = risk
						// + Integer.valueOf(quoteDataModel.getValue());
						txtCritical.setText("# " + quoteDataModel.getValue());
					} else if (TextUtils.equals(quoteDataModel.getName(),
							"RSP_PTD_PREMIUM")) {
						// risk = risk
						// + Integer.valueOf(quoteDataModel.getValue());
						txtTPD.setText("# " + quoteDataModel.getValue());
						txtRisk.setText("# " + quoteDataModel.getValue());
					}
				}
			}

		} else {
			Log.e("quoteData", "QuoteNo: " + null);
		}
	}

	@Override
	public void error(String error) {

	}

}
