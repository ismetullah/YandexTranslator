package com.baktiyar.android.translator.models;

/**
 * Created by admin on 17.01.2018.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WordFromResponse {
    @SerializedName("code")
    private Integer code;
    @SerializedName("lang")
    private String lang;
    @SerializedName("text")
    private List<String> text;

    public List<String> getText() {
        return text;
    }
}
