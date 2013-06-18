package com.laclife.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.model.CalculateQuoteResponse;
import com.laclife.net.CalculateQuoteWS;
import com.laclife.net.CalculateQuoteWS.CoverageData;
import com.laclife.net.CalculateQuoteWS.Owner;
import com.laclife.net.GetDataCallBack;
import com.laclife.ui.products.ProductsActivity;
import com.laclife.ui.registration.RegisterActivity;

public class HomeActivity extends BaseActivity implements OnClickListener,
		GetDataCallBack {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		Button btnLogin = (Button) findViewById(R.id.btnLogin);
		Button btnProducts = (Button) findViewById(R.id.btnProducts);
		Button btnContact = (Button) findViewById(R.id.btnContact);
		Button btnAboutApp = (Button) findViewById(R.id.btnAboutApp);

		btnLogin.setOnClickListener(this);
		btnProducts.setOnClickListener(this);
		btnContact.setOnClickListener(this);
		btnAboutApp.setOnClickListener(this);

		Owner owner = new Owner();
		owner.setCompany(true);
		owner.setFirstName("");
		owner.setLastName("");

		List<CoverageData> coverageDataList = new ArrayList<CoverageData>();

		CoverageData coverageData1 = new CoverageData();
		coverageData1.setProductCode("RSP");
		coverageData1.setPremiumAmount("5000");
		coverageData1.setFaceAmount("0");

		CoverageData coverageData2 = new CoverageData();
		coverageData2.setProductCode("C5");
		coverageData2.setPremiumAmount("250000");
		coverageData2.setFaceAmount("50000");

		coverageDataList.add(coverageData1);
		coverageDataList.add(coverageData2);

		new CalculateQuoteWS("603", "M", "10", owner, coverageDataList)
				.getDataInBackground(this);
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.btnLogin:
			Intent registerIntent = new Intent(this, RegisterActivity.class);
			startActivity(registerIntent);

			break;
		case R.id.btnProducts:
			Intent productsIntent = new Intent(this, ProductsActivity.class);
			startActivity(productsIntent);

			break;
		case R.id.btnContact:

			break;
		case R.id.btnAboutApp:

			break;

		default:
			break;
		}
	}

	@Override
	public void done(Object result) {
		if (result != null) {
			CalculateQuoteResponse response = (CalculateQuoteResponse) result;
			Log.e("quoteData", "quoteNo: " + response.getQuoteNo());
			Log.e("quoteData", "quoteData: " + response.getQuoteData());
		} else {
			Log.e("quoteData", "QuoteNo: " + null);
		}
	}

	@Override
	public void error(String error) {
		// TODO Auto-generated method stub

	}
}
