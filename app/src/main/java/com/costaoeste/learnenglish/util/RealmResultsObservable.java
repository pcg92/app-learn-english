package com.costaoeste.learnenglish.util;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmResultsObservable<T extends RealmObject> implements ObservableOnSubscribe<RealmResults<T>> {

    public static <T extends RealmObject> Observable<RealmResults<T>> from(RealmResults<T> realmResults) {
        return Observable.create(new RealmResultsObservable<>(realmResults));
    }

    private final RealmResults<T> realmResults;

    private RealmResultsObservable(RealmResults<T> realmResults) {
        this.realmResults = realmResults;
    }

    @Override
    public void subscribe(ObservableEmitter<RealmResults<T>> emitter) throws Exception {
        RealmChangeListener<RealmResults<T>> changeListener = emitter::onNext;
        realmResults.addChangeListener(changeListener);
        emitter.setCancellable(() -> realmResults.removeChangeListener(changeListener));
    }
}