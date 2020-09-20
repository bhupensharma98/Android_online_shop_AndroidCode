package com.bhupendra.onlineshop.modal_classes;

public class GetCartModal {

    private String username;
    private String userid;
    private String productid;
    private String productName;
    private String price;
    private String location;
    private String image;

    public GetCartModal(String username, String userid, String productid, String productName, String price, String location, String image) {
        this.username = username;
        this.userid = userid;
        this.productid = productid;
        this.productName = productName;
        this.price = price;
        this.location = location;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
