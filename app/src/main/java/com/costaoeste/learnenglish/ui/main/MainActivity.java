package com.costaoeste.learnenglish.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.costaoeste.learnenglish.R;
import com.costaoeste.learnenglish.ui.base.BaseActivity;
import com.costaoeste.learnenglish.ui.notebook.NotebookActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView{

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter.attachView(this);

        saveVocabulary();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }


    @Override
    public void saveVocabulary() {
        mMainPresenter.saveVocabulary();
    }

    @OnClick(R.id.card_notebook)
    void onClickCardNotebook(){
        startActivity(NotebookActivity.getCallingIntent(this));
    }
}
