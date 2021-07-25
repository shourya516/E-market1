package com.Emarket.DAO;

import com.Emarket.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Repository
public class LoginDAOImpl implements LoginDAO{
    private List<Customer> customerObj;
    private List<Vendor> vendorObj;
    private List<Dealer> dealerObj;
    private List<Admin> adminObj;
    public List<Customer> getCustomerObj() {
        return customerObj;
    }

    public void setCustomerObj(List<Customer> customerObj) {
        this.customerObj = customerObj;
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String authenticateUsers(User user) {

        if (user.getConsumerType().equalsIgnoreCase("Customer")) {



            String query = "Select * from customer where emailid=?";

                  customerObj= this.jdbcTemplate.query(query, new RowMapper() {
                    @Override
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Customer customer = new Customer();
                        customer.setCustomerId(rs.getInt(1));
                        customer.setCustName(rs.getString(2));
                        customer.setCustMob(rs.getLong(3));
                        customer.setCustEmail(rs.getString(4));
                        customer.setCustPassword(rs.getString(5));
                        customer.setCustAddress(rs.getString(6));
                        customer.setCustCity(rs.getString(7));
                        customer.setCustState(rs.getString(8));
                        customer.setCustPincode(rs.getString(9));
                        user.setCustomer(customer);
                        return customer;
                    }

                }, user.getEmailid());
                if(customerObj.size()==1){
                if (user.getEmailid().equalsIgnoreCase(user.getCustomer().getCustEmail()) && user.getLoginPassword().equals(user.getCustomer().getCustPassword())) {
                    return "customer";
                } else {
                    return "failure";
                }
                } else {
                    return "register";
                }
            }


        else if (user.getConsumerType().equalsIgnoreCase("admin")) {

           String query="select * from admin where email= ?";
           adminObj=this.jdbcTemplate.query(query, new RowMapper() {
               @Override
               public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                   Admin admin=new Admin();
                   admin.setName(rs.getString(2));
                   admin.setEmailId(rs.getString(3));
                   admin.setPassword(rs.getString(4));
                   user.setAdmin(admin);
                   return admin;
               }
           },user.getEmailid());
           if(adminObj.size()==1) {
               if (user.getEmailid().equalsIgnoreCase(user.getAdmin().getEmailId()) && user.getLoginPassword().equals(user.getAdmin().getPassword())) {
                   return "admin";
               } else {
                   return "failure";
               }
           }
           else {
               return "register";
           }
        }
        else if(user.getConsumerType().equalsIgnoreCase("vendor")) {

            String query="select * from vendor where emailid=?";
           vendorObj= this.jdbcTemplate.query(query, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Vendor vendor=new Vendor();
                    vendor.setVendorId(rs.getInt(1));
                    vendor.setVendorName(rs.getString(2));
                    vendor.setVendorMob(rs.getLong(3));
                    vendor.setVendorEmail(rs.getString(4));
                    vendor.setVendorPassword(rs.getString(5));
                    vendor.setVendorAddress(rs.getString(6));
                    vendor.setVendorCity(rs.getString(7));
                    vendor.setVendorState(rs.getString(8));
                    vendor.setVendorPincode(rs.getString(9));
                    user.setVendor(vendor);
                    return vendor;
                }
            },user.getEmailid());
           if(vendorObj.size()==1)
            if(user.getEmailid().equalsIgnoreCase(user.getVendor().getVendorEmail())&& user.getLoginPassword().equals(user.getVendor().getVendorPassword())){
                return "vendor";
            }
            else {
                return "failure";
            }
            else {
                return "register";
           }
        }
        else {

            String query="select * from dealer where emailid=?";
            dealerObj=this.jdbcTemplate.query(query, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Dealer dealer=new Dealer();
                    dealer.setDealerId(rs.getInt(1));
                    dealer.setDealerName(rs.getString(2));
                    dealer.setDealerMob(rs.getLong(3));
                    dealer.setDealerEmail(rs.getString(4));
                    dealer.setLicenseNumber(rs.getString(5));
                    dealer.setDealerPassword(rs.getString(6));
                    dealer.setDealerAddress(rs.getString(7));
                    dealer.setDealerCity(rs.getString(8));
                    dealer.setDealerState(rs.getString(9));
                    dealer.setDealerPincode(rs.getString(10));
                    user.setDealer(dealer);
                    return dealer;
                }
            },user.getEmailid());
            if(dealerObj.size()==1) {
                if (user.getEmailid().equalsIgnoreCase(user.getDealer().getDealerEmail()) && user.getLoginPassword().equals(user.getDealer().getDealerPassword())) {
                    return "dealer";
                } else {
                    return "failure";
                }
            }
            else {
                return "register";
            }
        }

    }

    public List<Vendor> getVendorObj() {
        return vendorObj;
    }

    public void setVendorObj(List<Vendor> vendorObj) {
        this.vendorObj = vendorObj;
    }

    public List<Dealer> getDealerObj() {
        return dealerObj;
    }

    public void setDealerObj(List<Dealer> dealerObj) {
        this.dealerObj = dealerObj;
    }

    public List<Admin> getAdminObj() {
        return adminObj;
    }

    public void setAdminObj(List<Admin> adminObj) {
        this.adminObj = adminObj;
    }
}
