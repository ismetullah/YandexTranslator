package com.baktiyar.android.translator.ui;

import com.baktiyar.android.translator.models.Language;
import com.baktiyar.android.translator.models.WordFromResponse;
import com.baktiyar.android.translator.utils.Lifecycle;

/**
 * Created by Ismet on 1/26/2018.
 */

public interface MainContract {

    interface View {
        void onLanguagesSuccess(Language body);

        void onTranslateSuccess(WordFromResponse body);

        void onFailure(String message);
    }

    interface Presenter extends Lifecycle<View> {
        void loadLanguages();

        void translate(String lang, String text);
    }

}
