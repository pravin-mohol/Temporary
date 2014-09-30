package com.pfizer.fragmin.ui;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.pfizer.fragmin.R;
import com.pfizer.fragmin.adapters.ConversionArrayAdapter;
import com.pfizer.fragmin.adapters.WeightArrayAdapter;
import com.pfizer.fragmin.data.helpers.ConversionDataLoader;

public class ConversionFragment extends Fragment {

	WheelView conversionUnitsWheel;
	private boolean scrolling = false;
	int selectedUnit;
	ConversionDataLoader conversionDataLoader ;
	String conversionData ;
	ConversionArrayAdapter conversionArrayAdapter ;
	WebView webview ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View conversionView = inflater.inflate(R.layout.fragment_conversion_table, container, false);
		conversionUnitsWheel = (WheelView) conversionView.findViewById(R.id.wheel_conversion_units);
		
		addWheelListeners();
		
		String conversion_units[] = getResources().getStringArray(R.array.conversion_units);
		conversionUnitsWheel.setViewAdapter(new WeightArrayAdapter(getActivity(), conversion_units, 2));
		conversionUnitsWheel.setCurrentItem(2);
		
		
		webview = (WebView) conversionView.findViewById(R.id.conversion_table_webview);
		conversionData = getString(R.string.range_item_3_description);
		webview.loadData(conversionData, "text/html", null);
		
		
		return conversionView;
	}
	
	public void addWheelListeners() {
		conversionUnitsWheel.addScrollingListener( new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;				
				conversionDataLoader = new ConversionDataLoader(getActivity());
				conversionData = conversionDataLoader.conversionInsideData(selectedUnit);
				//webview.loadData(conversionData, "text/html", null);
				webview.loadDataWithBaseURL(null, conversionData, "text/html", "utf-8", null);
				
				
			}
		});
		
		conversionUnitsWheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				selectedUnit = newValue;
				if (!scrolling) {
					
				}
			}
		});
	}
}
