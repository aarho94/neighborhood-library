package com.pluralsight;

public class Book {
    // variables
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false; // Initially, the book is not checked out
        this.checkedOutTo = "";   // Initially, no one has checked out the book
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // method to check out the book
    public void checkOut(String name) {
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("Book checked out successfully to " + name);
        } else {
            System.out.println("Book is already checked out");
        }
    }

    // method to check in the book
    public void checkIn() {
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("Book checked in successfully");
        } else {
            System.out.println("Book is already checked in");
        }
    }
}

