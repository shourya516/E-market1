package com.Emarket.DAO;

import com.Emarket.Model.Contractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContractorDAOimpl implements ContractorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Contractor> contractorList() {
        Contractor contractor=new Contractor();
        String query="select * form deliverycontractor";
        List<Contractor> contractorList=this.jdbcTemplate.query(query, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                contractor.setContractorid(rs.getInt(1));
                contractor.setContractorName(rs.getString(2));
                contractor.setContractorDescription(rs.getString(3));
                return contractor;
            }
        });
        return contractorList;
}
}
