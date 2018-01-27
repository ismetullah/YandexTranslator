package com.baktiyar.android.translator.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ismet on 1/26/2018.
 */

public class AdapterLanguages extends ArrayAdapter<String> {

    private static final int padding = 20;

    public AdapterLanguages(Context context, List<String> list) {
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(getContext());

        label.setTextColor(Color.BLACK);
        label.setText(getItem(position));
        label.setTextSize(18.f);

        return label;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(getContext());
        label.setTextColor(Color.BLACK);
        label.setPadding(padding, padding, padding, padding);
        label.setTextSize(18.f);
        label.setScrollBarSize(25);
        label.setText(getItem(position));

        return label;
    }

}
