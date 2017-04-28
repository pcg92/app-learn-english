package com.costaoeste.learnenglish.injection.modules;

import com.costaoeste.learnenglish.data.local.RealmVocabularyRepo;
import com.costaoeste.learnenglish.data.local.VocabularyRepo;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

    @Binds
    abstract VocabularyRepo bindCountryRepo(RealmVocabularyRepo realmCountryRepo);

}
