import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Catalog System!");

        while (true) {
            System.out.println();
            System.out.println("1. Add Book");
            System.out.println("2. Search Books");
            System.out.println("3. Mark Borrowed/Returned");
            System.out.println("4. Display Catalog");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: >>>");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter the publication year: ");
                    int publicationYear = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the ISBN: ");
                    String ISBN = scanner.nextLine();

                    Book newBook = new Book(title, author, publicationYear, ISBN);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;

                case "2":
                    System.out.print("Enter the title or author to search: ");
                    String keyword = scanner.nextLine();
                    ArrayList<Book> searchResults = library.search(keyword);

                    if (!searchResults.isEmpty()) {
                        System.out.println("Matching books:");
                        for (Book result : searchResults) {
                            System.out.println(result.representString());
                        }
                    } else {
                        System.out.println("No matching books found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter the title of the book to mark (borrow/return): ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter 'borrow' or 'return': ");
                    String action = scanner.nextLine();

                    // Find the book in the catalog and mark it as borrowed or returned
                    List<Book> borrowResults = library.search(bookTitle);
                    if (!borrowResults.isEmpty()) {
                        Book bookToMark = borrowResults.get(0);
                        if (action.equalsIgnoreCase("borrow")) {
                            library.markAsBorrowed(bookToMark);
                        } else if (action.equalsIgnoreCase("return")) {
                            library.markAsReturned(bookToMark);
                        } else {
                            System.out.println("Invalid action. Use 'borrow' or 'return'.");
                        }
                    } else {
                        System.out.println("Book not found in the catalog.");
                    }
                    break;

                case "4":
                    System.out.println("Catalog:");
                    library.displayCatalog();
                    break;

                case "5":
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

