package com.warrington.tepqc;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RushContactUs extends Activity {
	
	Button send;
	EditText fullname;
	EditText email;
	EditText phone;
	EditText body_of_email;
	CheckBox checkbox;
	
	String prefers_phoneCorespondance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_contact_us);
		
		//This enables the app icon in the action bar to be the up button
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		fullname = (EditText) findViewById(R.id.FullNameEditText);
		email =(EditText) findViewById(R.id.EmailEditText);
		phone = (EditText) findViewById(R.id.phoneNumberEditText);
		body_of_email = (EditText) findViewById(R.id.bodyEditText);
		send =(Button) findViewById(R.id.buttonSend);
		checkbox = (CheckBox) findViewById(R.id.preferEmailCheckBox);
		
		send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				//Getting data from EditTextViews from contact form
				String rushchairemail ="emailfortesting2020@gmail.com";
				String fullname_toSend = fullname.getText().toString();
				String email_toSend = email.getText().toString();
				String phone_toSend = phone.getText().toString();
				String bodyText_toSend = body_of_email.getText().toString();
				String prefers_phoneCorespondance;
				
				if(checkbox.isChecked()){
					prefers_phoneCorespondance ="Phone";
				}else
					prefers_phoneCorespondance ="Email";
				
				Intent mail = new Intent(Intent.ACTION_SEND);
				mail.putExtra(Intent.EXTRA_EMAIL, new String[] {rushchairemail});
				mail.putExtra(Intent.EXTRA_SUBJECT, "Interested about Rush");
				mail.putExtra(Intent.EXTRA_TEXT, "Full Name: "+ fullname_toSend+"\nPhone Number: "+phone_toSend
						+"\nEmail: "+email_toSend+"\nContact Preference: "+prefers_phoneCorespondance+"\n\n"+bodyText_toSend);

				mail.setType("message/rfc822");
				startActivity(Intent.createChooser(mail, "Send email via:"));
				finish();

			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rush_contact_us, menu);
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
