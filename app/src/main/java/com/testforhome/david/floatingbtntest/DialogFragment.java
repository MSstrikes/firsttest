package com.testforhome.david.floatingbtntest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.testforhome.david.selflistview.listviewItem;
import com.testforhome.david.selflistview.slidelistview;
import com.testforhome.david.switchbutton.CheckSwitchButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DialogFragment extends android.app.DialogFragment implements AdapterView.OnItemClickListener {
    public List<listviewItem> itemList = new ArrayList<listviewItem>();
    private String devName;
    private String desprition;
    private int[] colorBackground = {0,R.mipmap.a9,R.mipmap.blue,R.mipmap.f5,R.mipmap.fe,R.mipmap.ff};
    private int a;
    private HashMap<Integer,Boolean> stateCheckbox = new HashMap<Integer, Boolean>();
    private HashMap<Integer,Boolean> stateSwitchbtn = new HashMap<Integer, Boolean>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfullscreen_main,null);
        Button btn = (Button) rootView.findViewById(R.id.btn_close);
        for(int i=1;i<=20;i++){
            a= (int)(1+Math.random()*(5));
            devName = "第"+i+"个设备名称";
            desprition = "第"+i+"个设备介绍";
            listviewItem item = new listviewItem(devName,desprition,a);
            itemList.add(item);
        }

        listviewAdapter adapter_s = new listviewAdapter(this.getActivity(),R.layout.layout_list_item,itemList);
        slidelistview slidelistviews = (slidelistview)rootView.findViewById(R.id.listvie_list);
        slidelistviews.initSlideMode(slidelistview.MOD_FORBID);
        slidelistviews.setAdapter(adapter_s);
        slidelistviews.setOnItemClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView devtext = (TextView)view.findViewById(R.id.dev_name);
        String text = devtext.getText().toString();
        System.out.println(text);
        showText listenner = (showText)getActivity();
        listenner.showText(text);
    }

    public interface showText{
        abstract void showText(String text);
    }
    @Override
    public void dismiss() {
        System.out.println("Dialog Dismiss");
        super.dismiss();
    }
    private class listviewAdapter extends ArrayAdapter<listviewItem>{
        private int resourceId;

        public listviewAdapter(Context context, int textViewResourceId, List<listviewItem> objects) {
            super(context, textViewResourceId, objects);
            resourceId = textViewResourceId;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view;
            final listviewItem list = getItem(position);
            if(convertView == null){
                view = LayoutInflater.from(getContext()).inflate(
                        resourceId, null);

            }else{
                view = convertView;
            }
            TextView devname = (TextView)view.findViewById(R.id.dev_name);
            TextView descripion = (TextView)view.findViewById(R.id.descripions);
            TextView logo = (TextView) view.findViewById(R.id.logo);
            CheckBox checkbox = (CheckBox)view.findViewById(R.id.checkbox);
            CheckSwitchButton switchbutton = (CheckSwitchButton)view.findViewById(R.id.switchbtn);
            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        stateCheckbox.put(position,isChecked);
                        System.out.println(position+"复选框选中");
                    }else {
                        stateCheckbox.remove(position);
                    }
                }
            });
            switchbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        stateSwitchbtn.put(position,isChecked);
                        System.out.println(position+"按钮被选中");
                    }else {
                        stateSwitchbtn.remove(position);
                    }
                }
            });
            checkbox.setChecked(stateCheckbox.get(position)==null?false:true);
            switchbutton.setChecked(stateSwitchbtn.get(position)==null?false:true);
            logo.setText("B");
            logo.setBackgroundResource(colorBackground[list.getBackgroundColor()]);
            devname.setText(list.getDeviceName());
            descripion.setText(list.getDescripion());
            return view;
        }
    }
}
