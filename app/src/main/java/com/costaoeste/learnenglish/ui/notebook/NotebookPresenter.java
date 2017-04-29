package com.costaoeste.learnenglish.ui.notebook;

import com.costaoeste.learnenglish.data.DataManager;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.ui.base.Presenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pablo on 29/4/17.
 */

public class NotebookPresenter implements Presenter<NotebookMvpView> {

    private final DataManager mDataManager;
    private NotebookMvpView mMvpView;

    @Inject
    public NotebookPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(NotebookMvpView mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public void addWord(){

    }

    public void deleteWord(){

    }

    public void loadWords(){

        List<Vocabulary> list = mDataManager.getVocabulary();
        if(list.isEmpty()){
            mMvpView.showEmptyItems();
        }
    }
}
