package com.costaoeste.learnenglish;

import android.content.Context;

import com.costaoeste.learnenglish.injection.components.ApplicationComponent;
import com.costaoeste.learnenglish.injection.components.DaggerApplicationComponent;
import com.costaoeste.learnenglish.injection.modules.ApplicationModule;

import io.realm.Realm;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by pablo on 25/4/17.
 */

public class LearnEnglishApplication extends android.app.Application {

    private static LearnEnglishApplication sInstance = null;

    private static ApplicationComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        sInstance = this;
        initDagger2();
        initCalligraphy();


    }

    private void initCalligraphy(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Akkurat-Normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    private void initDagger2(){
        sAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        sAppComponent.inject(this);
    }

    public static LearnEnglishApplication get(Context context) {
        return (LearnEnglishApplication) context.getApplicationContext();
    }

    public static ApplicationComponent getAppComponent() { return sAppComponent; }


    public static LearnEnglishApplication getInstance() { return sInstance; }


    public static Realm getRealm() { return sAppComponent.realm(); }

}
