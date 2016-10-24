package com.testforhome.david.repeatMenuFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.testforhome.david.floatingbtntest.R;


/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class DayRepeatFragment extends android.app.Fragment{
    private String[] repeatTypeString = {"无限重复","直到某个日期","重复一定次数"};
    private Spinner dayRepeatSpinner = null;
    private EditText dayRepeatEdittext = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dayrepeatlayout,container,false);
        dayRepeatSpinner = (Spinner)rootView.findViewById(R.id.dayRepeat_spinner);
        dayRepeatEdittext = (EditText)rootView.findViewById(R.id.dayRepeat_editText);
        ArrayAdapter<String> spinnerAdapter = null;

        spinnerAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,repeatTypeString);
        spinnerAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        dayRepeatSpinner.setAdapter(spinnerAdapter);
        dayRepeatEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayRepeatEdittext.setCursorVisible(true);
            }
        });
        return rootView;
    }
}
