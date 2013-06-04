package com.laclife.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.laclife.ui.R;

public class MyPoliciesFragment extends BaseFragment implements
		OnItemClickListener {

	public static MyPoliciesFragment newInstance() {
		MyPoliciesFragment fragment = new MyPoliciesFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		setActionBarTitle(getString(R.string.menu_my_policies));

		View view = inflater.inflate(R.layout.activity_products, container,
				false);

		ListView listView = (ListView) view.findViewById(R.id.listView);
		listView.setAdapter(new ArrayAdapter<String>(getActivity(),
				R.layout.simple_list_item_1, getResources().getStringArray(
						R.array.products_array)));

		listView.setOnItemClickListener(this);

		Log.e("AboutUsFragment", "onCreateView()");

		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}
}
