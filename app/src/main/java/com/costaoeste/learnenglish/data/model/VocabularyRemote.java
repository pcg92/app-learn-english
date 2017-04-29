package com.costaoeste.learnenglish.data.model;

public class VocabularyRemote implements java.io.Serializable {
    private static final long serialVersionUID = 287250249018647495L;
    private int total;
    private int offset;
    private int limit;
    private int count;
    private VocabularyRemoteResults[] results;
    private String url;
    private int status;

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public VocabularyRemoteResults[] getResults() {
        return this.results;
    }

    public void setResults(VocabularyRemoteResults[] results) {
        this.results = results;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
