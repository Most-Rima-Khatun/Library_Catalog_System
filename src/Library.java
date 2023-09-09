import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Book> catalog;

    public Library() {
        catalog = new ArrayList<>();
    }

    // Method to add a book to the catalog
    public void addBook(Book book) {
        catalog.add(book);
    }

    // Method to search for books by title or author
    public ArrayList<Book> search(String keyword) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // Method to mark a book as borrowed
    public void markAsBorrowed(Book book) {
        for (Book b : catalog) {
            if (b.equals(book)) {
                b.setBorrowed(true);
                System.out.println("Book marked as borrowed.");
                return;
            }
        }
        System.out.println("Book not found in the catalog.");
    }

    // Method to mark a book as returned
    public void markAsReturned(Book book) {
        for (Book b : catalog) {
            if (b.equals(book)) {
                b.setBorrowed(false);
                System.out.println("Book marked as returned.");
                return;
            }
        }
        System.out.println("Book not found in the catalog.");
    }

    // Method to display the catalog
    public void displayCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println( (i+1) + ". " + catalog.get(i).representString() );
        }
    }
}
