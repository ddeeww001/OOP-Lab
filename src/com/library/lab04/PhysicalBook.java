package com.library.lab04;

public class PhysicalBook extends LibraryItem {
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price);
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        System.out.println("- Title: " + title);
        System.out.println("- Author: " + author);
        System.out.println("- ISBN: " + isbn);
        System.out.println("- Price: " + price + " Baht");
        System.out.println("- Shelf Location: " + shelfLocation);
        System.out.println("- Status: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("- Return Due Date: " + (isAvailable ? "N/A (Book is available)" : dueDate));
    }

    @Override
    public double calculateLateFee(int days) {
        return days * 5.0; // 5 Baht per day
    }
    @Override
    public void printSummary() {
        System.out.println("PhysicalBook[Title='" + title + "', Location='" + shelfLocation + "', Status='" + (isAvailable ? "Available" : "Borrowed") + "']");
    }
}