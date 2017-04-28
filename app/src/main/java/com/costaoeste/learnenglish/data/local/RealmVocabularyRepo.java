package com.costaoeste.learnenglish.data.local;

import android.support.annotation.Nullable;

import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.util.RealmResultsObservable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by pablo on 25/4/17.
 */

public class RealmVocabularyRepo implements VocabularyRepo {

    private final Provider<Realm> realmProvider;


    @Inject
    public RealmVocabularyRepo(Provider<Realm> realmProvider) {
        this.realmProvider = realmProvider;
    }

    @Override
    public List<Vocabulary> findAllSorted(String sortField, Sort sort, boolean detached) {
        Realm realm = realmProvider.get();
        RealmResults<Vocabulary> realmResults = realm.where(Vocabulary.class).findAllSorted(sortField, sort);

        if(detached) {
            return realm.copyFromRealm(realmResults);
        } else {
            return realmResults;
        }

    }

    @Override
    public Observable<List<Vocabulary>> findAllSortedWithChanges(String sortField, Sort sort) {
        Realm realm = realmProvider.get();
            return RealmResultsObservable.from(realm.where(Vocabulary.class).findAllSortedAsync(sortField, sort))
                    .filter(RealmResults::isLoaded)
                    .map(result -> result);
    }

    @Nullable
    @Override
    public Vocabulary getByField(String field, String value, boolean detached) {
        Realm realm = realmProvider.get();
        Vocabulary realmVocabulary = realm.where(Vocabulary.class).equalTo(field, value).findFirst();
        if(detached && realmVocabulary != null) { realmVocabulary = realm.copyFromRealm(realmVocabulary); }
        return realmVocabulary;
    }

    @Override
    public void save(Vocabulary vocabulary) {
        Realm realm = realmProvider.get();
        realm.executeTransaction(r -> r.copyToRealmOrUpdate(vocabulary));
    }

    @Override
    public void delete(Vocabulary vocabulary) {
        if (vocabulary.isValid()) {
            Realm realm = realmProvider.get();
            realm.executeTransaction(r -> {
                vocabulary.deleteFromRealm();
            });
        }
    }

    @Override
    public Vocabulary detach(Vocabulary vocabulary) {
        if(vocabulary.isManaged()) {
            Realm realm = realmProvider.get();
                return realm.copyFromRealm(vocabulary);
        } else {
            return vocabulary;
        }
    }

}
