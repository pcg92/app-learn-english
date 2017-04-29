package com.costaoeste.learnenglish.injection.components;

import com.costaoeste.learnenglish.ui.main.MainActivity;
import com.costaoeste.learnenglish.injection.scopes.PerActivity;
import com.costaoeste.learnenglish.injection.modules.ActivityModule;
import com.costaoeste.learnenglish.ui.notebook.NotebookActivity;
import com.costaoeste.learnenglish.ui.notebook.NotebookFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent extends ApplicationComponent{

    void inject(MainActivity mainActivity);

    void inject(NotebookActivity notebookActivity);

}