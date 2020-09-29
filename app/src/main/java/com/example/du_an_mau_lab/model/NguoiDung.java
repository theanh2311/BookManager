package com.example.du_an_mau_lab.model;

public class NguoiDung {
    public String username;
    public String password;
    public String hoten;
    public String phone;
    public String birthday;



    public NguoiDung(String username, String password, String hoten, String phone, String birthday) {
        this.username = username;
        this.password = password;
        this.hoten = hoten;
        this.phone = phone;
        this.birthday = birthday;
    }

    public NguoiDung() {

    }

    public String getUsername() {
        return username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
