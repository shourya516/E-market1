package com.Emarket.DAO;

import com.Emarket.Model.Dealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DealerDAOImpl implements DealerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void dealerRegistration(Dealer dealer) {
        String query="Insert into dealer(dealername,mobileno,emailid,licenseno,password,address,city,state,postalcode) values(?,?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(query,dealer.getDealerName(),dealer.getDealerMob(),dealer.getDealerEmail(),dealer.getLicenseNumber(),dealer.getDealerPassword(),dealer.getDealerAddress(),dealer.getDealerCity(),dealer.getDealerState(),dealer.getDealerPincode());
    }
}
