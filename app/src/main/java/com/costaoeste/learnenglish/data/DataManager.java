package com.costaoeste.learnenglish.data;

import android.util.Log;

import com.costaoeste.learnenglish.data.local.RealmVocabularyRepo;
import com.costaoeste.learnenglish.data.model.Vocabulary;

import java.util.List;

import javax.inject.Inject;

import io.realm.Sort;

/**
 * Created by pablo on 25/4/17.
 */

public class DataManager {

    private final RealmVocabularyRepo mVocabularyRepo;

    @Inject
    public DataManager(RealmVocabularyRepo vocabularyRepo){
        this.mVocabularyRepo=vocabularyRepo;
    }

    public void saveVocabulary(Vocabulary vocabulary){
        mVocabularyRepo.save(vocabulary);
    }

    public void getVocabulary(){
        List<Vocabulary> vocabularies = mVocabularyRepo.findAllSorted("word", Sort.ASCENDING,true);
    }
}
