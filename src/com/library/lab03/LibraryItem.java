package com.library.lab03;

import java.time.LocalDate;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String isbn;
    protected double price;
    protected boolean isAvailable;
    protected Member borrower;
    protected LocalDate dueDate;

    public LibraryItem(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.isAvailable = true;
    }

    // Abstract methods to enforce polymorphism
    public abstract void displayDetails();
    public abstract double calculateLateFee(int days);

    public void checkOut(Member member) {
        if (!isAvailable) {
            System.out.println("Error: Item '" + title + "' is already borrowed and cannot be checked out again.");
            return;
        }
        if (member.getBorrowedCount() >= 3) { // Example limit
            System.out.println("Error: Item '" + title + "' cannot be checked out. Limit reached.");
            return;
        }

        this.isAvailable = false;
        this.borrower = member;
        this.dueDate = LocalDate.now().plusDays(14); // 2-week borrow period
        member.borrowItem();

        System.out.println("Item '" + title + "' has been checked out successfully.");
        System.out.println("Item '" + title + "' has been borrowed by " + member.getName() + ".");
        System.out.println("Return Due Date: " + this.dueDate);
    }

    public void returnItem() {
        if (!isAvailable) {
            this.isAvailable = true;
            this.borrower.returnItem();
            this.borrower = null;
            this.dueDate = null;
            System.out.println("Item '" + title + "' has been returned successfully.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}