package vn.com.t3h.model;

public class ProductDTO {

    private Integer id;
    private String bookTitle;
    private String author;
    private double price;
    private String publisher;
    private int pageCount;
    private int publicationYear;
    private String genre;
    private double discount;
    private int stockQuantity;
    private String description;
    private String categoryName;  // Thêm trường categoryName

    public ProductDTO(){

    }
    // Constructor
    public ProductDTO(Integer id, String bookTitle, String author, double price, String publisher, int pageCount,
                      int publicationYear, String genre, double discount, int stockQuantity,
                      String description, String categoryName) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.discount = discount;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.categoryName = categoryName;
    }

    // Getter and Setter methods for all fields
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
