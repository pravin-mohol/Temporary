package com.pfizer.fragmin.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ExpandableListView;

import com.pfizer.fragmin.R;
import com.pfizer.fragmin.data.helpers.DosingDataLoader;
import com.pfizer.fragmin.adapters.ExpandListAdapter;
import com.pfizer.fragmin.adapters.IndicationArrayAdapter;
import com.pfizer.fragmin.adapters.WeightArrayAdapter;
import com.pfizer.fragmin.data.helpers.GenericHelper;

public class DosageFragment extends Fragment{
	
	 WheelView weightWheel;
	 WheelView indicationWheel;
	 ExpandableListView expandList;
	 int selectedWeight,selectedIndication;
	 private boolean scrolling = false;
	 HashMap<String, String> childExpander ;
	 List<String> parentListHeaders;
	 List<String> listOfChilds;
	 
	 ExpandListAdapter exapandListAdapter;
	 DosingDataLoader dosingDataLoader;
	 
	 //added by Archana
	 WebView dosingWebview ;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 dosingDataLoader = new DosingDataLoader(getActivity());
		 childExpander = new HashMap<String, String>();
			parentListHeaders = new ArrayList<String>();
			listOfChilds = new ArrayList<String>();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		
		View dosageView = inflater.inflate(R.layout.fragment_dosage, container, false);
		
		// Defiing Widgets from fragment Layout File
		weightWheel = (WheelView) dosageView.findViewById(R.id.weight);
		indicationWheel = (WheelView) dosageView.findViewById(R.id.indication);
		expandList = (ExpandableListView) dosageView.findViewById(R.id.fragdosage_expandListView);
		
		exapandListAdapter = new ExpandListAdapter(getActivity(), parentListHeaders, childExpander);
		expandList.setAdapter(exapandListAdapter);						
		addWheelListeners();				
		
		//String weight_list[] = new String[]{"1","2","3","4","5","6","7","8","9"};		
		String weight_list[] = getResources().getStringArray(R.array.weight_array);
		String indications[] = getResources().getStringArray(R.array.array_indications);
		weightWheel.setViewAdapter(new WeightArrayAdapter(getActivity(), weight_list, 5));
		indicationWheel.setViewAdapter(new IndicationArrayAdapter(getActivity(), indications, 2));
		
		
		
		return dosageView;
	}
	
	public void addWheelListeners()
	{
		weightWheel.addScrollingListener( new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				Log.d("Wheels", "Weight on scrolling started");
				scrolling = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;				
				Log.d("Wheels", "Weight on scrolling ended");
				exapandListAdapter.clearAdapter();
				loadData();
				
			}
			
			
			
		});
		
		weightWheel.addChangingListener(new OnWheelChangedListener() {
		
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				Log.d("Wheels", "Weight changing ouside if" +newValue);
				selectedWeight = newValue;
				if (!scrolling) {					
					Log.d("Wheels", "Weight changing");
					Log.d("Wheels", Integer.toString(newValue));
				}
			}
			
		});
		
		
		indicationWheel.addScrollingListener( new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				Log.d("Wheels", "Indication on Scrolling started");
				scrolling = true;
			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;				
				Log.d("Wheels", "Indication on Scrolling ended");
				exapandListAdapter.clearAdapter();
				loadData();
			}
		});
		
		indicationWheel.addChangingListener(new OnWheelChangedListener() {
			
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				Log.d("Wheels", "Indication changing outside if");
				selectedIndication = newValue;
				if (!scrolling) {
					
					Log.d("Wheels", "Indication changing");
					Log.d("Wheels", Integer.toString(newValue));					
				}
			}
			
		});
		
		
		
		
	}
	
	
	public void loadData()
	{
		Log.d("Wheels", "Load data called with indication,weight  "+ selectedIndication + "--"+ selectedWeight);
		parentListHeaders.clear();
		listOfChilds.clear();
		if(selectedIndication == 1 || selectedIndication == 2 || selectedIndication == 5 || selectedIndication ==6)
		{
			parentListHeaders = dosingDataLoader.indicationParentList(selectedIndication);
			listOfChilds = dosingDataLoader.IndicationChildList(selectedIndication, (ArrayList<String>) parentListHeaders, selectedWeight);
			childExpander = dosingDataLoader.indicationChildExpander(selectedIndication, parentListHeaders, listOfChilds);
			exapandListAdapter.refreshData(parentListHeaders, childExpander);
		}
		else
		{
			
			//for other indications
		}
	}
	
	
	

}
