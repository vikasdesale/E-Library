package com.vikas.elibrary.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vikas.elibrary.R;

public class FragmentOneT extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;
    String oneText,twoText,threeText,fourText,fiveText,sixText,sevenText,eightText,nineText,tenText,elevenText,twelveText;
    public static FragmentOneT newInstance(String param1) {
        FragmentOneT fragment = new FragmentOneT();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
    //    args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_one_t, container, false);
        one = (Button) v.findViewById(R.id.btn_one);
        two = (Button) v.findViewById(R.id.btn_two);
        three = (Button) v.findViewById(R.id.btn_three);
        four = (Button) v.findViewById(R.id.btn_four);
        five = (Button) v.findViewById(R.id.btn_five);
        six = (Button) v.findViewById(R.id.btn_six);
        seven = (Button) v.findViewById(R.id.btn_seven);
        eight = (Button) v.findViewById(R.id.btn_eight);
        nine = (Button) v.findViewById(R.id.btn_nine);
        ten = (Button) v.findViewById(R.id.btn_ten);
        eleven = (Button) v.findViewById(R.id.btn_ele);
        twelve = (Button) v.findViewById(R.id.btn_twe);
       // oneText= (String) one.getText();
        oneText= (String) one.getText();
        twoText= (String) two.getText();
        threeText= (String)  three.getText();
        fourText= (String) four.getText();
        fiveText= (String) five.getText();
        sixText= (String) six.getText();
        sevenText= (String) seven.getText();
        eightText= (String) eight.getText();
        nineText= (String) nine.getText();
        tenText= (String) ten.getText();
        elevenText= (String) eleven.getText();
        twelveText= (String) twelve.getText();
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        ten.setOnClickListener(this);
        eleven.setOnClickListener(this);
        twelve.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                           if(oneText!=null){
                               Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                               i.putExtra("v",oneText);
                               startActivity(i);
                           }
                break;
            case R.id.btn_two:
                if(twoText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",twoText);
                    startActivity(i);
                }

                break;
            case R.id.btn_three:
                if(threeText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",threeText);
                    startActivity(i);
                }

                break;
            case R.id.btn_four:
                if(fourText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",fourText);
                    startActivity(i);
                }

                break;
            case R.id.btn_five:
                if(fiveText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",fiveText);
                    startActivity(i);
                }

                break;
            case R.id.btn_six:
                if(sixText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",sixText);
                    startActivity(i);
                }

                break;
            case R.id.btn_seven:
                if(sevenText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",sevenText);
                    startActivity(i);
                }

                break;
            case R.id.btn_eight:
                if(eightText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",eightText);
                    startActivity(i);
                }

                break;
            case R.id.btn_nine:
                if(nineText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",nineText);
                    startActivity(i);
                }

                break;
            case R.id.btn_ten:
                if(tenText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",tenText);
                    startActivity(i);
                }

                break;
            case R.id.btn_ele:
                if(elevenText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",elevenText);
                    startActivity(i);
                }

                break;
            case R.id.btn_twe:
                if(twelveText!=null){
                    Intent i=new Intent(getActivity(), com.vikas.elibrary.activity.Main2Activity.class);
                    i.putExtra("v",twelveText);
                    startActivity(i);
                }

                break;
        }
    }


}
