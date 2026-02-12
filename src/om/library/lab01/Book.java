package om.library.lab01;
import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDate;

    // Constructor
    public Book(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status; // แก้ไข: ใช้ค่า status ที่รับเข้ามาแทนการกำหนดตายตัว
    }
/* 
    // Method แสดงรายละเอียด (แก้ไขการเว้นวรรคและเพิ่มหน่วย Baht)
    public void displayDetails() {
        System.out.println("- Title: " + title);
        System.out.println("- Author: " + author);
        System.out.println("- ISBN: " + isbn);
        System.out.println("- Price: " + price + " Baht"); // เพิ่มหน่วย Baht
        System.out.println("- Status: " + status);

        if ((returnDate == null) || (this.status.equalsIgnoreCase("Available"))) {
            System.out.println("- Return Due Date: N/A (Book is available)");
        } else {
            System.out.println("- Return Due Date: " + returnDate);
        }
    }
*/
    // Method ยืมหนังสือ (แก้ไข Logic การคืนค่า และข้อความให้มี ' ')
    public void checkOut(Member member) {
        if ("Available".equalsIgnoreCase(this.status)) {
            this.status = "Borrowed";
            this.returnDate = LocalDate.now().plusDays(14); // กำหนดคืนใน 14 วัน
            System.out.println("Book ['" + title + "'] has been checked out successfully.["+member.getMemberName()+"]");
            System.out.println("Return Due Date: " + this.returnDate);
        } else {
            // แก้ไข: ลบบรรทัดที่ทำให้สถานะผิดเพี้ยนออก (this.status = "Available")
            System.out.println("Error: Book '" + title + "' is already borrowed and cannot be checked out again.");
        }
    }

    // Method คืนหนังสือ
    public void returnBook() {
        this.status = "Available";
        this.returnDate = null; // Reset วันที่คืนเมื่อหนังสือกลับมาแล้ว
        System.out.println("Book '" + title + "' has been returned successfully.");
    }

    // --- Getters and Setters ---
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}