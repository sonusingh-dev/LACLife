package com.laclife.ui.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.laclife.Constant.Products;
import com.laclife.LACLifeApplication;
import com.laclife.ui.R;

public class ProductsActivity extends HomeBaseActivity implements
		OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products);

		ListView listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.products_array)));

		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String product = getResources().getStringArray(R.array.products_array)[position];
		String sortPproduct = getResources().getStringArray(R.array.sort_products_array)[position];
		
		((LACLifeApplication) getApplication()).setProduct(sortPproduct);
		((LACLifeApplication) getApplication()).setProductQuote();
						
		Intent intent = new Intent(this, ProductDescriptionActivity.class);
		intent.putExtra(Products.NAME, product);
		startActivity(intent);
	}
}
