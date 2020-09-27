package com.example.myapplication.recycler_view;

public class CardItem {
    int poster;
    String title;

    public int getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public CardItem(int poster, String title) {
        this.poster = poster;
        this.title = title;
    }
}
