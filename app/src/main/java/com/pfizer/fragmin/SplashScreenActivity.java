package com.pfizer.fragmin;


import org.json.JSONException;
import org.json.JSONObject;

import android.R.bool;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.pfizer.fragmin.http.AppValidator;
import com.pfizer.fragmin.http.IHttpResponseCallback;
import com.pfizer.fragmin.ui.DosageFragment;

public class SplashScreenActivity extends FragmentActivity implements IHttpResponseCallback{
	
	String jsonResponse;
	String appID,reCalled,minVersion,deCommisioned;
	private static final String appSharefPref = "fragminSharedPref";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);		
		replaceFragment(new DosageFragment());
		
		AppValidator applValidator = new AppValidator(this,this);
//		applValidator.execute("http://mmstatus-stg.pfizer.com/status/testapp");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void replaceFragment(Fragment fragment)
	{
		FragmentManager fragManager = getSupportFragmentManager();
		FragmentTransaction fragTransaction = fragManager.beginTransaction();		
		fragTransaction.replace(R.id.rl_mainlayout, fragment);
		fragTransaction.commit();

	}

	@Override
	public void postResult(String httpResponse) {
		// TODO Auto-generated method stub
		this.jsonResponse = httpResponse ;
		Log.d("HTTPResponse", "response is " + httpResponse);
		
		validateJsonData(jsonResponse);
		
		//if(response)
	}
	
	public void saveAppValidationData()
	{
		
	}
	
	public void getAppValidationData()
	{
		SharedPreferences settings = getSharedPreferences(appSharefPref,0);  
		String recall = settings.getString("recall", ""); 
		String deCommisioned = settings.getString("deCommision", ""); 
		String ver = settings.getString("versionNo", ""); 
	}
	
	public void comparesaveAppValidationData()
	{
		
	}

    public void saveSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences(appSharefPref, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveSharedPreferences(String key, Boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences(appSharefPref, MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
	
	public void validateJsonData(String jsonResponse) {
		try {
			
			JSONObject jsonObj = new JSONObject(jsonResponse);
			boolean recall =  (Boolean) jsonObj.get("recalled");
			boolean decommissioned = jsonObj.getBoolean("decommissioned");
			String versionNameFromServer = jsonObj.getString("minVersion");
			String appId = jsonObj.getString("appId");

            saveSharedPreferences("recalled", recall);
            saveSharedPreferences("decommissioned", decommissioned);
            saveSharedPreferences("minVersion", versionNameFromServer);
			
			Log.d("HomeActivity","-----recall = " + recall);
			Log.d("HomeActivity","-----decommissioned = " + decommissioned);
			Log.d("HomeActivity","-----minVersionName = " + versionNameFromServer);
			Log.d("HomeActivity","-----appId = " + appId);
			
			if (appId != null || versionNameFromServer != null) {
				int currentVersion = Integer.parseInt(getCurrentVersion().replaceAll("[s\\.]", ""));
				int serverVersion = Integer.parseInt(versionNameFromServer.replaceAll("[s\\.]", ""));
				Log.d("HomeActivity", "-----currentVersion = " + currentVersion);
				Log.d("HomeActivity", "-----serverVersion = " + serverVersion);
				
				if ((decommissioned == true) || (recall == true)) {
					// TODO Show alert box to close the application
				} else if (currentVersion < serverVersion) {
					// TODO Show alert message box to update the app
				}
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCurrentVersion() {
		String versionName="abc";
		try {
			versionName = this.getPackageManager()
				    .getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return versionName;
	}
}
