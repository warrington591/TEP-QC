package com.warrington.tepqc;


import com.warrington.tepqc.brotherdashboarddesign.DashboardDesign;






import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


public class RushMain extends FragmentActivity implements ActionBar.TabListener  {

	AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	ViewPager mViewPager;


	Button testbutton;
	
	//For Alumni Fragment Section
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
	//End of Alumni Fragment
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rush_main);

		
		mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
		
		//This enables the app icon in the action bar to be the up button
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		
		// Displays tabs in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
        // ViewPager attached to the adapter as well as setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // Allows swiping between different sections of the tabbed Rush section
                actionBar.setSelectedNavigationItem(position);
            }
            });
        
        
    	//Creating each Tab
    	//Tab1
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Home")
                        .setTabListener(this));
        
        //Tab2
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Events")
                        .setTabListener(this));
        //Tab 3
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Media")
                        .setTabListener(this));

        //Tab 4
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Contact Us")
                        .setTabListener(this));
	}
	

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// This inflates to the action bar 
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	    switch (item.getItemId()) {
        case R.id.action_search:
       
            return true;
        case R.id.action_settings:
            
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
	}

		@Override
		 public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	        // When the given tab is selected this switches to the corresponding page in the ViewPager.
	        mViewPager.setCurrentItem(tab.getPosition());
	    }

		@Override
		public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	    }

		@Override
		public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	    }
	    
		
		//Link for FragmentPagerAdapter
	    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

	        public AppSectionsPagerAdapter(FragmentManager fm) {
	            super(fm);
	        }

	        @Override
	        public Fragment getItem(int i) {
	        	
	        	Fragment fragment = null;
	        	Bundle args = new Bundle();
	        	
	            switch (i) {
	                case 0:
	                	return new AboutTep();
	                	
	                case 1:
	                	return new TepEvents();
	                
	                case 2:
	                    return new Media();

	                case 3:
	                	fragment = new ContactUs();
	                	args.putInt(ContactUs.ARG_SECTION_NUMBER, i + 1);
	                	fragment.setArguments(args);
	                	break;	

	                default:
	                    
	                    fragment = new ContactUs();
	                    args.putInt(ContactUs.ARG_SECTION_NUMBER, i + 1);
	                    fragment.setArguments(args);
	                    break;
	            }
	            
	            return fragment;
	        }

	        @Override
	        public int getCount() {
	            return 4;
	        }

	        @Override
	        public CharSequence getPageTitle(int position) {
	            return "Section " + (position + 1);
	        }
	    }

	    // Fragment functions
	    public static class Media extends Fragment {

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.fragment_section_launchpad, container, false);

	            //Starts Rush Album
	            rootView.findViewById(R.id.demo_collection_button)
	                    .setOnClickListener(new View.OnClickListener() {
	                        @Override
	                        public void onClick(View view) {
	                            Intent intent = new Intent(getActivity(), RushPhotoAlbum.class);
	                            startActivity(intent);
	                        }
	                    });

	            // Activates the Rush trailer
	            //Using Youtube API
	            rootView.findViewById(R.id.demo_external_activity)
	                    .setOnClickListener(new View.OnClickListener() {
	                        @Override
	                        public void onClick(View view) {
	                        	Intent intent = new Intent(getActivity(), RushTrailer.class);
	                            startActivity(intent);  
	                        }
	                    });
	            
	            
	            //Launcher for the Alumni Section
	            rootView.findViewById(R.id.notableAlumni)
	                    .setOnClickListener(new View.OnClickListener() {
	                        @Override
	                        public void onClick(View view) {
	                            Intent intent = new Intent(getActivity(), Alumni.class);
	                            startActivity(intent);
	                        }
	                    });

	            return rootView;
	        }
	    }
	    
	    //Contacts Section
	    public static class ContactUs extends Fragment implements OnClickListener {

	        public static final String ARG_SECTION_NUMBER = "section_number";
	        
	        
	        public void onCreate(Bundle savedInstanceState){
	                super.onCreate(savedInstanceState);
	                }
	        
	        public void onActivityCreated(Bundle savedInstanceState){
	        	super.onActivityCreated(savedInstanceState);
	           }    
	        
	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
	            ImageView imgButton = (ImageView) rootView.findViewById(R.id.rushContactImage);
	            imgButton.setOnClickListener(this);
	            return rootView;
	        }
	        
	        //Starts the activity for RushContactUs if the image in the fragment is pressed
			@Override
			public void onClick(View v) {
				if(v.getId()==R.id.rushContactImage){
					startActivity(new Intent(v.getContext(),RushContactUs.class));
					
				}
				
			}
	        
	        

	    }
	    
	    public static class TepEvents extends Fragment {

	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.activity_rush_events, container, false);
	            return rootView;
	        }
	    }
	    
	    public static class AboutTep extends Fragment {
	        @Override
	        public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                Bundle savedInstanceState) {
	            View rootView = inflater.inflate(R.layout.about_tep, container, false);
	            return rootView;
	        }
	    }	        
}
	    

	
