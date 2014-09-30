package com.pfizer.fragmin.data.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.support.*;

import com.pfizer.fragmin.R;


public class DosingDataLoader {

	
	Context context;
	public DosingDataLoader(Context context) {
		// TODO Auto-generated constructor stub
		
		this.context = context;

	}
	
	ArrayList< String> parentListHeader = new ArrayList<String>();
	ArrayList<String> listOfChilds = new ArrayList<String>();
	HashMap<String, String> childExpander = new HashMap<String, String>();
	public ArrayList<String> indicationParentList(int indication){
		
		
		
		
		//String abc =  context.getResources().getString(R.string.surgery_expandable_view_1);
		//Log.d("abc1", abc);
		
	switch (indication) {
		case 1:
				String abc =  context.getResources().getString(R.string.surgery_expandable_view_1);
				String pqr = context.getResources().getString(R.string.surgery_expandable_view_2);
				
				parentListHeader.add(abc);
				parentListHeader.add(pqr);
				//parentListHeader.add(context.getResources().getString(R.string.surgery_expandable_view_1));
				//parentListHeader.add(1,context.getResources().getString(R.string.surgery_expandable_view_2));
		
				break;
		
		case 2:	
				parentListHeader.add(0, context.getResources().getString(R.string.cancer_expandable_view_1));
				parentListHeader.add(1,context.getResources().getString(R.string.cancer_expandable_view_2));
				parentListHeader.add(2,context.getResources().getString(R.string.cancer_expandable_view_3));
		
				//return parentListHeader;
		
				break;
		case 5 :		
				parentListHeader.add(0 ,context.getResources().getString(R.string.heart_disease_expandable_view_1));
				parentListHeader.add(1,context.getResources().getString(R.string.heart_disease_expandable_view_2));
				//return parentListHeader;
				break;
			
		case 6:
				parentListHeader.add(0,context.getResources().getString(R.string.hemodialysis_expandable_view_1));
				parentListHeader.add(1,context.getResources().getString(R.string.hemodialysis_expandable_view_2));
				//return  parentListHeader;
			
				break;

		default:
			break;
		}
		 
		
	return parentListHeader;
	}
	
	public ArrayList<String> IndicationChildList(int indication , ArrayList<String> parentes , int weight){
		
		weight = weight + 45;
		switch (indication) {
		case 1:
				listOfChilds.add(0,context.getResources().getString(R.string.surgery_expandable_view_1_text));
				listOfChilds.add(1,context.getResources().getString(R.string.surgery_expandable_view_2_text));
				return listOfChilds;
			
			
		case 2: 
			//Log.d("Cancer weight" , "weight change" +weight);
			
			
			int  cancer_wt = weight / 10;
			
				
			
			switch (cancer_wt) {
				case 4:
					
					if(weight < 46 )
					{
						Log.d("Cancer weight" , "weight change" +weight);
					listOfChilds.add(0, context.getResources().getString(R.string.cancer_weight_lessthan_46_view_1));
					listOfChilds.add(1, context.getResources().getString(R.string.cancer_weight_lessthan_46_view_2));
					listOfChilds.add(2, context.getResources().getString(R.string.cancer_weight_lessthan_46_view_3));
					
					//return listOfChilds ;
					}
					
					else if(weight >= 46 && weight <= 49) {
						
						listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_lessthan_57_view_1));
						listOfChilds.add(1, context.getResources().getString(R.string.cancer_weight_lessthan_57_view_2));
						listOfChilds.add(2 ,context.getResources().getString(R.string.cancer_weight_lessthan_57_view_3));
						
					//	return listOfChilds;
						
					}
					break;
					
				case 5 :
						if(weight >= 50 && weight < 57){
							
							listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_lessthan_57_view_1));
							listOfChilds.add(1, context.getResources().getString(R.string.cancer_weight_lessthan_57_view_2));
							listOfChilds.add(2, context.getResources().getString(R.string.cancer_weight_lessthan_57_view_3));
							
							//return listOfChilds;
							
							
						}
						
						else if(weight >= 57 && weight <= 59) {
							
							listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_lessthan_69_view_1));
							listOfChilds.add(1,context.getResources().getString(R.string.cancer_weight_lessthan_69_view_2));
							listOfChilds.add(2,context.getResources().getString(R.string.cancer_weight_lessthan_69_view_3));
							
						//	return listOfChilds;
						}
						break;
				case 6 : 
					if(weight >= 60 && weight <=68){
						
						listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_lessthan_69_view_1));
						listOfChilds.add(1,context.getResources().getString(R.string.cancer_weight_lessthan_69_view_2));
						listOfChilds.add(2,context.getResources().getString(R.string.cancer_weight_lessthan_69_view_3));
						
						//return listOfChilds;
					}
					
					else if(weight == 69){
						
						listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_1));
						listOfChilds.add(1,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_2));
						listOfChilds.add(2,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_3));
						
					//	return listOfChilds;
					}
					break;
					
				case 7:
					
					
						listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_1));
						listOfChilds.add(1,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_2));
						listOfChilds.add(2,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_3));
				
						//return listOfChilds;
					
					break;
				case 8: 
					
					if(weight >= 80 && weight <= 82){
						
						listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_1));
						listOfChilds.add(1,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_2));
						listOfChilds.add(2,context.getResources().getString(R.string.cancer_weight_lessthan_83_view_3));
						
						//return listOfChilds;
					}
					
					else if(weight >= 83){
						
						listOfChilds.add(0,context.getResources().getString(R.string.cancer_weight_morethan_83_view_1));
						listOfChilds.add(1,context.getResources().getString(R.string.cancer_weight_morethan_83_view_2));
						listOfChilds.add(2,context.getResources().getString(R.string.cancer_weight_morethan_83_view_3));
						
						//return listOfChilds;
					}
					
					break;
				
				}
			break;
			
			case 5: 
				
				listOfChilds.add(0,context.getResources().getString(R.string.heart_disease_expandable_view_1_text));
				listOfChilds.add(1,context.getResources().getString(R.string.heart_disease_expandable_view_2_text));
				break;
				//return listOfChilds;
				
			case 6:
				
				listOfChilds.add(0,context.getResources().getString(R.string.hemodialysis_expandable_view_1_text));
				listOfChilds.add(1,context.getResources().getString(R.string.hemodialysis_expandable_view_2_text));
				break;
				//return listOfChilds;
			default:
			break;
		}
		
		return listOfChilds;
	}
	
	
	public HashMap<String, String> indicationChildExpander(int indication , List<String> parentListHeaders , List<String> listOfChilds){
		
		
		switch (indication) {
		case 1:
				childExpander.put(parentListHeaders.get(0), listOfChilds.get(0));
				childExpander.put(parentListHeaders.get(1), listOfChilds.get(1));
			
			break;
			
		case 2 :
				childExpander.put(parentListHeaders.get(0), listOfChilds.get(0));
				childExpander.put(parentListHeaders.get(1), listOfChilds.get(1));
				childExpander.put(parentListHeaders.get(2), listOfChilds.get(2));
				
				break;

		case 3 :
				break;
				
		case 4 : break;
		
		case 5: 
				childExpander.put(parentListHeaders.get(0), listOfChilds.get(0));
				childExpander.put(parentListHeaders.get(1), listOfChilds.get(1));
				
				break;
				
		case 6: 
				childExpander.put(parentListHeaders.get(0), listOfChilds.get(0));
				childExpander.put(parentListHeaders.get(1), listOfChilds.get(1));
		
				break;
		default:
			break;
		}
		return childExpander;
	}
}
