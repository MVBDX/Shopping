package ir.maktab.hw4.Products.Read;

import ir.maktab.hw4.Products.Product;

public abstract class Readable extends Product {
    private int publicationYear;
    private String paperType; //معمولی، کاهی، گلاسه
    private String publisher;
    private int pages;
    private String language;
    private String genre;


    public Readable(String name, int price, String category, String brand, double weight, int number, int publicationYear, String paperType, String publisher, int pages, String language, String genre) {
        super(name, price, category, brand, weight, number);
        this.publicationYear = publicationYear;
        this.paperType = paperType;
        this.publisher = publisher;
        this.pages = pages;
        this.language = language;
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
