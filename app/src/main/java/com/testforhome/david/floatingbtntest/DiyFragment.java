package com.testforhome.david.floatingbtntest;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Administrator on 2016/10/22 0022.
 */
public class DiyFragment extends DialogFragment{
    private String[] frequencyString = {"每周重复","每月重复","每年重复"};
    private Spinner frequencySpinner = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diydialoglayout,null);
        ArrayAdapter<String> frequencyAdapter = null;
        frequencyAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,frequencyString);
        frequencySpinner = (Spinner)rootView.findViewById(R.id.repeat_spinner);
        frequencyAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        frequencySpinner.setAdapter(frequencyAdapter);
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
