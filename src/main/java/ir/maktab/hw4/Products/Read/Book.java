package ir.maktab.hw4.Products.Read;

public class Book extends Readable {

    private String size; //جیبی، پالتویی، خشتی، رقعی
    private String coverType; //جلدنرم، جلدسخت
    private String authorName;
    private int printingNo; //توبت چاپ

    public Book(String name, int price, String category, String brand, double weight, int number,
                int publicationYear, String paperType, String publisher, int pages, String language,
                String genre, String size, String coverType, String authorName, int printingNo) {
        super(name, price, category, brand, weight, number, publicationYear, paperType, publisher,
                pages, language, genre);
        this.size = size;
        this.coverType = coverType;
        this.authorName = authorName;
        this.printingNo = printingNo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPrintingNo() {
        return printingNo;
    }

    public void setPrintingNo(int printingNo) {
        this.printingNo = printingNo;
    }
}
