package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Book;
import util.DBConnection;

public class BookDAO {


public void addBook(Book book) {

    String sql =
            "INSERT INTO books(id,title,author,issued) VALUES(?,?,?,?)";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, book.getId());
        ps.setString(2, book.getTitle());
        ps.setString(3, book.getAuthor());
        ps.setBoolean(4, book.isIssued());

        ps.executeUpdate();

        System.out.println("Book Added Successfully");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void displayBooks() {

    String sql = "SELECT * FROM books";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

           System.out.println(
    rs.getInt("id")
    + " | "
    + rs.getString("title")
    + " | "
    + rs.getString("author")
    + " | Issued: "
    + rs.getBoolean("issued")
    + " | User: "
    + rs.getString("issued_to")
);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void searchById(int id) {

    String sql = "SELECT * FROM books WHERE id = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println(
                    rs.getInt("id")
                    + " | "
                    + rs.getString("title")
                    + " | "
                    + rs.getString("author")
                    + " | Issued: "
                    + rs.getBoolean("issued")
            );

        } else {
            System.out.println("Book Not Found");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void deleteBook(int id) {

    String sql = "DELETE FROM books WHERE id = ?";

    try {

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Book Deleted Successfully");
        } else {
            System.out.println("Book Not Found");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void issueBook(int bookId, String userName) {

    String sql =
        "UPDATE books SET issued = ?, issued_to = ?, issue_date = CURDATE() WHERE id = ? AND issued = false";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setBoolean(1, true);
        ps.setString(2, userName);
        ps.setInt(3, bookId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Book Issued Successfully");
        } else {
            System.out.println("Book not found or already issued");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void returnBook(int bookId) {

    String sql =
        "UPDATE books SET issued = false, issued_to = NULL, issue_date = NULL WHERE id = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, bookId);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Book Returned Successfully");
        } else {
            System.out.println("Book Not Found");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void updateBook(int id,String newTitle,String newAuthor){
    String sql = " UPDATE books SET title=?,author = ?,WHERE id = ?";
    try {
      Connection con = DBConnection.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,newTitle);
      ps.setString(2,newAuthor);
      ps.setInt(3,id);
      int rows = ps.executeUpdate();
      if(rows > 0){
        System.out.println("Book Updated Successfully");
      } else{
        System.out.println("Book Not Found");
      }
    }catch(Exception e){
        e.printStackTrace();
    }
}


public static void main(String[] args) {

    BookDAO dao = new BookDAO();

    // Add books
    dao.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
    dao.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));

    // Display all books
    System.out.println("\n===== ALL BOOKS =====");
    dao.displayBooks();

    // Search book
    System.out.println("\n===== SEARCH BOOK ID 1 =====");
    dao.searchById(1);

    // Update book
    System.out.println("\n===== UPDATE BOOK ID 2 =====");
    dao.updateBook(
            2,
            "Advanced DBMS",
            "Navathe"
    );

    dao.displayBooks();

    // Issue book
    System.out.println("\n===== ISSUE BOOK ID 2 =====");
    dao.issueBook(
            2,
            "Sravan"
    );

    dao.displayBooks();

    // Return book
    System.out.println("\n===== RETURN BOOK ID 2 =====");
    dao.returnBook(2);

    dao.displayBooks();

    // Delete book
    System.out.println("\n===== DELETE BOOK ID 1 =====");
    dao.deleteBook(1);

    dao.displayBooks();
}

}
