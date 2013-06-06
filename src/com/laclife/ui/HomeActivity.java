package com.laclife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.laclife.ui.login.SlidingMenuActivity;
import com.laclife.ui.products.ProductsActivity;
import com.laclife.ui.registration.RegisterActivity;

public class HomeActivity extends BaseActivity implements OnClickListener {

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
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.btnLogin:
			Intent registerIntent = new Intent(this,
					RegisterActivity.class);
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
}
