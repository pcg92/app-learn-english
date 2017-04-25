package com.costaoeste.learnenglish.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.costaoeste.learnenglish.LearnEnglishApplication;
import com.costaoeste.learnenglish.injection.components.ActivityComponent;
import com.costaoeste.learnenglish.injection.components.DaggerActivityComponent;
import com.costaoeste.learnenglish.injection.modules.ActivityModule;

/**
 * Created by pablo on 25/4/17.
 */

public class BaseActivity extends AppCompatActivity{

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(LearnEnglishApplication.getAppComponent())
                    .build();
        }
        return mActivityComponent;
    }


}
