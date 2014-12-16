package com.warrington.tepqc;



 
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
 
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.photo_grid, R.drawable.photo_grid2,
            R.drawable.photo_gridthree, R.drawable.photo_gridfour,
            R.drawable.photo_gridfive, R.drawable.photo_gridsix,
            R.drawable.photo_gridseven , R.drawable.r10 , R.drawable.r11,
            R.drawable.r12, R.drawable.r13, R.drawable.r14, R.drawable.r15,
            R.drawable.r14, R.drawable.r16, R.drawable.r18, R.drawable.r19, R.drawable.r20
    };
 
    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
 
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
    
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView = new ImageView(mContext);
//        imageView.setImageResource(mThumbIds[position]);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
//        return imageView;
//    }
    
    
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

	  LayoutInflater inflater = (LayoutInflater) mContext
              .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  
	  View gridview;
	  
	  
	  
//	  if(convertView == null){
		  gridview = new View(mContext);
		  gridview = inflater.inflate(R.layout.activity_full_image, null);
		  ImageView imageView = (ImageView)gridview.findViewById(R.id.fullImageView);

          
		  BitmapFactory.Options options = new BitmapFactory.Options();
		  
		  options.inDither = false;
          options.inJustDecodeBounds = false;
          options.inPreferredConfig = Config.ARGB_8888;
          options.inSampleSize = 4;
          options.inPurgeable = true;
		  
                   
          Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),
        		  mThumbIds[position],options);
          
          imageView.setImageBitmap(icon);
          
//	  }
//	  else {
//          gridview = (View) convertView;
//      }
      return gridview;
  }
    
    
 
}