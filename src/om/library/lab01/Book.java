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

    // Method แสดงรายละเอียด (แก้ไขการเว้นวรรคและเพิ่มหน่วย Baht)
    public void displayDetails() {
        System.out.println("Book [Title='" + title + "', Status='" + status + "']");
    }

    // Method ยืมหนังสือ (แก้ไข Logic การคืนค่า และข้อความให้มี ' ')
    public void checkOut(Member member) {

        if (member.canBorrow()) {
            this.status = "Borrowed";
            this.returnDate = LocalDate.now().plusDays(14);
            member.incrementBorrowed();
            System.out.println("Book '" + title + "' has been checked out successfully.");
            System.out.println("Book " + title + " has been borrowed by " + member.getMemberName() + ".");
            System.out.println("Return Due Date: " + this.returnDate);
        }if (!"Available".equalsIgnoreCase(this.status)) {
            System.out.println("Member " + member.getMemberName() + " has reached the borrow limit (3).");
            System.out.println("Borrow request denied for member " + member.getMemberName() + ".");

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