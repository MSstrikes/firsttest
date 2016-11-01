package com.testforhome.david.floatingbtntest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import io.apptik.widget.MultiSlider;

/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class ControlFragment extends DialogFragment{
    private TextView text1;
    private MultiSlider slider;
    private Timer timer;
    private int tag[] ={0,0}; //tag[0]代表timer钥匙，tag[1]代表timer是否取消
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.controllayout,null);
        slider = (MultiSlider)rootView.findViewById(R.id.range_slider);
        text1 = (TextView)rootView.findViewById(R.id.thumb1_text);
        slider.getThumb(0).setValue(0).setThumb(getResources().getDrawable(R.drawable.red_scrubber_control_selector_holo_light));
        slider.getThumb(1).setValue(0).setThumb(getResources().getDrawable(R.drawable.multislider_scrubber_control_selector_holo_light));
        timer = new Timer();
        slider.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int thumbIndex, int value) {
                if(thumbIndex == 1&& tag[1] == 0){
                    text1.setText(String.valueOf(slider.getThumb(1).getValue()));
                    if(tag[0] == 1){
                        timer = new Timer();
                        tag[0] = 0;
                    }
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //递增progress数值
                                    int a = slider.getThumb(1).getValue();
                                    int i = slider.getThumb(0).getValue();
                                    i++;
                                    if(i > a){
                                        timer.cancel();
                                        tag[0] = 1;
                                        tag[1] = 0;
                                        Toast.makeText(getActivity(),"Finish",Toast.LENGTH_SHORT).show();
                                    }else {
                                        tag[1] = 1;
                                        slider.getThumb(0).setValue(i);
                                    }
                                }
                            });
                        }
                    }, 500, 1000);
                }else if(thumbIndex == 0&&tag[1] == 0){
                    if(tag[0] == 1){
                        timer = new Timer();
                        tag[0] = 0;
                    }
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //递减progress数值
                                    int a = slider.getThumb(1).getValue();
                                    int i = slider.getThumb(0).getValue();
                                    a--;
                                    if(i > a){
                                        timer.cancel();
                                        tag[0] = 1;
                                        tag[1] = 0; //释放钥匙
                                        Toast.makeText(getActivity(),"Finish",Toast.LENGTH_SHORT).show();
                                    }else {
                                        tag[1] = 1; //持续获得钥匙
                                        slider.getThumb(1).setValue(a);
                                    }
                                }
                            });
                        }
                    }, 500, 1000);
                }

            }
        });
        return rootView;
    }
}
