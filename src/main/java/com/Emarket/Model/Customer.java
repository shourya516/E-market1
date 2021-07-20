package com.Emarket.Model;

public class Customer {
    private String custName;
    private Long custMob;
    private String custEmail;
    private String custPassword;
    private String custAddress;
    private String custState;
    private String custPincode;
    private String custCity;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getCustMob() {
        return custMob;
    }

    public void setCustMob(Long custMob) {
        this.custMob = custMob;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustState() {
        return custState;
    }

    public void setCustState(String custState) {
        this.custState = custState;
    }

    public String getCustPincode() {
        return custPincode;
    }

    public void setCustPincode(String custPincode) {
        this.custPincode = custPincode;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custName='" + custName + '\'' +
                ", custMob=" + custMob +
                ", custEmail='" + custEmail + '\'' +
                ", custPassword='" + custPassword + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custState='" + custState + '\'' +
                ", custPincode='" + custPincode + '\'' +
                ", custCity='" + custCity + '\'' +
                '}';
    }
}
