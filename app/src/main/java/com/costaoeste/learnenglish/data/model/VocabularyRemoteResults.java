package com.costaoeste.learnenglish.data.model;

public class VocabularyRemoteResults implements java.io.Serializable {
    private static final long serialVersionUID = 2173412913171603829L;
    private String headword;
    private VocabularyRemoteResultsSenses[] senses;
    private int homnum;
    private String part_of_speech;
    private String[] datasets;
    private String id;
    private String url;

    public String getHeadword() {
        return this.headword;
    }

    public void setHeadword(String headword) {
        this.headword = headword;
    }

    public VocabularyRemoteResultsSenses[] getSenses() {
        return this.senses;
    }

    public void setSenses(VocabularyRemoteResultsSenses[] senses) {
        this.senses = senses;
    }

    public int getHomnum() {
        return this.homnum;
    }

    public void setHomnum(int homnum) {
        this.homnum = homnum;
    }

    public String getPart_of_speech() {
        return this.part_of_speech;
    }

    public void setPart_of_speech(String part_of_speech) {
        this.part_of_speech = part_of_speech;
    }

    public String[] getDatasets() {
        return this.datasets;
    }

    public void setDatasets(String[] datasets) {
        this.datasets = datasets;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
