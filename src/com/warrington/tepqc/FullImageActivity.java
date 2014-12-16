package com.warrington.tepqc;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FullImageActivity extends Activity {

	Intent i;
	Button closeButton;
	
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.full_image);

       // get intent data
       i = getIntent();

    
     //This enables the app icon in the action bar to be the upp button
     		final ActionBar actionBar = getActionBar();
     		actionBar.setDisplayHomeAsUpEnabled(true);
       
       
       // Selected image id
       int position = i.getExtras().getInt("id");
       ImageAdapter imageAdapter = new ImageAdapter(this);

       ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
       imageView.setImageResource(imageAdapter.mThumbIds[position]);
       //closeButton = (Button) findViewById(R.id.closeButton);
       
       imageView.setClickable(true);
       
       imageView.setOnClickListener(new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			finish();
			
		}
    	   
       });
       
       
   }

   public void close(){
	   finish();
   }
}