package vn.com.t3h.model;

public class ProductDTO {

    private Integer id;
    private String bookTitle;
    private String author;
    private Integer pageCount;
    private String publisher;
    private Integer publicationYear;
    private String genre;
    private double price;
    private double discount;
    private Integer stockQuantity;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String bookTitle, String author, Integer pageCount, String publisher, Integer publicationYear, String genre, double price, double discount, Integer stockQuantity, String description) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.pageCount = pageCount;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.price = price;
        this.discount = discount;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
