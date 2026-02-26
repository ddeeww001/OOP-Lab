package com.library.lab05;

public class Member {
    private String memberId;
    private String name;
    private int borrowedCount;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedCount = 0;
    }

    public String getName() { return name; }
    public int getBorrowedCount() { return borrowedCount; }
    public void borrowItem() { this.borrowedCount++; }
    public void returnItem() { if(borrowedCount > 0){this.borrowedCount--;}}

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }
}