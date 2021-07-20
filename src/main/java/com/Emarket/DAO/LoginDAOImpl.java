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

            Customer customer = new Customer();

            String query = "Select * from customer where emailid=?";

                  customerObj= this.jdbcTemplate.query(query, new RowMapper() {
                    @Override
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

                        customer.setCustName(rs.getString(1));
                        customer.setCustMob(rs.getLong(2));
                        customer.setCustEmail(rs.getString(3));
                        customer.setCustPassword(rs.getString(4));
                        customer.setCustAddress(rs.getString(5));
                        customer.setCustCity(rs.getString(6));
                        customer.setCustState(rs.getString(7));
                        customer.setCustPincode(rs.getString(8));
                        user.setCustomer(customer);
                        return customer;
                    }

                }, user.getEmailid());
                if(customerObj.size()==1){
                if (user.getEmailid().equalsIgnoreCase(customer.getCustEmail()) && user.getLoginPassword().equals(customer.getCustPassword())) {
                    return "customer";
                } else {
                    return "failure";
                }
                } else {
                    return "register";
                }
            }


        else if (user.getConsumerType().equalsIgnoreCase("admin")) {
           Admin admin=new Admin();
           String query="select * from admin where email= ?";
           adminObj=this.jdbcTemplate.query(query, new RowMapper() {
               @Override
               public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                   admin.setName(rs.getString(2));
                   admin.setEmailId(rs.getString(3));
                   admin.setPassword(rs.getString(4));
                   user.setAdmin(admin);
                   return admin;
               }
           },user.getEmailid());
           if(adminObj.size()==1) {
               if (user.getEmailid().equalsIgnoreCase(admin.getEmailId()) && user.getLoginPassword().equals(admin.getPassword())) {
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
            Vendor vendor=new Vendor();
            String query="select * from vendor where emailid=?";
           vendorObj= this.jdbcTemplate.query(query, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    vendor.setVendorName(rs.getString(1));
                    vendor.setVendorMob(rs.getLong(2));
                    vendor.setVendorEmail(rs.getString(3));
                    vendor.setVendorPassword(rs.getString(4));
                    vendor.setVendorAddress(rs.getString(5));
                    vendor.setVendorCity(rs.getString(6));
                    vendor.setVendorState(rs.getString(7));
                    vendor.setVendorPincode(rs.getString(8));
                    user.setVendor(vendor);
                    return vendor;
                }
            },user.getEmailid());
           if(vendorObj.size()==1)
            if(user.getEmailid().equalsIgnoreCase(vendor.getVendorEmail())&& user.getLoginPassword().equals(vendor.getVendorPassword())){
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
            Dealer dealer=new Dealer();
            String query="select * from dealer where emailid=?";
            dealerObj=this.jdbcTemplate.query(query, new RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                    dealer.setDealerName(rs.getString(1));
                    dealer.setDealerMob(rs.getLong(2));
                    dealer.setDealerEmail(rs.getString(3));
                    dealer.setLicenseNumber(rs.getString(4));
                    dealer.setDealerPassword(rs.getString(5));
                    dealer.setDealerAddress(rs.getString(6));
                    dealer.setDealerCity(rs.getString(7));
                    dealer.setDealerState(rs.getString(8));
                    dealer.setDealerPincode(rs.getString(9));
                    user.setDealer(dealer);
                    return dealer;
                }
            },user.getEmailid());
            if(dealerObj.size()==1) {
                if (user.getEmailid().equalsIgnoreCase(dealer.getDealerEmail()) && user.getLoginPassword().equals(dealer.getDealerPassword())) {
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
