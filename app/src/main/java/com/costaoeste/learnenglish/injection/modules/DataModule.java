package com.costaoeste.learnenglish.injection.modules;

import com.costaoeste.learnenglish.data.local.RealmVocabularyRepo;
import com.costaoeste.learnenglish.data.local.VocabularyRepo;
import com.costaoeste.learnenglish.data.remote.DictionaryService;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class DataModule {

    @Binds
    abstract VocabularyRepo bindCountryRepo(RealmVocabularyRepo realmCountryRepo);


}
