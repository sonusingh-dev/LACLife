package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.laclife.Constant.Products;
import com.laclife.ui.R;

public class ProductsActivity extends HomeBaseActivity implements
		OnItemClickListener {

	private static final int LSP = 0;
	private static final int ESP = 1;
	private static final int ETP = 2;
	private static final int LTP = 3;
	private static final int PSP = 4;

	private String[] mProducts;
	private String[] mSortProducts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products);

		mProducts = getResources().getStringArray(R.array.products_array);
		mSortProducts = getResources().getStringArray(
				R.array.sort_products_array);

		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, mProducts));

		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		String className = null;
		switch (position) {
		case LSP:
			className = "LSPSavingActivity";

			break;
		case ESP:
			className = "ESPSavingActivity";

			break;
		case ETP:
			className = "ETPSavingActivity";

			break;
		case LTP:
			className = "LTPSavingActivity";

			break;
		case PSP:
			className = "PSPSavingActivity";

			break;

		default:
			break;
		}

		Intent intent = new Intent(this, ProductDescriptionActivity.class);
		intent.putExtra(Products.KEY_CLASS, Products.PACKAGE + className);
		intent.putExtra(Products.KEY_NAME, mProducts[position]);
		intent.putExtra(Products.KEY_NAME_SORT, mSortProducts[position]);
		startActivity(intent);
	}
}
