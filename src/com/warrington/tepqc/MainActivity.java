package com.warrington.tepqc;

import com.warrington.tepqc.brotherdashboarddesign.DashboardDesign;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// This inflates to the action bar 
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void goBrotherMain(View view) {
		
		//Brother status alert message
		//Toast.makeText(getApplicationContext(), "I'm sorry. Your device has not been authorized to [brother] status.", Toast.LENGTH_LONG).show();
	    
		
		// Won't be removed until brother section is complete
		// The intent binds this class to the brother main class
		Intent intent = new Intent(this, DashboardDesign.class);
		startActivity(intent);
	}
	
	public void goRushMain(View view) {
	    // The intent binds this class to the brother main class
		Intent intent = new Intent(this, RushMain.class);
		startActivity(intent);
		finish();
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
