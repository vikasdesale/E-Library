package com.vikas.elibrary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vikas.elibrary.R;

public class FragmentOther extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    Button marathi,hindi,urdu,novels,motivation,romance,shayari,story;
    String oneText,twoText,threeText,fourText,fiveText,sixText,sevenText,eightText;
    public static Fragment newInstance(String param1, String param2) {
        FragmentOther fragment = new FragmentOther();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentOther() {
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
        View v= inflater.inflate(R.layout.fragment_fragment_other, container, false);
        marathi= (Button) v.findViewById(R.id.btn_marathi);
        hindi = (Button) v.findViewById(R.id.btn_hindi);
        urdu = (Button) v.findViewById(R.id.btn_urdu);
        novels = (Button) v.findViewById(R.id.btn_novels);
        motivation = (Button) v.findViewById(R.id.btn_motivation);
        romance= (Button) v.findViewById(R.id.btn_romance);
        shayari = (Button) v.findViewById(R.id.btn_shayari);
        story = (Button) v.findViewById(R.id.btn_story);
        oneText= (String) marathi.getText();
        twoText= (String) hindi.getText();
        threeText= (String)  urdu.getText();
        fourText= (String) novels.getText();
        fiveText= (String) motivation.getText();
         sixText= (String) romance.getText();
        sevenText= (String) shayari.getText();
        eightText= (String) story.getText();

        marathi.setOnClickListener(this);
        hindi.setOnClickListener(this);
        urdu.setOnClickListener(this);
        novels.setOnClickListener(this);
        romance.setOnClickListener(this);
        shayari.setOnClickListener(this);
        story.setOnClickListener(this);
        motivation.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_marathi:
                if (oneText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", oneText);
                    startActivity(i);
                }
                break;
            case R.id.btn_hindi:
                if (twoText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", twoText);
                    startActivity(i);
                }

                break;
            case R.id.btn_urdu:
                if (threeText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", threeText);
                    startActivity(i);
                }

                break;
            case R.id.btn_novels:
                if (fourText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", fourText);
                    startActivity(i);
                }

                break;
            case R.id.btn_motivation:
                if (fiveText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", fiveText);
                    startActivity(i);
                }

                break;
            case R.id.btn_romance:
                if (sixText != null) {
                    Intent i = new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v", sixText);
                    startActivity(i);
                }

                break;
            case R.id.btn_shayari:
                if(sevenText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",sevenText);
                    startActivity(i);
                }

                break;
            case R.id.btn_story:
                if(eightText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",eightText);
                    startActivity(i);
                }

                break;
        }
    }
}
