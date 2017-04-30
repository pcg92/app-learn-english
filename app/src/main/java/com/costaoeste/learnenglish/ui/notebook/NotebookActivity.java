package com.costaoeste.learnenglish.ui.notebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.costaoeste.learnenglish.R;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.ui.base.BaseActivity;
import com.costaoeste.learnenglish.ui.dialog.CardDialog;
import com.costaoeste.learnenglish.ui.vocabulary.VocabularyDetailActivity;

import org.parceler.Parcels;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotebookActivity extends BaseActivity implements NotebookFragment.OnNotebookListInteractionListener {

    NotebookFragment mNotebookFragment;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, NotebookActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_notebook);
        ButterKnife.bind(this);

        mNotebookFragment = (NotebookFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_list_notebook);

    }

    @OnClick(R.id.button_notebook_add)
    void onClickAddWord(){
        CardDialog dialog = new CardDialog.Builder(this)
                .setOkListener(newWord -> {
                    notifyNewWordToFragment(newWord);
                })
                .build();
        dialog.show();
    }

    private void notifyNewWordToFragment(String word){
        mNotebookFragment.addNewWord(word);
    }

    @Override
    public void onItemClicked(Vocabulary item) {
        startActivity(VocabularyDetailActivity.getCallingIntent(this, Parcels.wrap(item)));
    }

    @Override
    public void onItemRemove(Vocabulary item) {

    }
}
