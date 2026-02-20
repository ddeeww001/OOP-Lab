package com.library.lab03;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private double fileSize;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, 0.0); // E-books might not have a physical replacement price
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        System.out.println("- Title: " + title);
        System.out.println("- Author: " + author);
        System.out.println("- ISBN: " + isbn);
        System.out.println("- Download URL: " + downloadUrl);
        System.out.println("- File Size: " + fileSize + " MB");
        System.out.println("- Status: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("- Return Due Date: " + (isAvailable ? "N/A (E-book is available)" : dueDate));
    }

    @Override
    public double calculateLateFee(int days) {
        return 0.0; // No late fees, auto-expires
    }

    @Override
    public void printSummary() {

    }
}