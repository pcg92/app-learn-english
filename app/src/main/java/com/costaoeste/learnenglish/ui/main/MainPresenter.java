package com.costaoeste.learnenglish.ui.main;

import com.costaoeste.learnenglish.data.DataManager;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.ui.base.Presenter;

import org.reactivestreams.Subscription;

import javax.inject.Inject;


public class MainPresenter implements Presenter<MainMvpView> {

    private final DataManager mDataManager;
    private MainMvpView mMvpView;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    void saveVocabulary(){
        //mDataManager.saveVocabulary(new Vocabulary("Hola","Mundo"));
        //mDataManager.saveVocabulary(new Vocabulary("Hello","World"));

        mDataManager.getVocabulary();
    }
}

