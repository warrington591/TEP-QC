package com.warrington.tepqc.brotherdashboarddesign;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.warrington.tepqc.R;

public class TipMainActivity extends ActionBarActivity {

	
	private static final String TOTAL_BILL = "TOTOAL_BILL";
	private static final String CURRENT_TIP = "CURRENT_TIP";
	private static final String BILL_WITHOUT_TIP = "BILL_WITHOUT_TIP";
	
	private double billBeforeTip;
	private double tipAmount;
	private double finalBill;
	private double taxAmount;
	private int amountOfIndividuals;
	private double individualpays;
	
	EditText billBeforeTipET;
	EditText tipAmountET;
	EditText finalBillTipET;
	EditText taxAmountET;
	EditText amountOfIndividualsET;
	EditText individualsET;

	
	SeekBar tipSeekBar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tip_layout);
		
		//This enables the app icon in the action bar to be the upp button
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		//Determines behavior of the activity. Whether the activity just started
		//or it has been restored
		if(savedInstanceState== null){
			billBeforeTip= 0.0;
			tipAmount = .15;
			finalBill =0.0;
			taxAmount =0.08875;
			amountOfIndividuals=0;
			individualpays=0;
			
		} else{
			billBeforeTip = savedInstanceState.getDouble(BILL_WITHOUT_TIP);
			tipAmount= savedInstanceState.getDouble(CURRENT_TIP);
			finalBill = savedInstanceState.getDouble(TOTAL_BILL);
		}
		
		 billBeforeTipET = (EditText) findViewById(R.id.billEditText);
		 tipAmountET = (EditText) findViewById(R.id.tipEditText);
		 finalBillTipET = (EditText) findViewById(R.id.finalbillEditText);
		 taxAmountET=(EditText) findViewById(R.id.billTaxEditView);
		 amountOfIndividualsET=(EditText) findViewById(R.id.peopleAmountEditText);
		 individualsET=(EditText) findViewById(R.id.individualAmountEditText);
		 tipSeekBar = (SeekBar) findViewById(R.id.changeTipSeekBar);
		 
		 //Implementing changeListeners for EditText views
		 billBeforeTipET.addTextChangedListener(billBeforeTipListener);
		 taxAmountET.addTextChangedListener(taxListener);
		 amountOfIndividualsET.addTextChangedListener(amountOfIndividualsListener);
		 tipSeekBar.setOnSeekBarChangeListener(tipSeekBarListener);
		 
		 
	}

	
	// Listens in Tax Editable View
		private TextWatcher amountOfIndividualsListener = new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				try{
					amountOfIndividuals = Integer.parseInt(s.toString());
				} 
				catch(NumberFormatException e){
					amountOfIndividuals = 0;
				}
				
			
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			
		};
	
	
	// Listens in Tax Editable View
	private TextWatcher taxListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			
			try{
				taxAmount = Double.parseDouble(s.toString());
			} 
			catch(NumberFormatException e){
				taxAmount = 0.0;
			}
			
			//updateTipAndFinalBill();
			updateFinalBill();
			updateEachPay();
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	
	private TextWatcher billBeforeTipListener = new TextWatcher(){

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			
			try{
				billBeforeTip = Double.parseDouble(s.toString());
			} 
			catch(NumberFormatException e){
				billBeforeTip = 0.0;
			}
			
			updateTipAndFinalBill();
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	
	private OnSeekBarChangeListener tipSeekBarListener = new OnSeekBarChangeListener(){

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			
			tipAmount = (tipSeekBar.getProgress()) * .01;
			tipAmountET.setText(String.format("%.02f", tipAmount));
			
			updateTipAndFinalBill();
			updateFinalBill();
			updateEachPay();
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
	};
	//This updates the Tip and Bill Amount
	private void updateTipAndFinalBill(){
		
		double tipAmount = Double.parseDouble(tipAmountET.getText().toString());
		double finalBill = billBeforeTip + (billBeforeTip * tipAmount);
		finalBillTipET.setText(String.format("%.02f", finalBill));
	}
	
	//This updates the Tip,Bill and Tax Amount
		private void updateFinalBill(){
			
			double tipAmount = Double.parseDouble(tipAmountET.getText().toString());
			double finalBill = taxAmount +billBeforeTip + (billBeforeTip * tipAmount);
			finalBillTipET.setText(String.format("%.02f", finalBill));
		}
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_main, menu);
		return true;
	}

	
	protected void onSaveInstanceState(Bundle outState){
			super.onSaveInstanceState(outState);
			
			outState.putDouble(TOTAL_BILL, finalBill);
			outState.putDouble(CURRENT_TIP, tipAmount);
			outState.putDouble(BILL_WITHOUT_TIP, billBeforeTip);
			
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
	
	//Updates Individual Amount
	private void updateEachPay(){
		
	double finalBill = taxAmount + billBeforeTip + (billBeforeTip * tipAmount);
	double individualpays = finalBill / amountOfIndividuals;
	
	individualsET.setText(String.format("%.02f", individualpays));
			}
}
