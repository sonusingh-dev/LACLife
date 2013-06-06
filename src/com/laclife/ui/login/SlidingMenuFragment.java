package com.laclife.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laclife.ui.R;

public class SlidingMenuFragment extends BaseFragment implements
		OnClickListener {

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

		ContentFragment fragment;
		switch (id) {
		case R.id.txtDirectDebit:
			fragment = ContentFragment
					.newInstance(getString(R.string.menu_direct_debit));
			switchFragment(fragment);

			break;
		case R.id.txtAboutUs:
			fragment = ContentFragment
					.newInstance(getString(R.string.menu_about_us));
			switchFragment(fragment);

			break;

		case R.id.txtContactUs:
			fragment = ContentFragment
					.newInstance(getString(R.string.menu_contact_us));
			switchFragment(fragment);

			break;
		case R.id.txtFAQ:
			fragment = ContentFragment
					.newInstance(getString(R.string.menu_faqs));
			switchFragment(fragment);

			break;
		case R.id.txtTermsConditions:
			fragment = ContentFragment
					.newInstance(getString(R.string.menu_terms_conditions));
			switchFragment(fragment);

			break;

		case R.id.txtChangePassword:
			fragment = ContentFragment
					.newInstance(getString(R.string.menu_change_password));
			switchFragment(fragment);

			break;
		case R.id.txtMyPolicies:
			fragment = ContentFragment
					.newInstance(getString(R.string.menu_my_policies));
			switchFragment(fragment);

			break;

		case R.id.txtLogout:
			Intent intent = new Intent(getActivity(), LoginActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);

			break;
		default:
			break;
		}
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof SlidingMenuActivity) {
			SlidingMenuActivity slidingMenu = (SlidingMenuActivity) getActivity();
			slidingMenu.switchContent(fragment);
		}
	}
}
