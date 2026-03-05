package com.library.lab05;

import javax.management.MalformedObjectNameException;

public class Member {
    private String memberId;
    private String name;
    private int borrowedCount = 0;
    private MembershipStrategy membershipStrategy;

    public Member(String memberId, String name,MembershipStrategy membershipStrategy) {
        this.memberId = memberId;
        this.name = name;
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

    public boolean canBorrow(LibraryItem item) {
        if (item == null) {
            return false;
        }

        if (membershipStrategy.hasUnlimitedBorrowing()) {
            return true;
        }

        int limit = membershipStrategy.getBorrowLimit();
        if (this.borrowedCount >= limit) {
            System.out.println("Member " + this.getName() + " has reached the borrow limit (" + limit + ") for " + membershipStrategy.getMembershipType() + ".");
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
        System.out.println("ID: " + getMemberId());
        System.out.println("Name: " + getName());
        System.out.println("Membership Type: " + membershipStrategy.getMembershipType());
        System.out.println("Membership Cost: " + membershipStrategy.getMembershipCost() + " Baht");

        if (membershipStrategy.hasUnlimitedBorrowing()) {
            System.out.println("Borrow Limit: Unlimited");
        } else {
            System.out.println("Borrow Limit: " + membershipStrategy.getBorrowLimit());
        }

        System.out.println("Currently Borrowed: " + borrowedCount);
        System.out.println("Loan Period: " + membershipStrategy.getLoanPeriodDays() + " days");
    }
}