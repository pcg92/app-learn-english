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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotebookFragment extends BaseFragment implements NotebookMvpView {

    @BindView(R.id.recycler_list_notebook)
    RecyclerView mRecycler;

    @BindView(R.id.layout_list_notebook_empty)
    View mLayoutEmptyList;

    private OnListFragmentInteractionListener mListener;

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
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showEmptyItems() {
        mRecycler.setVisibility(View.GONE);
        mLayoutEmptyList.setVisibility(View.VISIBLE);
    }


    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Vocabulary item);
    }
}
