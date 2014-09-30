package com.pfizer.fragmin.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.pfizer.fragmin.SplashScreenActivity;
import com.pfizer.fragmin.R;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TermsOfUse extends FragmentActivity /*extends ActionBarActivity*/ {

    private static Button btnAgree, btnDisagree;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
       this.requestWindowFeature(Window.FEATURE_NO_TITLE);
       setContentView(R.layout.activity_terms_of_use);
        
        initUI();
        btnAgree.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
			startActivity(intent);
			finish();
			}
		});
        
        Intent intent = getIntent();
        replaceFragment(new TermsofUseFragment());
    }


	public void initUI() {
		btnAgree = (Button) findViewById(R.id.btn_I_Agree);
		btnDisagree = (Button) findViewById(R.id.Btn_I_Disagree);
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
    
    public void replaceFragment(Fragment fragment){
    	
    	FragmentManager fragmentManager = getSupportFragmentManager();
    	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    	fragmentTransaction.replace(R.id.tNu_fragment_cntnr, fragment);
    	fragmentTransaction.commit();
    }
}
