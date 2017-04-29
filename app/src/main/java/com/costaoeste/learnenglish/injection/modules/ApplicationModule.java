package com.costaoeste.learnenglish.injection.modules;

import android.app.Application;
import android.content.Context;

import com.costaoeste.learnenglish.BuildConfig;
import com.costaoeste.learnenglish.LearnEnglishApplication;
import com.costaoeste.learnenglish.data.remote.DictionaryService;
import com.costaoeste.learnenglish.injection.qualifiers.ApplicationContext;
import com.costaoeste.learnenglish.injection.scopes.PerApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class ApplicationModule {
  protected final LearnEnglishApplication mApplication;

  public ApplicationModule(LearnEnglishApplication application) {
    mApplication= application;
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

  @Provides
  @PerApplication
  static RealmConfiguration provideRealmConfiguration() {
    RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
    if(BuildConfig.DEBUG) { builder = builder.deleteRealmIfMigrationNeeded(); }
    return builder.build();
  }

  @Provides
  static Realm provideRealm(RealmConfiguration realmConfiguration) {
    return Realm.getInstance(realmConfiguration);
  }

  @Provides
  @PerApplication
  DictionaryService provideDictionaryService() {
    return DictionaryService.Factory.makeService();
  }

}