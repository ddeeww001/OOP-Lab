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

        // ถ้า canBorrow คืนค่า false แปลว่ายืมไม่ได้ ต้อง "return;" เพื่อหยุดทำงานทันที!
        if (!member.canBorrow(this)) {
            System.out.println("Borrow request denied for member " + member.getName() + ".");
            return; // 🌟 บรรทัดนี้สำคัญมาก! ถ้าไม่มีบรรทัดนี้ หนังสือจะถูกล็อก
        }

        // โค้ดด้านล่างนี้จะทำงานก็ต่อเมื่อผ่านเงื่อนไขด้านบนมาแล้วเท่านั้น
        this.isAvailable = false;
        this.borrower = member;

        int loanDays = member.getMembershipStrategy().getLoanPeriodDays();
        this.dueDate = java.time.LocalDate.now().plusDays(loanDays);

        member.borrowItem();

        System.out.println("Item '" + title + "' has been checked out successfully.");
        System.out.println("Borrowed by " + member.getName() + " (" + member.getMembershipStrategy().getMembershipType() + ")");
        System.out.println("Loan Period: " + loanDays + " days");
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