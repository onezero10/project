package com.ce.nutchakhun.running;

/**
 * Created by Wuttipong on 25/1/2559.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class customAdapter extends BaseAdapter {
    Context mContext;
    List<String> strName;
    List<Integer> cal;

    public customAdapter(Context context, List<String> strName, List<Integer> cal) {
        this.mContext= context;
        this.strName = strName;
        this.cal = cal;
    }

    public int getCount() {
        return strName.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
            view = mInflater.inflate(R.layout.list_item, parent, false);

        TextView textView1 = (TextView)view.findViewById(R.id.textView1);
        textView1.setText(strName.get(position));

        TextView textView2 = (TextView)view.findViewById(R.id.textView2);
        textView2.setText(String.valueOf(cal.get(position))+" calories");

        return view;
    }
}