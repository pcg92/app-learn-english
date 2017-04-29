package com.costaoeste.learnenglish.injection.components;

import com.costaoeste.learnenglish.injection.modules.FragmentModule;
import com.costaoeste.learnenglish.injection.scopes.PerFragment;
import com.costaoeste.learnenglish.ui.notebook.NotebookFragment;

import dagger.Component;

/**
 * Created by pablo on 29/4/17.
 */

@PerFragment
@Component(dependencies = ActivityComponent.class, modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(NotebookFragment notebookFragment);

}