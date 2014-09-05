package com.mastercoding.creatingactivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private Button btnStartActivity, btnSendEmail, btnStartActivityOnResult;
	public static int REQUEST_CODE = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set the layout for this activity.
		setContentView(R.layout.activity_main);
		
		// Get the button and add an onClickListener()
		btnStartActivity = (Button) findViewById(R.id.btn_start_activity);
		btnStartActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, OtherActivity.class);
				startActivity(intent);				
			}
		});
		
		btnSendEmail = (Button) findViewById(R.id.btn_start_activity_url);
		btnSendEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.google.com"));
				startActivity(intent);			
			}
		});
		
		btnStartActivityOnResult = (Button) findViewById(R.id.btn_start_activity_onresult);
		btnStartActivityOnResult.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ResultActivity.class);
			    startActivityForResult(intent, REQUEST_CODE);				
			}
		});
	}

	// Process the result of an activity.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent resultData) {
		// Verify that this method is called for our requestCode and that it is returning the RESULT_OK value.
		// You can do something else with other result types.
		if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
			Toast.makeText(this, "" + resultData.getExtras().getString(ResultActivity.INFO), Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
