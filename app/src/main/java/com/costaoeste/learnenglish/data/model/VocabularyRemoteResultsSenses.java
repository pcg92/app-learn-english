package com.costaoeste.learnenglish.data.model;

public class VocabularyRemoteResultsSenses implements java.io.Serializable {
    private static final long serialVersionUID = 4369340322990726480L;
    private VocabularyRemoteResultsSensesGramatical_info gramatical_info;
    private String[] definition;

    public VocabularyRemoteResultsSensesGramatical_info getGramatical_info() {
        return this.gramatical_info;
    }

    public void setGramatical_info(VocabularyRemoteResultsSensesGramatical_info gramatical_info) {
        this.gramatical_info = gramatical_info;
    }

    public String[] getDefinition() {
        return this.definition;
    }

    public void setDefinition(String[] definition) {
        this.definition = definition;
    }
}
