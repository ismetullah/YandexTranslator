package com.baktiyar.android.translator.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.baktiyar.android.translator.R;
import com.baktiyar.android.translator.models.Language;
import com.baktiyar.android.translator.models.WordFromResponse;
import com.baktiyar.android.translator.ui.adapters.AdapterLanguages;
import com.baktiyar.android.translator.ui.adapters.AdapterResponses;
import com.baktiyar.android.translator.utils.ApplicationClass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.baktiyar.android.translator.utils.Constants.makeSnack;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    @BindView(R.id.listViewWords)
    ListView mTranslatedWordsListView;
    @BindView(R.id.editTextTranslate)
    EditText mWordToTranslateEditText;
    @BindView(R.id.spinnerLanguages)
    Spinner mLanguagesSpinner;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initPresenter();
    }

    private void initPresenter() {
        ApplicationClass app = (ApplicationClass) getApplicationContext();
        presenter = new MainPresenter(app.getService(), this);
        presenter.bind(this);
        presenter.loadLanguages();
    }

    @OnClick(R.id.buttonTranslate)
    public void onClick(View v) {
        String wordToTranslate = mWordToTranslateEditText.getText().toString();
        String chosenLanguage = mLanguagesSpinner.getSelectedItem().toString();
        presenter.translate(chosenLanguage, wordToTranslate);
    }

    @Override
    public void onLanguagesSuccess(Language body) {
        AdapterLanguages adapter = new AdapterLanguages(this, body.getDirs());
        mLanguagesSpinner.setAdapter(adapter);
    }

    @Override
    public void onTranslateSuccess(WordFromResponse body) {
        AdapterResponses adapter = new AdapterResponses(this, body.getText());
        mTranslatedWordsListView.setAdapter(adapter);
    }

    @Override
    public void onFailure(String message) {
        makeSnack(this, message);
    }
}
