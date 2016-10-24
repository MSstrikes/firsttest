package com.testforhome.david.repeatMenuFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.testforhome.david.floatingbtntest.R;

/**
 * Created by Administrator on 2016/10/24 0024.
 */
public class MonthRepeatFragment extends Fragment{
    private String[] repeatTypeString = {"无限重复","直到某个日期","重复一定次数"};
    private Spinner monthRepeatSpinner = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.monthrepeatlayout,container,false);
        intial(rootView);
        ArrayAdapter<String> spinnerAdapter = null;
        spinnerAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,repeatTypeString);
        spinnerAdapter.setDropDownViewResource(R.layout.spinnerlayout);
        monthRepeatSpinner.setAdapter(spinnerAdapter);

        return rootView;
    }
    private void intial(View rootview){
        monthRepeatSpinner = (Spinner)rootview.findViewById(R.id.monthRepeat_spinner);
    }
}
