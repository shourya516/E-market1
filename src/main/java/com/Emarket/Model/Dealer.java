package com.Emarket.Model;

public class Dealer {
    private int dealerId;
  private String dealerName;
  private Long dealerMob;
  private String dealerEmail;
  private String dealerPassword;
  private String licenseNumber;
  private String dealerAddress;
  private String dealerState;
  private String dealerPincode;
  private String dealerCity;
  private String status;

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public Long getDealerMob() {
        return dealerMob;
    }

    public void setDealerMob(Long dealerMob) {
        this.dealerMob = dealerMob;
    }

    public String getDealerEmail() {
        return dealerEmail;
    }

    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }

    public String getDealerPassword() {
        return dealerPassword;
    }

    public void setDealerPassword(String dealerPassword) {
        this.dealerPassword = dealerPassword;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }

    public String getDealerState() {
        return dealerState;
    }

    public void setDealerState(String dealerState) {
        this.dealerState = dealerState;
    }

    public String getDealerPincode() {
        return dealerPincode;
    }

    public void setDealerPincode(String dealerPincode) {
        this.dealerPincode = dealerPincode;
    }

    public String getDealerCity() {
        return dealerCity;
    }

    public void setDealerCity(String dealerCity) {
        this.dealerCity = dealerCity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "dealerName='" + dealerName + '\'' +
                ", dealerMob=" + dealerMob +
                ", dealerEmail='" + dealerEmail + '\'' +
                ", dealerPassword='" + dealerPassword + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", dealerAddress='" + dealerAddress + '\'' +
                ", dealerState='" + dealerState + '\'' +
                ", dealerPincode='" + dealerPincode + '\'' +
                ", dealerCity='" + dealerCity + '\'' +
                '}';
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }
}
