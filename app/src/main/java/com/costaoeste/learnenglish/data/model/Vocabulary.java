package com.costaoeste.learnenglish.data.model;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by pablo on 25/4/17.
 */

public class Vocabulary extends RealmObject implements Comparable<Vocabulary> {

    @PrimaryKey
    private String word;

    private String wordTranslated;

    public Vocabulary(){

    }

    public Vocabulary(String word, String wordTranslated) {
        this.word = word;
        this.wordTranslated = wordTranslated;
    }

    @Override
    public int compareTo(Vocabulary another) {
        if(word != null && another.word != null) {
            return word.compareTo(another.word);
        } else {
            return 0;
        }
    }
}
