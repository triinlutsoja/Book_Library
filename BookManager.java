import java.util.ArrayList;

public class BookManager {

    public ArrayList<Book> books = new ArrayList<Book>();
    public int bookCount = 0;

    public BookManager(){
    }

    public void addBook(Book book){
        books.add(book);
        bookCount++;
    }

    public void removeBook(Book book){
        books.remove(book);
        bookCount--;
    }
}
