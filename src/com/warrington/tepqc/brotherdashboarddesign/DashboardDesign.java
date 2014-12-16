package com.warrington.tepqc.brotherdashboarddesign;

import com.warrington.tepqc.R;
import com.warrington.tepqc.R.id;
import com.warrington.tepqc.R.layout;
import com.warrington.tepqc.R.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashboardDesign extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);
		
		//This enables the app icon in the action bar to be the upp button
				getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		/**
         * Creating  buttons instances
         * */
				
        // Dashboard News feed button
        Button btn_newsfeed = (Button) findViewById(R.id.btn_news_feed);
         
        // Dashboard Brother button
        Button brother = (Button) findViewById(R.id.brother);
         
        // Dashboard Tip Calculator button
        Button tipCalculator = (Button) findViewById(R.id.tipCalculator);
         
        // Dashboard Calendar button
        Button calendar = (Button) findViewById(R.id.calendar);
         
        // Dashboard Mixer button
        Button mixer = (Button) findViewById(R.id.mixer);
         
        // Dashboard Photos button
        Button photos = (Button) findViewById(R.id.photos);
         
        /**
         * Handling all button click events
         * */
         
        // Listening to News Feed button click
        btn_newsfeed.setOnClickListener(new View.OnClickListener() {
        	 @Override
             public void onClick(View view) {
                 // Launching News Feed Screen
                 Intent i = new Intent(getApplicationContext(), NewsFeedActivity.class);
                 startActivity(i);
             }
         });
        
     // Listening Brother Profile button click
        brother.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), BrotherProfile.class);
                startActivity(i);
            }
        });
        
     // Listening Tip Calculator button click
        tipCalculator.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                //Intent i = new Intent(getApplicationContext(), TipMainActivity.class);
               // startActivity(i);
            	
            	showOnTipButtonClick();
            }
            
            
            
        });
        
     // Listening to Events button click
        calendar.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), EventsActivity.class);
                startActivity(i);
            }
        });
        
        
     // Listening to Mixer button click
        mixer.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), MixersActivity.class);
                startActivity(i);
            }
        });
        
     // Listening to Photos button click
        photos.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), PhotosActivity.class);
                startActivity(i);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard_design, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void showOnTipButtonClick(){
    	AlertDialog.Builder message = new AlertDialog.Builder(this);
    	message.setTitle("Bill Splitter");
    	message.setMessage("How would you like to split the bill?");
    	message.setPositiveButton("Split Evenly", new DialogInterface.OnClickListener() {
			
			

			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Toast.makeText(getApplicationContext(), "Splitting Bill Evenly", Toast.LENGTH_SHORT).show();
				 Intent i = new Intent(getApplicationContext(), TipMainActivity.class);
	               startActivity(i);
			}
		});

    	message.setNegativeButton("Split Individually", new DialogInterface.OnClickListener() {
		
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "Splitting Bill Individually", Toast.LENGTH_SHORT).show();
				
			}
		});
    	AlertDialog alertdialog = message.create();
    	alertdialog.show();
    }
}
