package com.warrington.tepqc;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class RushPhotoAlbum extends Activity {
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.grid_layout);
	 
	      //This enables the app icon in the action bar to be the upp button
			final ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
	        
	        GridView gridView = (GridView) findViewById(R.id.grid_view);
	 
	        // Instance of ImageAdapter Class
	        gridView.setAdapter(new ImageAdapter(this));
	 
	        /**
	         * On Click event for Single Gridview Item
	         * */
	        
	        gridView.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View v,
	                    int position, long id) {
	 
	                // Sending image id to FullScreenActivity
	                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
	                // passing array index
	                i.putExtra("id", position);
	                startActivityForResult(i, 1);
	                
	            }
	        });
	        
	       
	    }

	 
	   
	   
	}


	
	

	
	







