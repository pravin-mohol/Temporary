package com.pfizer.fragmin.ui;


import com.pfizer.fragmin.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class SpecialPatientGroupFragment extends Fragment{
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_fragmin_generic_layout, container, false);
		TextView  title_special_patient_group = (TextView)view.findViewById(R.id.fragmin_generic_layout_title);
		title_special_patient_group.setText(R.string.special_patient_group_title);
		WebView webview = (WebView) view.findViewById(R.id.generic_layout_webView);
//        WebView webview = (WebView) view.findViewById(R.id.special_patient_group_webView);
		String webviewData = getResources().getString(R.string.special_patient_group);
		webview.loadData(webviewData, "text/html", null);
		return view;
	}

}
