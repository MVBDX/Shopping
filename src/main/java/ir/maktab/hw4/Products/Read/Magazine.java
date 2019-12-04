package ir.maktab.hw4.Products.Read;

public class Magazine extends Readable {
    private String periodPublication;//هفتگی، ماهنامه، فصلنامه، گاهنامه
    private String publicationMonth;
    private boolean colored; //مجله رنگی

    public Magazine(String name, int price, String category, String brand, double weight, int number,
                    int publicationYear, String paperType, String publisher, int pages, String language,
                    String genre, String periodPublication, String publicationMonth, boolean colored) {
        super(name, price, category, brand, weight, number, publicationYear, paperType, publisher, pages,
                language, genre);
        this.periodPublication = periodPublication;
        this.publicationMonth = publicationMonth;
        this.colored = colored;
    }

    public String getPeriodPublication() {
        return periodPublication;
    }

    public void setPeriodPublication(String periodPublication) {
        this.periodPublication = periodPublication;
    }

    public String getPublicationMonth() {
        return publicationMonth;
    }

    public void setPublicationMonth(String publicationMonth) {
        this.publicationMonth = publicationMonth;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }
}
