package com.costaoeste.learnenglish.ui.main;

import android.util.Log;

import com.costaoeste.learnenglish.data.DataManager;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.data.model.VocabularyRemote;
import com.costaoeste.learnenglish.ui.base.Presenter;

import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


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

        //mDataManager.getVocabulary();


        mDataManager.searchWord("mouse")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<VocabularyRemote>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull VocabularyRemote vocabularyRemote) {
                        Log.w("Pablo"," suscription success");
                        Log.w("Pablo"," vocabulary terms:"+vocabularyRemote.getCount());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.w("Pablo"," suscription error"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.w("Pablo"," suscription complete");
                    }
                });

    }
}

