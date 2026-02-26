package com.library.lab04;

public class EBook extends LibraryItem implements DigitalContent, Taxable {
    private String downloadUrl;
    private double fileSize;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, 99.0); // E-books might not have a physical replacement price
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
        System.out.println("EBook[Title='" + title + "', Size='" + fileSize + "', Status='" + (isAvailable ? "Available" : "Borrowed") + "']");
           }

    @Override
    public double calculateLateFee(int days) {
        return 0.0; // No late fees, auto-expires
    }

    @Override
    public void printSummary() {
        System.out.println("- Title: " + title);
        System.out.println("- ISBN: " + isbn);
        System.out.println("- Status: " + (isAvailable ? "Available" : "Borrowed"));
        System.out.println("- Return Due Date: " + (isAvailable ? "N/A (E-book is available)" : dueDate));
    }

    @Override
    public void streamOnline() {
//hw
        System.out.println("Streaming '" + title + "' from URL: " + downloadUrl);
        System.out.println("Starting online stream... connected!");
        System.out.println("You can now read the book online without downloading.");
    }

    @Override
    public void download() {
//hw
        System.out.println("Downloading '" + title + "' from URL: " + downloadUrl);
        System.out.printf("Downloading file... (%.2f MB)\n", fileSize);
        System.out.println("Download complete! File saved to your device.");
        System.out.println("You can now read the book offline.");
    }

    @Override
    public double calculateTax() {
        double standardEBookPrice = 99.0;
        double digitalTax = 0.05;
        return standardEBookPrice * digitalTax;
    }
}