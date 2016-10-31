package com.testforhome.david.floatingbtntest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import io.apptik.widget.MultiSlider;

/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class ControlFragment extends DialogFragment{
    private TextView text1;
    private MultiSlider slider;
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
        text1.setText(String.valueOf(slider.getThumb(0).getValue()));
        slider.getThumb(0).setThumb(getResources().getDrawable(R.drawable.thumbs));
        slider.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int thumbIndex, int value) {
                if(thumbIndex == 0){
                    text1.setText(String.valueOf(slider.getThumb(0).getValue()));
                }
            }
        });
        return rootView;
    }
}
