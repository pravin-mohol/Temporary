package com.pfizer.fragmin.data.helpers;

import com.pfizer.fragmin.R;

import android.content.Context;

public class ConversionDataLoader {
	
	String selectedUnitData ;
	Context context ;
	
	public ConversionDataLoader(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	
	}
	
	public String conversionInsideData(int selectedUnit){
		
		
		
		switch (selectedUnit) {
		case 0:
				selectedUnitData = context.getResources().getString(R.string.range_item_1_description);
				break;
			
		case 1:
				selectedUnitData = context.getResources().getString(R.string.range_item_2_description);
				break;
				
		case 2:
				selectedUnitData = context.getResources().getString(R.string.range_item_3_description);
				break;
		
		case 3:
				selectedUnitData = context.getResources().getString(R.string.range_item_4_description);
				break;
				
		case 4: 		
				selectedUnitData = context.getResources().getString(R.string.range_item_5_description);
				break;
				
		case 5:
				selectedUnitData = context.getResources().getString(R.string.range_item_6_description);
				break;
			
		case 6:
				selectedUnitData = context.getResources().getString(R.string.range_item_7_description);
				break;
				
		default:
			break;
		}
		
		
		return selectedUnitData;
		
	}
	

}
