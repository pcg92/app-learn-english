package com.costaoeste.learnenglish.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.costaoeste.learnenglish.injection.qualifiers.ActivityContext;
import com.costaoeste.learnenglish.injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }

}