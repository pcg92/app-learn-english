package com.costaoeste.learnenglish.ui.notebook;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.costaoeste.learnenglish.R;
import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NotebookAdapter extends RecyclerView.Adapter<NotebookAdapter.ViewHolder> {

    private final List<Vocabulary> mValues;
    private final NotebookFragment.OnNotebookListInteractionListener mListener;

    public NotebookAdapter(List<Vocabulary> items, NotebookFragment.OnNotebookListInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notebook, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).getWord());

        /*holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                mListener.onListFragmentInteraction(holder.mItem);
            }
        }); */
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void addNewItem(Vocabulary vocabulary){
        mValues.add(vocabulary);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public Vocabulary mItem;

        @BindView(R.id.text_item_notebook_word)
        TextView mContentView;

        @BindView(R.id.swipe_item_notebook)
        SwipeLayout mSwipeLayout;

        @BindView(R.id.layout_bottom_item_notebook)
        View mLayoutBottom;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
            mView = view;
            mSwipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        }

        @OnClick(R.id.layout_bottom_item_notebook)
        void onClickDelete(){
            Log.w("Pablo"," delete :"+mItem.getWord());
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
