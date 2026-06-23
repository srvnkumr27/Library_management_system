package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.temporal.ChronoUnit;
import model.Book;
import model.User;
import model.Transaction;
import exception.BookNotFoundException;
import exception.UserNotFoundException;
import util.DataManager;

public class Library{
    private HashMap<Integer, Book> books;
    private HashMap<Integer, User> users;
    private ArrayList<Transaction> transactions;
    
    public Library(){
        books = new HashMap<>();
        users = new HashMap<>();
        transactions = new ArrayList<>();
    }
    public void addUser(User user) {
    users.put(user.getUserId(), user);
    System.out.println("User Registered Successfully");
    }
    public void displayUsers() {

    for(User user : users.values()) {

        System.out.println(user);
    }
   }
    public void addBook(Book book){
        books.put(book.getId(),book);
        System.out.println("Book Added Successfully");
    }
    public void displayBooks(){
        for(Book book : books.values()){
            System.out.println(book);
        }
    }
    public Book searchBook(int id){
        return books.get(id);
    }
    public void issueBook(int bookId, int userId) throws BookNotFoundException, UserNotFoundException {

    Book book = books.get(bookId);

    User user = users.get(userId);

    if(book == null) {

        throw new BookNotFoundException("Book Not Found");
    }

    if(user == null) {

        throw new UserNotFoundException("User Not Found");
    }

    if(book.isIssued()) {
        
        System.out.println("Book Already Issued");
        return;
    }

    book.setIssued(true);

    book.setIssuedTo(user);

    book.setIssueDate(LocalDate.now());
    Transaction t = new Transaction(bookId, userId, LocalDate.now());
    transactions.add(t);

    System.out.println("Book Issued Successfully");
}
public void returnBook(int id) {

    Book book = books.get(id);
    
    if(book == null) {

        System.out.println("Book Not Found");
        return;
    }

    book.setIssued(false);

    book.setIssuedTo(null);

    book.setIssueDate(null);

   long daysBorrowed = ChronoUnit.DAYS.between(
    book.getIssuedDate(), LocalDate.now()
   );
   if(daysBorrowed > 14){
    long fine = (daysBorrowed - 14) * 10;
    System.out.println("Fine Amount: " + fine);
   }else{
    System.out.println("no fine");
   }

}
public void showTransaction(){
    for(Transaction t : transactions){
        System.out.println(t);
    }
}
public void saveData(){
    DataManager.save(books, "books.dat");
    DataManager.save(users, "users.dat");
    DataManager.save(transactions, "transactions.dat");
    System.out.println("Data Saved Successfully");
}
@SuppressWarnings("unchecked")
public void loadData(){
    Object loadedBooks = DataManager.load("books.dat");
    Object loadedUsers = DataManager.load("users.dat");
    Object loadedTransactions = DataManager.load("transactions.dat");
    if(loadedBooks != null){
        books = (HashMap<Integer, Book>) loadedBooks;
    }
    if(loadedUsers != null){
        users = (HashMap<Integer, User>) loadedUsers;
    }
    if(loadedTransactions != null){
        transactions = (ArrayList<Transaction>) loadedTransactions;
    }
}
}
