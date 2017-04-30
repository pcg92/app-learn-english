package com.costaoeste.learnenglish.ui.notebook;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.costaoeste.learnenglish.R;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotebookFragment extends BaseFragment implements NotebookMvpView {

    @BindView(R.id.recycler_list_notebook)
    RecyclerView mRecycler;

    @BindView(R.id.layout_list_notebook_empty)
    View mLayoutEmptyList;

    private OnNotebookListInteractionListener mListener;
    private NotebookAdapter mAdapter;

    @Inject
    NotebookPresenter mNotebookPresenter;

    public NotebookFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mNotebookPresenter.detachView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_notebook, container, false);
        ButterKnife.bind(this,view);
        mNotebookPresenter.attachView(this);

        Context context = view.getContext();
        mRecycler.setLayoutManager(new LinearLayoutManager(context));

        mNotebookPresenter.loadWords();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNotebookListInteractionListener) {
            mListener = (OnNotebookListInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNotebookListInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showEmptyItems(boolean isEmpty) {
        mRecycler.setVisibility(isEmpty?View.GONE:View.VISIBLE);
        mLayoutEmptyList.setVisibility(isEmpty?View.VISIBLE:View.GONE);
    }

    @Override
    public void loadSavedWords(List<Vocabulary> vocabularyList) {
        setAdapter(vocabularyList);
    }

    public void addNewWord(String word){

        Vocabulary newWord = new Vocabulary(word,"");
        if(mAdapter == null){
            List<Vocabulary> items = new ArrayList<>();
            items.add(newWord);
            setAdapter(items);
            showEmptyItems(mAdapter.getItemCount()==0);
        }
        else{
            mAdapter.addNewItem(newWord);
        }
        mNotebookPresenter.saveWord(newWord);
    }

    private void setAdapter(List<Vocabulary>items){
        mAdapter = new NotebookAdapter(items,mListener);
        mRecycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    public interface OnNotebookListInteractionListener {

        void onItemClicked(Vocabulary item);

        void onItemRemove(Vocabulary item);
    }
}
