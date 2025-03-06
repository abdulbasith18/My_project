package New_Maven._Project;

import java.util.*;
import java.io.*;

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public void checkIn() {
        isCheckedOut = false;
    }

    // To display book details
    public String toString() {
        return "Title: " + title + ", Author: " + author + (isCheckedOut ? " (Checked out)" : " (Available)");
    }
}

class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // View all books
    public void viewBooks() {
        System.out.println("\nLibrary Catalog:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Check out a book
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()) {
                book.checkOut();
                System.out.println("You have successfully checked out: " + title);
                return;
            }
        }
        System.out.println("Sorry, this book is either not available or already checked out.");
    }

    // Check in a book
    public void checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("You have successfully checked in: " + title);
                return;
            }
        }
        System.out.println("Sorry, this book was not checked out.");
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        while (true) {
            // Display the menu
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Books");
            System.out.println("2. Check Out a Book");
            System.out.println("3. Check In a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;

                case 2:
                    System.out.print("Enter the title of the book to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    library.checkOutBook(checkOutTitle);
                    break;

                case 3:
                    System.out.print("Enter the title of the book to check in: ");
                    String checkInTitle = scanner.nextLine();
                    library.checkInBook(checkInTitle);
                    break;

                case 4:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
