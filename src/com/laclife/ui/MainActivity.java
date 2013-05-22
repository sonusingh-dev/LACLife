package com.laclife.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnMyLAC = (Button) findViewById(R.id.btnMyLAC);

		Button btnProducts = (Button) findViewById(R.id.btnProducts);

		Button btnContactUs = (Button) findViewById(R.id.btnContactUs);

		Button btnUtilities = (Button) findViewById(R.id.btnUtilities);
	}
}
