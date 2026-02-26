package com.library.lab04;

import java.time.LocalDate;

public class LibraryMovie implements DigitalContent{
    //hw😺😺😺😺
    private String title;
    private String director;
    private String url;
    private int num;
    private int year;
    private String type;
    private double price;

    private double fileSize;
    private Member borrower;
    private LocalDate dueDate;

    public LibraryMovie(String title, String director,
                        String url, int num,
                        int year, String type,
                        double price) {
        this.title = title;
        this.director = director;
        this.url = url;
        this.num = num;
        this.year = year;
        this.type = type;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public Member getBorrower() {
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


    @Override
    public void streamOnline() {
        System.out.println("Streaming Movie '" + title + "' from URL: " + url);
        System.out.println("Starting video stream... connected!");
    }

    @Override
    public void download() {
        System.out.println("Streaming Movie '" + title + "' from URL: " + url);
        System.out.println("Starting video stream... connected!");
    }
    /*
    @Override
    public double calculateTax() {
        return ;
    }
    */
}
