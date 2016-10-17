package com.testforhome.david.selflistview;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class listviewItem {
    String deviceName;
    String descripion;
    int backgroundColor;
    public listviewItem(String deviceName,String descripion,int backgroundColor){
        this.deviceName = deviceName;
        this.descripion = descripion;
        this.backgroundColor = backgroundColor;
    }
    public String getDeviceName(){
        return deviceName;
    }
    public String getDescripion(){
        return descripion;
    }
    public int getBackgroundColor(){ return backgroundColor; }
}
