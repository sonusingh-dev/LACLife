package com.laclife.ui.user;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MenuItem;

import com.laclife.ui.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

/*
 * All activity extends BaseActivity and it set background image for ActionBar.
 */
public class SlidingMenuBaseActivity extends SlidingFragmentActivity {

	private Fragment mContent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBarHelper().setSlidingMenu(true);

		setContentView(R.layout.base_frame);

		Log.e("SlidingBaseActivity", "onCreate()");

		// check if the content frame contains the menu frame
		// if (findViewById(R.id.menu_frame) == null) {

		// Log.e("SlidingBaseActivity", "onCreate(): menu_frame");
		setBehindContentView(R.layout.menu_frame);
		getSlidingMenu().setSlidingEnabled(true);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// } else {
		// add a dummy view
		// Log.e("SlidingBaseActivity", "onCreate(): dummy_view");
		//
		// View v = new View(this);
		// setBehindContentView(v);
		// getSlidingMenu().setSlidingEnabled(false);
		// getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		// }

		// set the Above View Fragment
		if (savedInstanceState != null)
			mContent = getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
		if (mContent == null)
			mContent = new MyPoliciesFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, mContent).commit();

		// set the Behind View Fragment
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new SlidingMenuFragment()).commit();

		// customize the SlidingMenu
		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		slidingMenu.setShadowDrawable(R.drawable.shadow);
		slidingMenu.setBehindScrollScale(0.25f);
		slidingMenu.setFadeDegree(0.25f);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// customize the SlidingMenu
		// SlidingMenu sm = getSlidingMenu();
		// sm.setShadowWidthRes(R.dimen.shadow_width);
		// sm.setShadowDrawable(R.drawable.shadow);
		// sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// sm.setFadeDegree(0.35f);
		// sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// show the explanation dialog
		// if (savedInstanceState == null)
		// new AlertDialog.Builder(this).setTitle(R.string.what_is_this)
		// .setMessage(R.string.responsive_explanation).show();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		default:

		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mContent);
	}

	public void switchContent(final Fragment fragment) {
		mContent = fragment;
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		Handler h = new Handler();
		h.postDelayed(new Runnable() {
			public void run() {
				getSlidingMenu().showContent();
			}
		}, 50);
	}
}
