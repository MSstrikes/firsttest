package com.testforhome.david.floatingbtntest;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class RepeatFragment extends DialogFragment{
    private TextView notRepeat = null;
    private TextView everyday = null;
    private TextView everyweek = null;
    private TextView everymonth = null;
    private TextView everyyear = null;
    private TextView diy = null;
    private View getViews = null;
    private int year;
    private int month;
    private int day;
    private int dayOfWeek;
    private int hour;
    private int minute;
    RepeatFragment(View getViews,int year,int month,int day,int dayOfWeek,int hour,int minute){
        this.getViews = getViews;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.minute = minute;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final TextView repeatBtn = (TextView) getViews.findViewById(R.id.repeat_set_btn);

        View rootView = inflater.inflate(R.layout.repeatdialog,null);
        notRepeat = (TextView)rootView.findViewById(R.id.not_repeat);
        everyday = (TextView)rootView.findViewById(R.id.everyday);
        everyweek = (TextView)rootView.findViewById(R.id.everyweek);
        everymonth = (TextView)rootView.findViewById(R.id.everymonth);
        everyyear = (TextView)rootView.findViewById(R.id.everyyear);
        diy = (TextView)rootView.findViewById(R.id.diy);
        notRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatBtn.setText("不重复");
                dismiss();
            }
        });
        everyday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatBtn.setText("每天"+hour+"点"+minute+"分重复");
                dismiss();
            }
        });
        everyweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatBtn.setText("每周星期"+dayOfWeek+"重复");
                dismiss();
            }
        });
        everymonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatBtn.setText("每月"+day+"日重复");
                dismiss();
            }
        });
        everyyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatBtn.setText("每年"+month+"月"+day+"日重复");
                dismiss();
            }
        });
        diy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiyFragment diyfragment = new DiyFragment();
                diyfragment.show(getFragmentManager(),"DiyFragment");
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
