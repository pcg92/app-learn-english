package com.costaoeste.learnenglish.injection.components;

import com.costaoeste.learnenglish.ui.main.MainActivity;
import com.costaoeste.learnenglish.injection.scopes.PerActivity;
import com.costaoeste.learnenglish.injection.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

}