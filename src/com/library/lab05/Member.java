package com.library.lab05;

import javax.management.MalformedObjectNameException;

public class Member {
    private String memberId;
    private String name;
    private int borrowedCount;
    private MembershipStrategy membershipStrategy;
    private int borrowCount=0;

    public Member(String memberId, String name,MembershipStrategy membershipStrategy) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedCount = 0;
        this.membershipStrategy = membershipStrategy;
    }

    public String getName() { return name; }
    public int getBorrowedCount() { return borrowedCount; }
    public void borrowItem() { this.borrowedCount++; }
    public void returnItem() { if(borrowedCount > 0){this.borrowedCount--;}}

    public MembershipStrategy getMembershipStrategy() {
        return membershipStrategy;
    }

    public void setMembershipStrategy(MembershipStrategy membershipStrategy) {
        this.membershipStrategy = membershipStrategy;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

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

    public boolean canBorrow(LibraryItem item){
        if(item == null){
            return  false;
        }
        int limit = membershipStrategy.getBorrowLimit();
        if(membershipStrategy.hasUnlimitedBorrowing()){
            return true;
        }
        if(borrowCount >= limit){
            // ใช้ %s สำหรับ String/Object และ %d สำหรับตัวเลข
            System.out.printf("Member: %s, Limit: %d, Strategy: %s%n", name, limit, membershipStrategy.getMembershipType());
            return false;
        }
        return true;
    }


    public double calculateLateFee(double baseFee) {
        if (membershipStrategy != null) {
            return membershipStrategy.applyLateFeeDiscount(baseFee);
        }
        return baseFee;
    }

    public void displayMemberInfo() {
        System.out.println("--- MEMBER INFORMATION ---");
        System.out.println("ID:"+getMemberId());
        System.out.println("NAME:"+getName());
        System.out.println("Membership type:"+getMembershipStrategy());
        System.out.println("Membership cost:"+membershipStrategy.getMembershipCost()+"Baht");
        System.out.println("Borrow limit:"+membershipStrategy.hasUnlimitedBorrowing()+"Unlimit");
        System.out.println("Currently borrow"+membershipStrategy.getBorrowLimit());
        System.out.println("leon preriot "+ membershipStrategy.getLoanPeriodDays()+"day");

    }
}