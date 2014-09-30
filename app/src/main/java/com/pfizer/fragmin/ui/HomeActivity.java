package com.pfizer.fragmin.ui;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
//import android.app.Fragment;

import com.pfizer.fragmin.R;
import com.pfizer.fragmin.adapters.NavDrawerListAdapter;
import com.pfizer.fragmin.model.NavDrawerItem;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class HomeActivity extends ActionBarActivity {
	
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Adding fragmin logo at the right side of Action Bar
		/*android.support.v7.app.ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayOptions(actionBar.getDisplayOptions()
	            | ActionBar.DISPLAY_SHOW_CUSTOM);
	    getSupportActionBar().setDisplayShowTitleEnabled(false); // To disable the title coming at the Action Bar
	    getSupportActionBar().setDisplayShowHomeEnabled(false);
	    actionBar.setDisplayShowCustomEnabled(true); //
	    ImageView imageView = new ImageView(actionBar.getThemedContext());	    
//	    imageView.setScaleType(ImageView.ScaleType.CENTER);
	    imageView.setImageResource(R.drawable.fragmin_logo);
	    @SuppressWarnings("deprecation")
		android.support.v7.app.ActionBar.LayoutParams layoutParams = new android.support.v7.app.ActionBar.LayoutParams(
	    		android.support.v7.app.ActionBar.LayoutParams.MATCH_PARENT,
	    		android.support.v7.app.ActionBar.LayoutParams.MATCH_PARENT, Gravity.RIGHT
	                    | Gravity.CENTER_VERTICAL);
//	    layoutParams.rightMargin = 40;
	    imageView.setLayoutParams(layoutParams);
	    actionBar.setCustomView(imageView);*/
		
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayShowCustomEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflator.inflate(R.layout.actionbar_image_logo, null);
		actionBar.setCustomView(v);
	    
		
		mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		// adding nav drawer items to array
		for (int i=0; i < navMenuTitles.length; i++) {
			navDrawerItems.add(new NavDrawerItem(navMenuTitles[i], navMenuIcons.getResourceId(i, -1)));
		}
		
		

		// Recycle the typed array
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
//				invalidateOptionsMenu();
				supportInvalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				supportInvalidateOptionsMenu();
			}
		};
//		mDrawerLayout.setDrawerListener(mDrawerToggle); // Shashi commented this out to stop the movement of Navigation Drawer icon

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.main, menu); //Commented this to remove More Options button in Action Bar
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
//		menu.findItem(R.id.action_settings).setVisible(!drawerOpen); //Commented this to remove More Options button in Action Bar
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			//fragment = new Do
			break;
		case 1:
			fragment = new DosageFragment();
			break;
		case 2:
			fragment = new ConversionFragment();
			break;
		case 3:
			fragment = new SpecialPatientGroupFragment();
			break;
		case 4:
			//fragment = new PagesFragment();
            fragment = new TempFragment();
			break;
		case 5:
			//fragment = new RiskRoleFragment();
            fragment = new TempFragment();
			break;
        case 6:
//            fragment = new InjectionTechniqueFragment();
            fragment = new TempFragment();
                break;
            case 7:
//                Side effects
                fragment = new TempFragment();
                break;
            case 8:
//                No fragment;
                fragment = new TempFragment();
                break;
            case 9:
                //fragment = new WhatIsFragminFragment();
                fragment = new TempFragment();
                break;
            case 10:
                //fragment = new FAQFragment();
                fragment = new TempFragment();
                break;
            case 11:
                //fragment = new InformationForProfessionalFragment();
                fragment = new TempFragment();
                break;
            case 12:
                //fragment = new FragminContactInformationFragment();
                fragment = new TempFragment();
                break;
            case 13:
                fragment = new TermsofUseFragment();
                break;
            case 14:
                //fragment = new AcronymTableUserGuideFragment();
                fragment = new TempFragment();
                break;

		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}
