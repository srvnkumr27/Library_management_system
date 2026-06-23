import dao.BookDAO;
import java.util.Scanner;
import model.Book;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Delete Book");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    dao.addBook(new Book(id, title, author));
                    break;

                case 2:
                    dao.displayBooks();
                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();

                    dao.searchById(searchId);
                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine();

                    dao.updateBook(updateId, newTitle, newAuthor);
                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    int issueId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String user = sc.nextLine();

                    dao.issueBook(issueId, user);
                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();

                    dao.returnBook(returnId);
                    break;

                case 7:

                    System.out.print("Enter Book ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteBook(deleteId);
                    break;

                case 8:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}