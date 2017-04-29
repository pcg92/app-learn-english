package com.costaoeste.learnenglish.ui.vocabulary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.costaoeste.learnenglish.R;

import butterknife.ButterKnife;

public class VocabularyDetailActivity extends AppCompatActivity {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, VocabularyDetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_detail);
        ButterKnife.bind(this);
    }
}
