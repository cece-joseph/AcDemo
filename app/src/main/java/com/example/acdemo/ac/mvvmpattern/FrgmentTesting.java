package com.example.acdemo.ac.mvvmpattern;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.acdemo.R;


public class FrgmentTesting extends Fragment {
    private ScrTesting scrTesting;

    private View view;

    public FrgmentTesting(ScrTesting scrTesting) {
        this.scrTesting=scrTesting;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_frgment_testing,null);

        return view;
    }


    public void Validate()
    {
        Toast.makeText(getActivity(),"Calling Validation",Toast.LENGTH_LONG).show();
    }


}