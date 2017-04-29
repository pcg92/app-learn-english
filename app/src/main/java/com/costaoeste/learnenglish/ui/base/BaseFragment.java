package com.costaoeste.learnenglish.ui.base;


import android.support.v4.app.Fragment;

import com.costaoeste.learnenglish.injection.components.DaggerFragmentComponent;
import com.costaoeste.learnenglish.injection.components.FragmentComponent;
import com.costaoeste.learnenglish.injection.modules.FragmentModule;

/**
 * Created by pablo on 29/4/17.
 */

public class BaseFragment extends Fragment {

    private FragmentComponent mFragmentComponent;

    protected final FragmentComponent fragmentComponent() {
        if(mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent.builder()
                    .fragmentModule(new FragmentModule(this))
                    .activityComponent(((BaseActivity) getActivity()).activityComponent())
                    .build();
        }

        return mFragmentComponent;
    }
}
