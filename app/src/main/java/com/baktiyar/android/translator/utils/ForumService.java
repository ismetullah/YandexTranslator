package com.baktiyar.android.translator.utils;


import com.baktiyar.android.translator.models.Language;
import com.baktiyar.android.translator.models.WordFromResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by admin on 17.01.2018.
 */

public interface ForumService {

    @GET("tr.json/translate?")
        Call<WordFromResponse> getTranslation(  @Query("key")    String apiKey,
                                                @Query("lang")   String lang,
                                                @Query("text")   String text
        );

    @GET("tr.json/getLangs?")
    Call<Language> getLanguages(@Query("key")  String apiKey,
                                @Query("ui")   String ui
    );


}
