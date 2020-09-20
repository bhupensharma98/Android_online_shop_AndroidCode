package com.bhupendra.onlineshop.modal_classes;

public class CartModal {

    private String productid;
    private String userid;
    private String quantity;
    private String location;
    private String phone;

    public CartModal(String productid, String userid, String quantity, String location, String phone) {
        this.productid = productid;
        this.userid = userid;
        this.quantity = quantity;
        this.location = location;
        this.phone = phone;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
