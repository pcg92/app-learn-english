package com.costaoeste.learnenglish.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.costaoeste.learnenglish.injection.qualifiers.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }

}