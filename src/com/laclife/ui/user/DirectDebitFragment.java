package com.laclife.ui.user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laclife.ui.R;

public class DirectDebitFragment extends BaseFragment {

	public static DirectDebitFragment newInstance() {
		DirectDebitFragment fragment = new DirectDebitFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		setActionBarTitle(getString(R.string.menu_direct_debit));

		View view = inflater.inflate(R.layout.activity_final_quote, container,
				false);

		Log.e("DirectDebitFragment", "onCreateView()");

		return view;
	}

}
