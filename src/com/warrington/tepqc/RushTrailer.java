package com.warrington.tepqc;

import java.util.List;



import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RushTrailer extends Activity implements View.OnClickListener {

	private static final int REQ_START_STANDALONE_PLAYER = 1;
	private static final int REQ_RESOLVE_SERVICE_MISSING = 2;

	private static final String VIDEO_ID = "VTECtimOObo";
	private static final String PLAYLIST_ID =  "7E952A67F31C58A3";
	
	  private Button playVideoButton;
	  private Button playPlaylistButton;

	  private EditText startIndexEditText;
	  private EditText startTimeEditText;
	  private CheckBox autoplayCheckBox;
	  private CheckBox lightboxModeCheckBox;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rush_trailer);
		
		playVideoButton = (Button) findViewById(R.id.start_video_button);
	    playPlaylistButton = (Button) findViewById(R.id.start_playlist_button);
	    startIndexEditText = (EditText) findViewById(R.id.start_index_text);

	    
	    int startIndex = parseInt(startIndexEditText.getText().toString(), 0);
	    int startTimeMillis = parseInt(startTimeEditText.getText().toString(), 0) * 1000;
	    boolean autoplay = true;
	    boolean lightboxMode = false;
	    
	    Intent intent = null;
	    
	    intent = YouTubeStandalonePlayer.createVideoIntent(
		          this, YDeveloperKey.DEVELOPER_KEY, VIDEO_ID, startTimeMillis, autoplay, lightboxMode);
	
	    if (intent != null) {
		      if (canResolveIntent(intent)) {
		        startActivityForResult(intent, REQ_START_STANDALONE_PLAYER);
		      } else {
		        // Could not resolve the intent - must need to install or update the YouTube API service.
		        YouTubeInitializationResult.SERVICE_MISSING
		            .getErrorDialog(this, REQ_RESOLVE_SERVICE_MISSING).show();
		      }
		    }
	    
	    finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rush_trailer, menu);
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

	@Override
	public void onClick(View v) {
		 int startIndex = parseInt(startIndexEditText.getText().toString(), 0);
		    int startTimeMillis = parseInt(startTimeEditText.getText().toString(), 0) * 1000;
		    boolean autoplay = autoplayCheckBox.isChecked();
		    boolean lightboxMode = lightboxModeCheckBox.isChecked();

		    Intent intent = null;
		    if (v == playVideoButton) {
		      intent = YouTubeStandalonePlayer.createVideoIntent(
		          this, YDeveloperKey.DEVELOPER_KEY, VIDEO_ID, startTimeMillis, autoplay, lightboxMode);
		    } else if (v == playPlaylistButton) {
		      intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YDeveloperKey.DEVELOPER_KEY,
		          PLAYLIST_ID, startIndex, startTimeMillis, autoplay, lightboxMode);
		    }

		    if (intent != null) {
		      if (canResolveIntent(intent)) {
		        startActivityForResult(intent, REQ_START_STANDALONE_PLAYER);
		      } else {
		        // Could not resolve the intent - must need to install or update the YouTube API service.
		        YouTubeInitializationResult.SERVICE_MISSING
		            .getErrorDialog(this, REQ_RESOLVE_SERVICE_MISSING).show();
		      }
		    }
		
	}
	
	 @Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    if (requestCode == REQ_START_STANDALONE_PLAYER && resultCode != RESULT_OK) {
	      YouTubeInitializationResult errorReason =
	          YouTubeStandalonePlayer.getReturnedInitializationResult(data);
	      if (errorReason.isUserRecoverableError()) {
	        errorReason.getErrorDialog(this, 0).show();
	      } else {
	        String errorMessage =
	            String.format(getString(R.string.error_player), errorReason.toString());
	        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
	      }
	    }
	  }
	 
	 private boolean canResolveIntent(Intent intent) {
		    List<ResolveInfo> resolveInfo = getPackageManager().queryIntentActivities(intent, 0);
		    return resolveInfo != null && !resolveInfo.isEmpty();
		  }
	 
		  private int parseInt(String text, int defaultValue) {
		    if (!TextUtils.isEmpty(text)) {
		      try {
		        return Integer.parseInt(text);
		      } catch (NumberFormatException e) {
		        // fall through
		      }
		    }
		    return defaultValue;
		  }
}
