package om.library.lab01;

import java.time.LocalDate;

public class Member {
    private String memberId;
    private String memberName;
/* 
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDate;*/

    public Member(String memberId,String memberName){
        this.memberId=memberId;
        this.memberName=memberName;
    }

    /* 

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
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


}
