import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        System.out.println("Welcome to the book management system!");
        System.out.println("    Press 1 to add a book.");
        System.out.println("    Press 2 to remove a book.");
        System.out.println("    Press 3 to see a list of all the books.");
        System.out.println("    Press 4 to add a exit.");

        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        boolean exit = false;

        while (!exit){
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            String title;
            String author;
            Book book;
            System.out.println();

            if (choice.equals("1")){
                System.out.println("You chose to add a book.");
                title = askBookTitle();
                author = askBookAuthor();
                book = new Book();
                book.setTitle(title);
                book.setAuthor(author);
                System.out.println("You created a book with the title '" + book.getTitle() + "' written by " + book.getAuthor() + ".");
                bookManager.addBook(book);
                System.out.println("Current book count in the system: " + bookManager.bookCount + ".");
                System.out.println();
            }
            else if (choice.equals("2")){
                System.out.println("You chose to remove a book.");
                title = askBookTitle();
                author = askBookAuthor();
                boolean bookFound = false;
                for (int i = 0; i < bookManager.books.size(); i++) {
                    Book currentBook = bookManager.books.get(i);
                    if (currentBook.getTitle().equals(title) && currentBook.getAuthor().equals(author)){
                        bookManager.removeBook(currentBook);
                        System.out.println("Book is found and removed!");
                        bookFound = true;
                        break;
                    }
                }
                if (!bookFound){
                    System.out.println("Book not found and therefore cannot be removed.");
                }
                System.out.println();
            }
            else if (choice.equals("3")){
                System.out.println("You chose to see a list of all the books.");
                for (int i = 0; i < bookManager.books.size(); i++){
                    System.out.println((i + 1) + ". '" + bookManager.books.get(i).getTitle() + "' by " + bookManager.books.get(i).getAuthor() + '.');
                }
                System.out.println();
            }
            else if (choice.equals("4")) {
                System.out.println("You chose to exit.");
                exit = true;

            }
        }
    }

    public static String UserInputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String askBookTitle(){
        System.out.print("Please enter the title of the book: ");
        return UserInputString();
    }

    public static String askBookAuthor(){
        System.out.print("Please enter the author of the book: ");
        return UserInputString();
    }
}