package com.costaoeste.learnenglish.data.local;

import android.support.annotation.Nullable;

import com.costaoeste.learnenglish.data.model.Vocabulary;

import java.util.List;

import io.reactivex.Observable;
import io.realm.Sort;

/**
 * Created by pablo on 25/4/17.
 */

public interface VocabularyRepo {

    List<Vocabulary> findAllSorted(String sortField, Sort sort, boolean detached);
    Observable<List<Vocabulary>> findAllSortedWithChanges(String sortField, Sort sort);

    @Nullable
    Vocabulary getByField(String field, String value, boolean detached);

    void save(Vocabulary vocabulary);
    void delete(Vocabulary vocabulary);

    Vocabulary detach(Vocabulary country);

}
