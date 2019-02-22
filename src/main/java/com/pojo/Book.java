package com.pojo;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookAuthor;

    private Float bookPrice;

    private Integer bookAmount;

    private String bookCategory;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookAmount(){return bookAmount;}

    public void setBookAmount(Integer amount){this.bookAmount = amount;}

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory == null ? null : bookCategory.trim();
    }
}