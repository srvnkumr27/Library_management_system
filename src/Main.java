import java.util.Scanner;
public class Main{
    public static void main(String[] args){
       
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

    while (true){
        System.out.println("\n====LIBRARY MENU====");
        System.out.println("1. Add Book");
        System.out.println("2. View Book");
        System.out.println("3. search Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Book ID:");
                int id = scanner.nextInt();
                System.out.print("Enter Title:");
                String title = scanner.nextLine();
                System.out.print("Enter Author:");
                String author = scanner.nextLine();
                library.addBook(new Book(id,title,author));
                break;
            case 2:
                library.displayBooks();
                break;
            case 3:
                System.out.print("Enter Book ID to search:");
                int searchId = scanner.nextInt();
                Book book = library.searchBook(searchId);
                if (book != null) {
                    System.out.println("Book Found: " + book);
                } else {
                    System.out.println("Book Not Found");
                }
                break;  

            case 4:
                System.out.print("Enter Book ID to issue:");
                int issueId = scanner.nextInt();
                library.issueBook(issueId);
                break;
            case 5:
                System.out.print("Enter Book ID to return:");
                int returnId = scanner.nextInt();
                library.returnBook(returnId);
                break;
            case 6:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
               
            default:
                System.out.println("Invalid Choice. Please try again.");
                break;

        }
    }
    }
}