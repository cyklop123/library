package com.library.models;

public class Book {
    protected String title;
    protected String author;
    protected int year;

    public Book() {
        title = "Example title";
        author = "Example Author";
        year = 1970;
    }

    public Book( String author, String title,int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + year;
    }
}
