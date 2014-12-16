package com.warrington.tepqc;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Alumni extends Activity {

	ListView list;
	String[] descriptions;
	String[] names;
	
 
	  int[] imageId = {
		      R.drawable.alumni1,
		      R.drawable.alumni2,
		      R.drawable.alumni3,
		      R.drawable.alumni4,
		      R.drawable.alumni5,
		      R.drawable.alumni6,
		      R.drawable.alumni7
		  };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alumni);
		
		//This enables the app icon in the action bar to be the upp button
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		
		Resources res = getResources();
		names=res.getStringArray(R.array.AlumniNames);
		descriptions = res.getStringArray(R.array.Descriptions);
		
		list=(ListView)findViewById(R.id.alumniList);
		
		AlumniList adapter = new AlumniList(this, names, imageId, descriptions );
		list.setAdapter(adapter);
		 
	  }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alumni, menu);
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
}

 class AlumniList extends ArrayAdapter<String>{


	
	Context context;
	int [] images;
	String [] alNames;
	String [] alDescriptions;
	
	AlumniList(Context c, String[] names, int img[], String[] descriptions){
		super(c, R.layout.single_row, R.id.alumniName, names);
		this.context=c;
		this.images=img;
		this.alNames=names;
		this.alDescriptions=descriptions;
	}
	
	


	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
	

		
	LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
	View row =inflater.inflate(R.layout.single_row, parent, false);	
		
	ImageView imageview = (ImageView) row.findViewById(R.id.AlumniImageView);
	TextView textviewName = (TextView) row.findViewById(R.id.alumniName);
	TextView textviewDescription = (TextView) row.findViewById(R.id.alumniDescription);
	
	imageview.setImageResource(images[position]);
	textviewName.setText(alNames[position]);
	textviewDescription.setText(alDescriptions[position]);
	return row;
	}
	
}



