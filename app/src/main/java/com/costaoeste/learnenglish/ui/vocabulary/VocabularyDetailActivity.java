package com.costaoeste.learnenglish.ui.vocabulary;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.costaoeste.learnenglish.R;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.util.Constants;

import org.parceler.Parcels;

import butterknife.ButterKnife;

public class VocabularyDetailActivity extends AppCompatActivity {

    public static Intent getCallingIntent(Context context, Parcelable vocabulary) {

        Intent intent = new Intent(context, VocabularyDetailActivity.class);
        intent.putExtra(Constants.BUNDLE_PARCELABLE,vocabulary);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_detail);
        ButterKnife.bind(this);

        Vocabulary vocabulary = Parcels.unwrap(getIntent().getParcelableExtra(Constants.BUNDLE_PARCELABLE));
    }
}
