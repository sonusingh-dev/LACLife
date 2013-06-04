package com.laclife.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laclife.ui.R;

public class AboutUsFragment extends BaseFragment {

	public static AboutUsFragment newInstance() {
		AboutUsFragment fragment = new AboutUsFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		setActionBarTitle(getString(R.string.menu_about_us));

		View view = inflater.inflate(R.layout.activity_contact_details,
				container, false);

		Log.e("AboutUsFragment", "onCreateView()");

		return view;
	}

}
