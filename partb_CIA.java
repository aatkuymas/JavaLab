// Base class: Book
//Develop a class named Book with essential attributes:
//bookId (integer): unique identification number for each book
//title (String): the title of the book
//author (String): the author of the book
//Implement appropriate methods for setting and retrieving these attributes, ensuring
//adherence to professional coding standards.
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(int bookId, String title, String author) {
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID must be positive.");
        }
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default state is available
    }

   
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    /*Design methods for borrowing and returning books in the Library
Management System. ● Implement a mechanism to track the availability of each book, and
update it accordingly when borrowed or returned.*/
    public void borrowBook() {
        if (!isAvailable) {
            System.out.println("The book '" + title + "' is already borrowed.");
        } else {
            isAvailable = false;
            System.out.println("You have successfully borrowed the book: '" + title + "'.");
        }
    }

    public void returnBook() {
        if (isAvailable) {
            System.out.println("The book '" + title + "' is already available in the library.");
        } else {
            isAvailable = true;
            System.out.println("You have successfully returned the book: '" + title + "'.");
        }
    }
    // Display book details
    public void displayInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
    }
}
/*Create specialized classes, ReferenceBook and
FictionBook, both extending the Book class. For ReferenceBook, introduce an additional
attribute:

- edition (int): the edition number of the reference book
For FictionBook, include an extra attribute:
-genre (String): the genre of the fiction book

Implement methods in each derived class to display detailed book information.*/
// Derived class: ReferenceBook
class ReferenceBook extends Book {
    private int edition;

    public ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        if (edition <= 0) {
            throw new IllegalArgumentException("Edition must be positive.");
        }
        this.edition = edition;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Edition: " + edition);
    }
}

// Derived class: FictionBook
class FictionBook extends Book {
    private String genre;

    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}
/*Extend the hierarchy with a new class, Periodical, derived from ReferenceBook.
● Introduce an extra attribute:
● issueFrequency (String): the frequency at which the periodical is issued (e.g.,
weekly, monthly).

● Implement methods to display detailed information for periodicals. */

// Derived class: Periodical
class Periodical extends ReferenceBook {
    private String issueFrequency;

    public Periodical(int bookId, String title, String author, int edition, String issueFrequency) {
        super(bookId, title, author, edition);
        this.issueFrequency = issueFrequency;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Frequency: " + issueFrequency);
    }
}

// Main Class
public class partb_CIA {
    public static void main(String[] args) {
        try {            
            Book generalBook = new Book(23, "XYZ", "ABC");
            ReferenceBook refBook = new ReferenceBook(2, "def", "Bdef", 5);
            FictionBook fictionBook = new FictionBook(3, "lmno", "hello", "hijk");
            Periodical periodical = new Periodical(4, "pqr", "sam", 2, "Weekly");

            // Displaying book details
            generalBook.displayInfo();
            System.out.println();
            refBook.displayInfo();
            System.out.println();
            fictionBook.displayInfo();
            System.out.println();
            periodical.displayInfo();

            // Borrow and return operations
            System.out.println("\nBorrowing Books:");
            generalBook.borrowBook();
            generalBook.displayInfo();
            System.out.println();
            //to see if the status changes or not:
            generalBook.borrowBook(); 

            System.out.println("\nReturning Books:");
            generalBook.returnBook();
            //to see if the status changes or not:
            generalBook.returnBook(); 

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
