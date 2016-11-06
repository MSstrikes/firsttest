package com.testforhome.david.floatingbtntest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class TimerFragment extends android.app.DialogFragment{
    private TextView showDate = null;
    private TextView showTime = null;
    private TextView repeatButton = null;

    private int year;
    private int day;
    private int month;
    private int hour;
    private int minute;
    private int dayOfWeek;
    private boolean dateSetted = false;
    private boolean timeSetted = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Light_NoTitleBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.timerdialog,null);
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        showDate = (TextView)rootView.findViewById(R.id.show_datepicker);
        showTime = (TextView)rootView.findViewById(R.id.show_timepicker);
        repeatButton = (TextView) rootView.findViewById(R.id.repeat_set_btn);
        showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dateDialog = new DatePickerDialog(getActivity(),Datelistener,year,month,day);
                dateDialog.show();
            }
        });
        showTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timeDialog = new TimePickerDialog(getActivity(),Timelisterner,hour,minute,true);
                timeDialog.show();
            }
        });
        repeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timeSetted && dateSetted){
                    RepeatFragment fragment = new RepeatFragment(rootView,year,month,day,dayOfWeek,hour,minute);
                    fragment.show(getFragmentManager(),"RepeatFragment");
                }else {
                    Toast.makeText(getActivity(),"Please set Time and Date first",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return rootView;

    }

    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int gyear, int gmonth, int gdayOfMonth) {
            year = gyear;
            month = gmonth;
            day = gdayOfMonth;
            updateDate();
        }
        private void updateDate(){
            showDate.setTextColor(Color.parseColor("#000000"));
            month++;
            showDate.setText(year+"年"+month+"月"+day+"日");
            Calendar calendar_set = Calendar.getInstance(Locale.CHINA);
            calendar_set.set(year,month,day);
            dayOfWeek = calendar_set.get(Calendar.DAY_OF_WEEK)-1;
            if(dateSetted == true) {
                repeatButton.setText("请重新设置");
            }
            dateSetted = true;
        }
    };
    private TimePickerDialog.OnTimeSetListener Timelisterner = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int gminute) {
            hour = hourOfDay;
            minute = gminute;
            updateTime();
        }
        private void updateTime(){
            showTime.setTextColor(Color.parseColor("#000000"));
            showTime.setText(hour+"点"+minute+"分");
            timeSetted = true;
        }
    };
}
