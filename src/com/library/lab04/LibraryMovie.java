package com.library.lab04;

import java.time.LocalDate;

public class LibraryMovie implements DigitalContent, Taxable{
    //hw😺😺😺😺
    protected String title;
    protected String director;
    protected String url;
    protected double price;
    protected String type;
    protected Member borrower;
    protected LocalDate dueDate;


    @Override
    public void streamOnline() {

    }

    @Override
    public void download() {

    }

    @Override
    public double calculateTax() {
        return 0;
    }
}
