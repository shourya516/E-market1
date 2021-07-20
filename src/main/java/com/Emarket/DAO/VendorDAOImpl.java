package com.Emarket.DAO;

import com.Emarket.Model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAOImpl implements VendorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void registerVendor(Vendor vendor) {
        String query="insert into vendor(vendorname,mobileno, emailid, password,address, city, State,postalcode)values(?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(query,vendor.getVendorName(),vendor.getVendorMob(),vendor.getVendorEmail(),vendor.getVendorPassword(),vendor.getVendorAddress(),vendor.getVendorCity(),vendor.getVendorState(),vendor.getVendorPincode());
        System.out.println("Detais added to vendor table");
    }
}
