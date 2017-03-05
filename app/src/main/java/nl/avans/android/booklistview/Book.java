package nl.avans.android.booklistview;

import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String author;
    private String shortDescription;
    private String longDescription;

    public Book(){}

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "" + title + " - " + author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
