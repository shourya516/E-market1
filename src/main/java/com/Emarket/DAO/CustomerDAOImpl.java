package com.Emarket.DAO;

import com.Emarket.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insertCustomerDetails(Customer customer) {

        String query="insert into customer(customername,mobileno,emailid,password,address,city,state,pincode) values(?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(query,customer.getCustName(),customer.getCustMob(),customer.getCustEmail(),customer.getCustPassword(),customer.getCustAddress(),customer.getCustCity(),customer.getCustState(),customer.getCustPincode());
        System.out.println("Details of Customer: "+ customer.getCustName()+ " added to customer table");

    }
}
