public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private boolean isBorrowed;

    // Constructor
    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.isBorrowed = false; // Initially not borrowed
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getISBN() {
        return isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    //Setter method
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    // Method to mark the book as borrowed
    public void markAsBorrowed() {
        isBorrowed = true;
    }

    // Method to mark the book as returned
    public void markAsReturned() {
        isBorrowed = false;
    }


    public String representString() {
        String status;
        if(isBorrowed){
            status = "(Borrowed)";
        }
        else{
            status = "(Not Borrowed)";
        }
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear + ", ISBN: " + isbn + status;
    }
}

