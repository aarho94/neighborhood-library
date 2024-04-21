package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Book> books;
    private Scanner scanner;

    public Main() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to populate initial book data
    private void initializeBooks() {
        // Sample young adult novels
        String[] titles = {
                "The Hunger Games",
                "Harry Potter and the Sorcerer's Stone",
                "Twilight",
                "The Fault in Our Stars",
                "Divergent",
                "The Maze Runner",
                "To All the Boys I've Loved Before",
                "The Perks of Being a Wallflower",
                "Percy Jackson and the Lightning Thief",
                "The Book Thief",
                "The Giver",
                "Thirteen Reasons Why",
                "Eleanor & Park",
                "The Selection",
                "Paper Towns",
                "City of Bones",
                "Speak",
                "Looking for Alaska",
                "The Outsiders",
                "The Princess Diaries"
        };

        String[] isbns = {
                "9780439023481",
                "9780747532743",
                "9780316015844",
                "9780142424179",
                "9780062387240",
                "9780385737951",
                "9781442426719",
                "9781476755864",
                "9780786838653",
                "9780375831003",
                "9780544336254",
                "9781595141880",
                "9781250047332",
                "9780062366915",
                "9780525428028",
                "9781481458486",
                "9780142407328",
                "9780525478812",
                "9780142407335",
                "9780061786180"
        };

        // Populate books array with random young adult novels
        for (int i = 0; i < titles.length; i++) {
            books.add(new Book(i + 1, isbns[i], titles[i]));
        }
    }

    // Method to display the store home screen
    private void displayHomeScreen() {
        System.out.println("Welcome to the Library!");
        System.out.println("Choose an option:");
        System.out.println("1. Show Available Books");
        System.out.println("2. Show Checked Out Books");
        System.out.println("3. Exit");
    }

    // Method to handle user input and navigate between screens
    public void run() {
        initializeBooks();
        boolean running = true;
        while (running) {
            displayHomeScreen();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to display available books
    private void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getId() + " - " + book.getIsbn() + " - " + book.getTitle());
            }
        }
        System.out.println("Enter ID to check out a book, or type 'X' to go back.");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("X")) {
            return;
        }
        int bookId = Integer.parseInt(input);
        // Implement book checkout logic here
    }

    // Method to display checked out books
    private void showCheckedOutBooks() {
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(book.getId() + " - " + book.getIsbn() + " - " + book.getTitle() + " - Checked out to: " + book.getCheckedOutTo());
            }
        }
        System.out.println("Enter 'C' to check in a book, or 'X' to go back.");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("X")) {
            return;
        }
        if (input.equalsIgnoreCase("C")) {
            // Implement check-in logic here
        }
    }

    // Method to check in a book
    private void checkInBook(int bookId) {
        // Implement check-in logic here
    }

    public static void main(String[] args) {
        Main library = new Main();
        library.run();
    }
}
