package com.baktiyar.android.translator.ui;

import android.content.Context;

import com.baktiyar.android.translator.R;
import com.baktiyar.android.translator.models.Language;
import com.baktiyar.android.translator.models.WordFromResponse;
import com.baktiyar.android.translator.utils.ForumService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.baktiyar.android.translator.utils.Constants.KEY_API;
import static com.baktiyar.android.translator.utils.Constants.isNetworkAvailable;

/**
 * Created by Ismet on 1/26/2018.
 */

public class MainPresenter implements MainContract.Presenter {

    private Context mContext;
    private MainContract.View view;
    private ForumService service;

    public MainPresenter(ForumService service, Context mContext) {
        this.mContext = mContext;
        this.service = service;
    }

    @Override
    public void bind(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void loadLanguages() {
        if (isNetworkAvailable(mContext)) {
            service.getLanguages(KEY_API, "ru").enqueue(new Callback<Language>() {
                @Override
                public void onResponse(Call<Language> call, Response<Language> response) {
                    if (isViewAttached())
                        if (response.isSuccessful()) {
                            view.onLanguagesSuccess(response.body());
                        } else {
                            view.onFailure(mContext.getString(R.string.fail_language));
                        }
                }

                @Override
                public void onFailure(Call<Language> call, Throwable t) {
                    t.printStackTrace();
                    if (isViewAttached())
                        view.onFailure(mContext.getString(R.string.fail_language));
                }
            });
        } else {
            view.onFailure(mContext.getString(R.string.fail_network));
        }
    }

    @Override
    public void translate(String lang, String text) {
        if (isNetworkAvailable(mContext)) {
            service.getTranslation(KEY_API, lang, text).enqueue(new Callback<WordFromResponse>() {
                @Override
                public void onResponse(Call<WordFromResponse> call, Response<WordFromResponse> response) {
                    if (isViewAttached())
                        if (response.isSuccessful()) {
                            view.onTranslateSuccess(response.body());
                        } else {
                            view.onFailure(mContext.getString(R.string.fail_translate));
                        }
                }

                @Override
                public void onFailure(Call<WordFromResponse> call, Throwable t) {
                    t.printStackTrace();
                    if (isViewAttached())
                        view.onFailure(mContext.getString(R.string.fail_translate));
                }
            });
        } else {
            view.onFailure(mContext.getString(R.string.fail_network));
        }
    }
}
