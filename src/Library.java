import java.util.HashMap;

public class Library{
    private HashMap<Integer, Book> books;

    public Library(){
        books = new HashMap<>();
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
        public void deleteBook(int id){
            if(books.containsKey(id)){
                books.remove(id);
                System.out.println("Book Deleted");
            }else{
                System.out.println("Book Not Found");
            }
        }
}