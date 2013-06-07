package com.laclife.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.laclife.ui.R;

public class GenderSelectionFragment extends DialogFragment {

	private static final String KEY_SELECTED_ITEM = "selectedItem";

	private ItemClickDialogListener mListener;

	public static GenderSelectionFragment newInstance(int selectedItem) {
		Bundle args = new Bundle();
		args.putInt(KEY_SELECTED_ITEM, selectedItem);

		GenderSelectionFragment newFragment = new GenderSelectionFragment();
		newFragment.setArguments(args);

		return newFragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (ItemClickDialogListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		int selectedItem = getArguments().getInt(KEY_SELECTED_ITEM);

		final String[] genderArray = getActivity().getResources()
				.getStringArray(R.array.gender_array);

		// Use the Builder class for convenient dialog construction
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		// Set the dialog title
		builder.setTitle(R.string.title_select_gender)

		.setSingleChoiceItems(genderArray, selectedItem,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mListener.onDialogItemClick(dialog, genderArray[which],
								which);
						dismiss();
					}
				});

		// Create the AlertDialog object and return it
		return builder.create();
	}

	public interface ItemClickDialogListener {
		public void onDialogItemClick(DialogInterface dialog, String item,
				int which);
	}
}