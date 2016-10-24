package com.testforhome.david.repeatMenuFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.testforhome.david.floatingbtntest.R;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class WeekRepeatFragement extends android.app.Fragment{
    private String[] repeatTypeString = {"无限重复","直到某个日期","重复一定次数"};
    private Spinner weekRepeatSpinner = null;
    private EditText weekRepeatEdittext = null;
    private int[] tag = new int[8];
    private Button monBtn = null;
    private Button tueBtn = null;
    private Button wedBtn = null;
    private Button thuBtn = null;
    private Button friBtn = null;
    private Button satBtn = null;
    private Button sunBtn = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weekrepeatlayout,container,false);
        initialWidget(rootView);
        ArrayAdapter<String> spinnerAdapter = null;
        spinnerAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,repeatTypeString);
        spinnerAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        weekRepeatEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weekRepeatEdittext.setCursorVisible(true);
            }
        });
        weekRepeatSpinner.setAdapter(spinnerAdapter);

        return rootView;
    }

    private void initialWidget(View rootView){
        weekRepeatSpinner = (Spinner)rootView.findViewById(R.id.weekRepeat_spinner);
        weekRepeatEdittext = (EditText)rootView.findViewById(R.id.weekRepeat_editText);
        monBtn = (Button)rootView.findViewById(R.id.week_mon);
        tueBtn = (Button)rootView.findViewById(R.id.week_tue);
        wedBtn = (Button)rootView.findViewById(R.id.week_wed);
        thuBtn = (Button)rootView.findViewById(R.id.week_thu);
        friBtn = (Button)rootView.findViewById(R.id.week_fri);
        satBtn = (Button)rootView.findViewById(R.id.week_sat);
        sunBtn = (Button)rootView.findViewById(R.id.week_sun);
        monBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag[1] == 0){
                    monBtn.setBackgroundResource(R.mipmap.roundselected);
                    tag[1] = 1;
                }else {
                    monBtn.setBackgroundResource(R.mipmap.round);
                    tag[1] = 0;
                }
            }
        });
        tueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag[2] == 0){
                    tueBtn.setBackgroundResource(R.mipmap.roundselected);
                    tag[2] = 1;
                }else {
                    tueBtn.setBackgroundResource(R.mipmap.round);
                    tag[2] = 0;
                }
            }
        });
        wedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag[3] == 0){
                    wedBtn.setBackgroundResource(R.mipmap.roundselected);
                    tag[3] = 1;
                }else {
                    wedBtn.setBackgroundResource(R.mipmap.round);
                    tag[3] = 0;
                }
            }
        });
        thuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag[4] == 0){
                    thuBtn.setBackgroundResource(R.mipmap.roundselected);
                    tag[4] = 1;
                }else {
                    thuBtn.setBackgroundResource(R.mipmap.round);
                    tag[4] = 0;
                }
            }
        });
        friBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag[5] == 0){
                    friBtn.setBackgroundResource(R.mipmap.roundselected);
                    tag[5] = 1;
                }else {
                    friBtn.setBackgroundResource(R.mipmap.round);
                    tag[5] = 0;
                }
            }
        });
        satBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag[6] == 0){
                    satBtn.setBackgroundResource(R.mipmap.roundselected);
                    tag[6] = 1;
                }else {
                    satBtn.setBackgroundResource(R.mipmap.round);
                    tag[6] = 0;
                }
            }
        });
        sunBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag[7] == 0){
                    sunBtn.setBackgroundResource(R.mipmap.roundselected);
                    tag[7] = 1;
                }else {
                    sunBtn.setBackgroundResource(R.mipmap.round);
                    tag[7] = 0;
                }
            }
        });
    }

}
