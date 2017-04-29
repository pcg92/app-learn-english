package com.costaoeste.learnenglish.data;

import android.util.Log;

import com.costaoeste.learnenglish.data.local.RealmVocabularyRepo;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.data.model.VocabularyRemote;
import com.costaoeste.learnenglish.data.remote.DictionaryService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Sort;

/**
 * Created by pablo on 25/4/17.
 */

public class DataManager {

    private final DictionaryService mDictionaryService;
    private final RealmVocabularyRepo mVocabularyRepo;

    @Inject
    public DataManager(DictionaryService dictionaryService,RealmVocabularyRepo vocabularyRepo){
        this.mDictionaryService = dictionaryService;
        this.mVocabularyRepo=vocabularyRepo;
    }

    public void saveVocabulary(Vocabulary vocabulary){
        mVocabularyRepo.save(vocabulary);
    }

    public List<Vocabulary> getVocabulary(){
        return mVocabularyRepo.findAllSorted("word", Sort.ASCENDING,true);
    }

    public Observable<VocabularyRemote> searchWord (String word) {
        return mDictionaryService.searchWord(word);
        //return null;
    }
}
