package com.testforhome.david.floatingbtntest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.testforhome.david.selflistview.listviewItem;
import com.testforhome.david.selflistview.slidelistview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class DialogFragment extends android.app.DialogFragment implements AdapterView.OnItemClickListener {
    public List<listviewItem> itemList = new ArrayList<listviewItem>();
    private String devName;
    private String desprition;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfullscreen_main,null);
        Button btn = (Button) rootView.findViewById(R.id.btn_close);
        for(int i=1;i<=20;i++){
            devName = "第"+i+"个设备名称";
            desprition = "第"+i+"个设备介绍";
            listviewItem item = new listviewItem(devName,desprition);
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
        public View getView(int position, View convertView, ViewGroup parent) {
            listviewItem list = getItem(position);
            View view;
            if(convertView == null){
                view = LayoutInflater.from(getContext()).inflate(
                        resourceId, null);
            }else{
                view = convertView;
            }
            TextView dev_name = (TextView)view.findViewById(R.id.dev_name);
            TextView descripion = (TextView)view.findViewById(R.id.descripions);
            dev_name.setText(list.getDeviceName());
            descripion.setText(list.getDescripion());
            return view;
        }
    }
}
