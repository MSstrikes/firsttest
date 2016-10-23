package com.testforhome.david.floatingbtntest;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by Administrator on 2016/10/22 0022.
 */
public class DiyFragment extends DialogFragment{
    private String[] frequencyString = {"每天重复","每周重复","每月重复","每年重复"};
    private String[] repeatTypeString = {"无限重复","直到某个日期","重复一定次数"};
    private Spinner frequencySpinner = null;
    private Spinner dayRepeatSpinner = null;
    private Spinner weekSpinner = null;
    private EditText dayRepeatEdittext = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diydialoglayout,null);
        final LinearLayout dayRepeatLayout = (LinearLayout)rootView.findViewById(R.id.dayRepeat_fragment);
        final LinearLayout weekRepeatLayout = (LinearLayout)rootView.findViewById(R.id.weekRepeat_fragment);
        ArrayAdapter<String> spinnerAdapter = null;
        spinnerAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,frequencyString);
        frequencySpinner = (Spinner)rootView.findViewById(R.id.repeat_spinner);
        spinnerAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        frequencySpinner.setAdapter(spinnerAdapter);

        spinnerAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,repeatTypeString);
        dayRepeatSpinner = (Spinner)rootView.findViewById(R.id.dayRepeat_spinner);
        spinnerAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        dayRepeatSpinner.setAdapter(spinnerAdapter);
        weekSpinner = (Spinner)rootView.findViewById(R.id.weekRepeat_spinner);
        weekSpinner.setAdapter(spinnerAdapter);
        dayRepeatEdittext = (EditText)rootView.findViewById(R.id.dayRepeat_editText);
        dayRepeatEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayRepeatEdittext.setCursorVisible(true);
            }
        });
        frequencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        dayRepeatLayout.setVisibility(View.VISIBLE);
                        weekRepeatLayout.setVisibility(View.GONE);
                        break;
                    }
                    case 1: {
                        dayRepeatLayout.setVisibility(View.GONE);
                        weekRepeatLayout.setVisibility(View.VISIBLE);
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
}
