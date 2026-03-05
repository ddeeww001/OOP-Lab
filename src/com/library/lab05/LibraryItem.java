package com.library.lab05;
import java.time.LocalDate;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String isbn;
    protected double price;
    protected boolean isAvailable;
    protected String borrowBy;
    Member borrower;
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
    public abstract void printSummary();

    public void checkOut(Member member) {

        if (!isAvailable) {
            System.out.println("Error: Item '" + title + "' is already borrowed and cannot be checked out again.");
            return;
        }

        // โค้ดส่วนนี้จะวิ่งไปเช็คเงื่อนไขใน canBorrow() ที่เราเพิ่งแก้ด้านบน
        if (!member.canBorrow(this)) {
            System.out.println("Error: Item '" + title + "' cannot be checked out. Limit reached.");
            return;
        }

        this.isAvailable = false;
        this.borrower = member;

        // ดึงจำนวนวันยืมจาก Strategy (เช่น 14, 21, หรือ 30 วัน)
        int loanDays = member.getMembershipStrategy().getLoanPeriodDays();
        this.dueDate = LocalDate.now().plusDays(loanDays);

        member.borrowItem(); // ตรงนี้จะไปบวกค่าให้ตัวแปร borrowedCount

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

    Member getBorrower() {
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