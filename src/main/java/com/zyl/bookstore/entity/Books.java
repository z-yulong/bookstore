package com.zyl.bookstore.entity;

/**
 * @author: zyl
 * @date 2023/3/15 15:44
 */
public class Books {
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer sales;
    private Integer stock;
    private String img_path;


    public Books() {
    }

    public Books(Integer id, String title, String author, Double price, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.img_path = img_path;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return sales
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 设置
     * @param sales
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * 获取
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取
     * @return img_path
     */
    public String getImg_path() {
        return img_path;
    }

    /**
     * 设置
     * @param img_path
     */
    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String toString() {
        return "Books{id = " + id +
                ", title = " + title +
                ", author = " + author +
                ", price = " + price +
                ", sales = " + sales +
                ", stock = " + stock +
                ", img_path = " + img_path + "}";
    }
}
