package com.testforhome.david.floatingbtntest;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.testforhome.david.repeatMenuFragment.DayRepeatFragment;
import com.testforhome.david.repeatMenuFragment.MonthRepeatFragment;
import com.testforhome.david.repeatMenuFragment.WeekRepeatFragement;

/**
 * Created by Administrator on 2016/10/22 0022.
 */
public class DiyFragment extends DialogFragment{
    private String[] frequencyString = {"每天重复","每周重复","每月重复"};
    private Spinner frequencySpinner = null;
    private DayRepeatFragment dayRepeatFragment = null;
    private WeekRepeatFragement weekRepeatFragment = null;
    private MonthRepeatFragment monthRepeatFragment = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diydialoglayout,null);
        setDefalutFragment();
        ArrayAdapter<String> spinnerAdapter = null;
        spinnerAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,frequencyString);
        frequencySpinner = (Spinner)rootView.findViewById(R.id.repeat_spinner);
        spinnerAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        frequencySpinner.setAdapter(spinnerAdapter);



        frequencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fm = getChildFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                switch (position){
                    case 0: {
                        if(dayRepeatFragment == null){
                            dayRepeatFragment = new DayRepeatFragment();
                        }
                        transaction.replace(R.id.fragment_content,dayRepeatFragment);
                        transaction.commit();
                        break;
                    }
                    case 1: {
                        if(weekRepeatFragment == null){
                            weekRepeatFragment = new WeekRepeatFragement();
                        }
                        transaction.replace(R.id.fragment_content,weekRepeatFragment);
                        transaction.commit();
                        break;
                        }
                    case 2:{
                        Bundle bundle = getArguments();
                        if(monthRepeatFragment == null){
                            monthRepeatFragment = new MonthRepeatFragment();
                        }
                        monthRepeatFragment.setArguments(bundle);
                        transaction.replace(R.id.fragment_content,monthRepeatFragment);
                        transaction.commit();
                        break;
                    }
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.85), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setDefalutFragment(){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        dayRepeatFragment = new DayRepeatFragment();
        transaction.replace(R.id.fragment_content, dayRepeatFragment);
        transaction.commit();
    }
}
