package com.library.lab05;

// ไม่มีการ extends คลาสใดๆ แต่ implements DigitalContent
public class LibraryMovie implements DigitalContent {
    private String title;
    private String director;
    private String url;
    private int duration;
    private int year;
    private String genre;
    private double price;

    public LibraryMovie(String title, String director, String url, int duration, int year, String genre, double price) {
        this.title = title;
        this.director = director;
        this.url = url;
        this.duration = duration;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    // Implement method จาก DigitalContent
    @Override
    public void streamOnline() {
        System.out.println("Streaming Movie '" + title + "'...");
        System.out.println("Playing video at 1080p...");
    }

    @Override
    public void download() {
        System.out.println("Downloading Movie '" + title + "' for offline viewing...");
        System.out.println("Movie downloaded successfully.");
    }
}