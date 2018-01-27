package com.baktiyar.android.translator.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by admin on 18.01.2018.
 */

public class Language {
    @SerializedName("dirs")
    private List<String> dirs;

    public List<String> getDirs() {
        return dirs;
    }
}