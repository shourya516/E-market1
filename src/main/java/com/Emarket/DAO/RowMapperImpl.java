package com.Emarket.DAO;

import com.Emarket.Model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer=new Customer();
        customer.setCustName(rs.getString(1));
        customer.setCustMob(rs.getLong(2));
        customer.setCustEmail(rs.getString(3));
        customer.setCustPassword(rs.getString(4));
        customer.setCustAddress(rs.getString(5));
        customer.setCustCity(rs.getString(6));
        customer.setCustState(rs.getString(7));
        customer.setCustPincode(rs.getString(8));
        return customer;
    }
}
