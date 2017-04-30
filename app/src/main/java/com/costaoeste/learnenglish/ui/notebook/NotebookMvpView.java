package com.costaoeste.learnenglish.ui.notebook;

import com.costaoeste.learnenglish.data.model.Vocabulary;
import com.costaoeste.learnenglish.ui.base.MvpView;

import java.util.List;

/**
 * Created by pablo on 29/4/17.
 */

public interface NotebookMvpView extends MvpView {

   void showEmptyItems(boolean isEmpty);

   void loadSavedWords(List<Vocabulary> vocabularyList);

}
