package com.costaoeste.learnenglish.ui.notebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.costaoeste.learnenglish.R;
import com.costaoeste.learnenglish.ui.notebook.dummy.DummyContent;
import com.costaoeste.learnenglish.ui.vocabulary.VocabularyDetailActivity;

public class NotebookActivity extends AppCompatActivity implements NotebookFragment.OnListFragmentInteractionListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, NotebookActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        startActivity(VocabularyDetailActivity.getCallingIntent(this));
    }
}
