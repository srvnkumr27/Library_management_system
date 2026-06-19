import java.util.ArrayList;

public class Library{
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book Added Successfully");
    }
    public void displayBooks(){
        for(Book book : books){
            System.out.println(book);
        }
    }
    public Book searchBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }
    public void issueBook(int id){
        Book book = searchBook(id);
        if(book != null && !book.isIssued()){
            book.setIssued(true);
            System.out.println(true);
            System.out.println("Book Issued Successfully");
        }else{
            System.out.println("Book Not Avaliable");
        }
        }
        public void returnBook(int id){
            Book book = searchBook(id);
            if(book != null && book.isIssued()){
                book.setIssued(false);
                System.out.println("Book Returned Successfully");
            }else{
                System.out.println("Book Not Issued");
            }
        }
}