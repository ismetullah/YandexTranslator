package com.baktiyar.android.translator.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.baktiyar.android.translator.R;

import java.util.List;

/**
 * Created by Ismet on 1/26/2018.
 */

public class AdapterResponses extends ArrayAdapter<String> {

    private static final int padding = 20;
    private Context context;

    public AdapterResponses(Context context, List<String> list) {
        super(context, 0, list);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.cell_response, null);
        }

        TextView t = v.findViewById(R.id.textView);
        t.setText(getItem(position));

        return v;
    }
}
