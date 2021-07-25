package com.Emarket.Model;


import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Customer {

    private  int customerId;
    @NotEmpty
    private String custName;
    @NotEmpty
    private Long custMob;
    @NotEmpty
    private String custEmail;
    @NotEmpty
    private String custPassword;
    @NotEmpty
    private String custAddress;
    @NotEmpty
    private String custState;
    @NotEmpty
    private String custPincode;
    @NotEmpty
    private String custCity;
    private List<Product> cartList;

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

    public List<Product> getCartList() {
        return cartList;
    }

    public void setCartList(List<Product> cartList) {
        this.cartList = cartList;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
