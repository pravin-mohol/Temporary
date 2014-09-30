package com.pfizer.fragmin.adapters;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.pfizer.fragmin.R;

public class ExpandListAdapter extends BaseExpandableListAdapter {
	
	private List<String> parentHeaders;
	private HashMap<String, String> childContent;
	private Context context;
	
	 public ExpandListAdapter(Context context , List<String> parentHeaders , HashMap<String, String> childContent) 
	 {
		this.context = context;
		this.parentHeaders = parentHeaders;
		this.childContent = childContent;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return parentHeaders.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return parentHeaders.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childContent.get(parentHeaders.get(groupPosition));
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String parentHeader = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandlist_header,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.id.expandlist_header_tv);
        item.setText(parentHeader);
        return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String file = (String) getChild(groupPosition, childPosition);
		Log.d("Wheel", file);
		
				LayoutInflater infalInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         
        if (convertView == null) {
            convertView = infalInflater.inflate(R.layout.expandlist_content, null);
        }         
        WebView webview = (WebView) convertView.findViewById(R.id.expandlist_content_wv);
        webview.loadData(file, "text/html", null);
        return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void refreshData(List<String> parentHeader , HashMap<String, String> childContents)
	{
		this.parentHeaders = parentHeader;
		this.childContent = childContents;		
		notifyDataSetChanged();
	}
	
	public void clearAdapter()
	{
		this.parentHeaders.clear();
		this.childContent.clear();
	}

}
