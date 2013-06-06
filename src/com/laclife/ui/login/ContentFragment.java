package com.laclife.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laclife.ui.R;

public class ContentFragment extends BaseFragment {

	public static ContentFragment newInstance(String title) {
		Bundle args = new Bundle();
		args.putString("title", title);

		ContentFragment fragment = new ContentFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Bundle args = getArguments();
		String title = args.getString("title");

		setActionBarTitle(title);

		View view = inflater.inflate(R.layout.fragment_content, container,
				false);

		final TextView textView = (TextView) view.findViewById(R.id.textView);
		textView.setText(title);

		return view;
	}

}
