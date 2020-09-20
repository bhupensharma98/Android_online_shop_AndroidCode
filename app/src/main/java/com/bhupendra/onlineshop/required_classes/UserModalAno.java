package com.bhupendra.onlineshop.required_classes;

public class UserModalAno {

    private String fullname;
    private String email;
    private String address;
    private String phone;

    public UserModalAno(String fullname, String email, String address, String phone) {
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
