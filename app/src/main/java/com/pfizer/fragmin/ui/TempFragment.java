package com.pfizer.fragmin.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pfizer.fragmin.R;

/**
 * Created by 593368 on 9/30/2014.
 */
public class TempFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.temp_layout, container, false);
        return view;
    }
}
