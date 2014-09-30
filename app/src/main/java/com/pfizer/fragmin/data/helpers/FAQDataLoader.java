package com.pfizer.fragmin.data.helpers;

import java.util.ArrayList;

import com.pfizer.fragmin.R;

import android.content.Context;

public class FAQDataLoader {
	
	
	
	Context context ;
	ArrayList<String> fAQquestionTitleList = new ArrayList<String>();
	ArrayList<String> fAQAnsList = new ArrayList<String>();
	public FAQDataLoader(Context context) {
		// TODO Auto-generated constructor stub
		
		this.context = context;
	}
	
	public ArrayList<String> fAQParentlistHeaders(){
		
		fAQquestionTitleList.add(0,context.getResources().getString(R.string.most_common_fragmin_question_heading_1));
		fAQquestionTitleList.add(1,context.getResources().getString(R.string.most_common_fragmin_question_heading_2));
		fAQquestionTitleList.add(2,context.getResources().getString(R.string.most_common_fragmin_question_heading_3));
		fAQquestionTitleList.add(3,context.getResources().getString(R.string.most_common_fragmin_question_heading_4));
		fAQquestionTitleList.add(4,context.getResources().getString(R.string.most_common_fragmin_question_heading_5));
		fAQquestionTitleList.add(5,context.getResources().getString(R.string.most_common_fragmin_question_heading_6));
		fAQquestionTitleList.add(6,context.getResources().getString(R.string.most_common_fragmin_question_heading_7));
		
		
		return fAQquestionTitleList;
	}
	
	
	public ArrayList<String> fAQChildListData(){
		
		fAQAnsList.add(0,context.getResources().getString(R.string.most_common_fragmin_question_heading_1_description));
		fAQAnsList.add(1,context.getResources().getString(R.string.most_common_fragmin_question_heading_2_description));
		fAQAnsList.add(2,context.getResources().getString(R.string.most_common_fragmin_question_heading_3_description));
		fAQAnsList.add(3,context.getResources().getString(R.string.most_common_fragmin_question_heading_4_description));
		fAQAnsList.add(4,context.getResources().getString(R.string.most_common_fragmin_question_heading_5_description));
		fAQAnsList.add(5,context.getResources().getString(R.string.most_common_fragmin_question_heading_6_description));
		fAQAnsList.add(6,context.getResources().getString(R.string.most_common_fragmin_question_heading_7_description));
		
		
		return fAQAnsList;
	}

}
