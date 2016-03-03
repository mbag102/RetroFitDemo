package com.emmbi.mobile.retrofitdemo.model;

/**
 * Created by mbagliojr on 3/2/16.
 */
public class CreateObject {

    private String pin;
    private String token;
    private String phone;
    private String internationalCode;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInternationalCode() {
        return internationalCode;
    }

    public void setInternationalCode(String internationalCode) {
        this.internationalCode = internationalCode;
    }
}
