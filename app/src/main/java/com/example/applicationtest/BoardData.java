package com.example.applicationtest;

public class BoardData {

    String uid;
    String title;
    String content;
    int bid;

    public BoardData(String uid, String title, String content, int bid) {
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.bid = bid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
