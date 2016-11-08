package com.testforhome.david.floatingbtntest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Administrator on 2016/10/30 0030.
 */
public class ControlFragment extends DialogFragment{
    private TextView text1;
    private Timer timer = null;
    private int currentPlace;
    private int endPlace;
    private SeekBar controlSeekBar;
    private View rootView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.controllayout,null);
        text1 = (TextView)rootView.findViewById(R.id.test1);
        text1.setText(String.valueOf(0));
        initialSeekbar();
        timer = new Timer();
        controlSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text1.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                 currentPlace = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
                endPlace = seekBar.getProgress();
                if(timer == null){
                    timer = new Timer();
                }
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //递增progress数值
                                    if((seekBar.getSecondaryProgress() == endPlace) && (timer != null)){
                                        timer.cancel();
                                        timer = null;
                                    }
                                if(endPlace > currentPlace){
                                    seekBar.incrementSecondaryProgressBy(1);
                                }else if(endPlace < currentPlace){
                                    seekBar.incrementSecondaryProgressBy(-1);
                                }
                            }
                        });
                    }
                }, 1000, 40);
            }
        });
        return rootView;
    }
    private void initialSeekbar(){
        currentPlace = 0;
        controlSeekBar = (SeekBar)rootView.findViewById(R.id.control_seekbar);
        controlSeekBar.setProgress(currentPlace);
    }
}
