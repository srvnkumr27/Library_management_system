package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private int bookId;
    private int userId;
    private LocalDate transactionDate;

    public Transaction(int bookId, int userId, LocalDate transactionDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.transactionDate = transactionDate;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + " | User ID: " + userId + " | Date: " + transactionDate;
    }
}
