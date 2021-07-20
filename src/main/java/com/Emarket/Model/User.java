package com.Emarket.Model;

public class User {
   private String emailid;
   private String consumerType;
   private String loginPassword;
   private Customer customer;
   private Admin admin;
   private Dealer dealer;
   private Vendor vendor;

   public String getEmailid() {
      return emailid;
   }

   public void setEmailid(String emailid) {
      this.emailid = emailid;
   }

   public String getConsumerType() {
      return consumerType;
   }

   public void setConsumerType(String consumerType) {
      this.consumerType = consumerType;
   }

   public String getLoginPassword() {
      return loginPassword;
   }

   public void setLoginPassword(String loginPassword) {
      this.loginPassword = loginPassword;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public Admin getAdmin() {
      return admin;
   }

   public void setAdmin(Admin admin) {
      this.admin = admin;
   }

   public Dealer getDealer() {
      return dealer;
   }

   public void setDealer(Dealer dealer) {
      this.dealer = dealer;
   }

   public Vendor getVendor() {
      return vendor;
   }

   public void setVendor(Vendor vendor) {
      this.vendor = vendor;
   }
}
