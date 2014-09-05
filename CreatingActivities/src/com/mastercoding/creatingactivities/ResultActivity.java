package com.mastercoding.creatingactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends Activity {
	
	private EditText editText;
	private Button btnClose;
	public static String INFO = "info";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		editText = (EditText) findViewById(R.id.txt_ask);
		btnClose = (Button) findViewById(R.id.btn_close);
		btnClose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				// Add any info you want to the intent.
				String info = (editText.getText() == null || editText.getText().toString().equals("")) ? "No data" : editText.getText().toString();
				data.putExtra(INFO, info);
				// Set the result of this activity with its intent containing the results.
				setResult(RESULT_OK, data);
				// Close the activity.
				finish();
			}
		});		
	}
}
