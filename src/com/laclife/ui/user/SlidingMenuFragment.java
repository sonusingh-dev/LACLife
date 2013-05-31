package com.laclife.ui.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laclife.ui.R;

public class SlidingMenuFragment extends BaseFragment implements OnClickListener {

	private TextView txtDirectDebit, txtAboutUs, txtContactUs, txtFAQ,
			txtTermsConditions, txtChangePassword, txtMyPolicies, txtLogout;

	public static SlidingMenuFragment newInstance() {
		SlidingMenuFragment fragment = new SlidingMenuFragment();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_sliding_menu, container,
				false);

		txtDirectDebit = (TextView) view.findViewById(R.id.txtDirectDebit);
		txtAboutUs = (TextView) view.findViewById(R.id.txtAboutUs);
		txtContactUs = (TextView) view.findViewById(R.id.txtContactUs);
		txtFAQ = (TextView) view.findViewById(R.id.txtFAQ);
		txtTermsConditions = (TextView) view
				.findViewById(R.id.txtTermsConditions);
		txtChangePassword = (TextView) view
				.findViewById(R.id.txtChangePassword);
		txtMyPolicies = (TextView) view.findViewById(R.id.txtMyPolicies);
		txtLogout = (TextView) view.findViewById(R.id.txtLogout);

		txtDirectDebit.setOnClickListener(this);
		txtAboutUs.setOnClickListener(this);
		txtContactUs.setOnClickListener(this);
		txtFAQ.setOnClickListener(this);
		txtTermsConditions.setOnClickListener(this);
		txtChangePassword.setOnClickListener(this);
		txtMyPolicies.setOnClickListener(this);
		txtLogout.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.txtDirectDebit:
			DirectDebitFragment directDebitFragment = DirectDebitFragment.newInstance();
			switchFragment(directDebitFragment);
			
			break;
		case R.id.txtAboutUs:
			AboutUsFragment aboutUsFragment = AboutUsFragment.newInstance();
			switchFragment(aboutUsFragment);

			break;

		case R.id.txtContactUs:

			break;
		case R.id.txtFAQ:

			break;
		case R.id.txtTermsConditions:

			break;

		case R.id.txtChangePassword:

			break;
		case R.id.txtMyPolicies:

			break;

		case R.id.txtLogout:

			break;	
		default:
			break;
		}
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof SlidingMenuBaseActivity) {
			SlidingMenuBaseActivity slidingMenu = (SlidingMenuBaseActivity) getActivity();
			slidingMenu.switchContent(fragment);
		}
	}
}
