package com.vikas.elibrary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vikas.elibrary.R;

public class FragmentEngineering extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Button ce,cse,it,ee,entc,me;
    String oneText,twoText,threeText,fourText,fiveText,sixText;


    public static Fragment newInstance(String param1, String param2) {
        FragmentEngineering fragment = new FragmentEngineering();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentEngineering() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_engineering, container, false);
         me = (Button) v.findViewById(R.id.btn_me);
         ce = (Button) v.findViewById(R.id.btn_ce);
          ee = (Button) v.findViewById(R.id.btn_ee);
        entc = (Button) v.findViewById(R.id.btn_entc);
        cse = (Button) v.findViewById(R.id.btn_cse);
        it = (Button) v.findViewById(R.id.btn_it);
        oneText= (String) me.getText();
        twoText= (String) ce.getText();
        threeText= (String)ee.getText();
        fourText= (String) entc.getText();
        fiveText= (String) cse.getText();
        sixText= (String) it.getText();
        me.setOnClickListener(this);
        ce.setOnClickListener(this);
        ee.setOnClickListener(this);
        entc.setOnClickListener(this);
        cse.setOnClickListener(this);
        it.setOnClickListener(this);
        cse.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_me:
                if (oneText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", oneText);
                    startActivity(i);
                }
                break;
            case R.id.btn_ce:
                if (twoText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", twoText);
                    startActivity(i);
                }

                break;
            case R.id.btn_ee:
                if (threeText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", threeText);
                    startActivity(i);
                }

                break;
            case R.id.btn_entc:
                if (fourText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", fourText);
                    startActivity(i);
                }

                break;
            case R.id.btn_cse:
                if (fiveText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", fiveText);
                    startActivity(i);
                }

                break;
            case R.id.btn_it:
                if (sixText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", sixText);
                    startActivity(i);
                }

                break;
        }
    }
}
