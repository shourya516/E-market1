package com.Emarket.Model;

public class Vendor {
    private int vendorId;
    private String vendorName;
    private Long vendorMob;
    private String vendorEmail;
    private String vendorPassword;
    private String vendorAddress;
    private String vendorState;
    private String vendorPincode;
    private String vendorCity;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Long getVendorMob() {
        return vendorMob;
    }

    public void setVendorMob(Long vendorMob) {
        this.vendorMob = vendorMob;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorPassword() {
        return vendorPassword;
    }

    public void setVendorPassword(String vendorPassword) {
        this.vendorPassword = vendorPassword;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorState() {
        return vendorState;
    }

    public void setVendorState(String vendorState) {
        this.vendorState = vendorState;
    }

    public String getVendorPincode() {
        return vendorPincode;
    }

    public void setVendorPincode(String vendorPincode) {
        this.vendorPincode = vendorPincode;
    }

    public String getVendorCity() {
        return vendorCity;
    }

    public void setVendorCity(String vendorCity) {
        this.vendorCity = vendorCity;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorName='" + vendorName + '\'' +
                ", vendorMob=" + vendorMob +
                ", vendorEmail='" + vendorEmail + '\'' +
                ", vendorPassword='" + vendorPassword + '\'' +
                ", vendorAddress='" + vendorAddress + '\'' +
                ", vendorState='" + vendorState + '\'' +
                ", vendorPincode='" + vendorPincode + '\'' +
                ", vendorCity='" + vendorCity + '\'' +
                '}';
    }
}