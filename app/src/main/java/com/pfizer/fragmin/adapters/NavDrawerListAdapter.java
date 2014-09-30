package com.pfizer.fragmin.adapters;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;
import com.pfizer.fragmin.R;
import com.pfizer.fragmin.model.NavDrawerItem;

public class NavDrawerListAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<NavDrawerItem> navDrawerItems;
	
	public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {		
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
//        }
		
		System.out.println("----- position = " + position);
         
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);
        
        //This condition checks if the item in Slider is a header
        if ((position == 0) || (position == 4) || (position == 8)) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.drawer_header_background));
        	RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        	imgIcon.setVisibility(View.GONE);
        	params.height = 100; 					//Height of the Headers in Slider Menu
        	params.setMargins(20, 0, 0, 0); 		//Setting margin to the Texts in Header
        	txtTitle.setLayoutParams(params);
        	
        } else {
        	imgIcon.setImageResource(navDrawerItems.get(position).getIcon());	
        }        
                
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        
        // displaying count
        // check whether it set visible or not
        if(navDrawerItems.get(position).getCounterVisibility()){
        	txtCount.setText(navDrawerItems.get(position).getCount());
        }else{
        	// hide the counter view
        	txtCount.setVisibility(View.GONE);
        }
        
        return convertView;
	}

}
