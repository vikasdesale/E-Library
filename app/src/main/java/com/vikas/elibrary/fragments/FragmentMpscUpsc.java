package com.vikas.elibrary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vikas.elibrary.R;

public class FragmentMpscUpsc extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    Button mpscqp,upscqp,playvl,audiolect,newsp,spbooks,mag,other;
    String oneText,twoText,threeText,fourText,fiveText,sixText,sevenText,eightText;
    public static Fragment newInstance(String param1, String param2) {
        FragmentMpscUpsc fragment = new FragmentMpscUpsc();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentMpscUpsc() {
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
        View v= inflater.inflate(R.layout.fragment_fragment_mpsc_upsc, container, false);
        mpscqp= (Button) v.findViewById(R.id.btn_mpsc);
        upscqp = (Button) v.findViewById(R.id.btn_upsc);
        playvl = (Button) v.findViewById(R.id.btn_playv);
        audiolect = (Button) v.findViewById(R.id.btn_lect);
        spbooks= (Button) v.findViewById(R.id.btn_spbooks);
        other = (Button) v.findViewById(R.id.btn_other);
        oneText= (String) mpscqp.getText();
        twoText= (String) upscqp.getText();
        threeText= (String)  playvl.getText();
        fourText= (String) audiolect.getText();
        sixText= (String) spbooks.getText();
        eightText= (String) other.getText();
        mpscqp.setOnClickListener(this);
        upscqp.setOnClickListener(this);
        playvl.setOnClickListener(this);
        audiolect.setOnClickListener(this);
        spbooks.setOnClickListener(this);
        other.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mpsc:
                if (oneText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", oneText);
                    startActivity(i);
                }
                break;
            case R.id.btn_upsc:
                if (twoText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", twoText);
                    startActivity(i);
                }

                break;
            case R.id.btn_playv:
                if (threeText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", threeText);
                    startActivity(i);
                }

                break;
            case R.id.btn_lect:
                if (fourText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", fourText);
                    startActivity(i);
                }




                break;
            case R.id.btn_spbooks:
                if (sixText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",sixText);
                    startActivity(i);
                }

                break;



            case R.id.btn_other:
                if(eightText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",eightText);
                    startActivity(i);
                }

                break;
        }
    }
}
