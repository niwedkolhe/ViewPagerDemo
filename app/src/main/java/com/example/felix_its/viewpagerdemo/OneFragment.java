package com.example.felix_its.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Felix-ITS on 01-12-2016.
 */

public class OneFragment extends Fragment {

    private static final String TAG = "OneFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"OneFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate layout
        View fragmentView = inflater.inflate(R.layout.fragment_one,container,false);

        TextView textViewFragmentOne = (TextView)fragmentView.findViewById(R.id.textViewFragmentOne);

        //Return inflated View to fragment
        return fragmentView;
    }
}
