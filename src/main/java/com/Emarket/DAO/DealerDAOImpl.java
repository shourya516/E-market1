package com.Emarket.DAO;

import com.Emarket.Model.Dealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DealerDAOImpl implements DealerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void dealerRegistration(Dealer dealer) {
        String query="Insert into dealer(dealername,mobileno,emailid,licenseno,password,address,city,state,postalcode,status) values(?,?,?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(query,dealer.getDealerName(),dealer.getDealerMob(),dealer.getDealerEmail(),dealer.getLicenseNumber(),dealer.getDealerPassword(),dealer.getDealerAddress(),dealer.getDealerCity(),dealer.getDealerState(),dealer.getDealerPincode(),"pending");
    }

    @Override
    public List<Dealer> getUnverfiedList() {
       String query="SELECT * FROM dealer where status=?";
       return this.jdbcTemplate.query(query, new RowMapper() {
           @Override
           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
               Dealer dealer=new Dealer();
               dealer.setDealerId(rs.getInt(1));
               dealer.setDealerName(rs.getString(2));
               dealer.setDealerMob(rs.getLong(3));
               dealer.setDealerEmail(rs.getString(4));
               dealer.setLicenseNumber(rs.getString(5));
               return dealer;
           }
       },"pending");
    }

    @Override
    public void approveOrReject(int id,String status) {
        String query="UPDATE dealer set status=? where dealerid=?";
        this.jdbcTemplate.update(query,status,id);
    }
}
