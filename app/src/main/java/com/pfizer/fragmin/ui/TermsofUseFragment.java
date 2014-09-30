package com.pfizer.fragmin.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.pfizer.fragmin.R;

public class TermsofUseFragment extends Fragment {
	
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

	        View view = inflater.inflate(R.layout.activity_terms_of_use_fragment ,container ,false);

	        WebView  terms_of_use = (WebView)view.findViewById(R.id.webView);
	        terms_of_use.loadUrl("file:///android_asset/terms_of_use.html");
	    return view;
	    }

}
