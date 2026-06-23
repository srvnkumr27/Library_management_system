package dao;

import model.Book;

public class BookTest {

    public static void main(String[] args) {

        BookDAO dao = new BookDAO();

        Book book = new Book(
                301,
                "Data Structures",
                "Mark Allen Weiss"
        );

        dao.addBook(book);

        System.out.println("\nBooks In Database:");

        dao.displayBooks();
    }
}