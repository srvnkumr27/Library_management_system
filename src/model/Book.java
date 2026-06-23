package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable, Comparable<Book> {
    private int id;
    private String title;
    private String author;
    private boolean issued;
    private User issuedTo;
    private LocalDate issueDate;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | Issued: " + issued;
    }

    public User getIssueTo() {
        return issuedTo;
    }

    public void setIssuedTo(User issuedTo) {
        this.issuedTo = issuedTo;
    }

    public LocalDate getIssuedDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public int compareTo(Book other) {
        return this.id - other.id;
    }
}