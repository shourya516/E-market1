package com.Emarket.DAO;

import com.Emarket.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addProduct(Product product) {
        String query="Insert into product_table(productid,productType,productname,productdiscription,vendorid,vendordescription,quantity,price,instock)values(uuid(),?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(query,product.getProductType(),product.getProductName(),product.getProductDescription(),product.getVendorId(),product.getVendorDescription(),product.getQuantity(),product.getPrice(),"available");
        System.out.println("product added successfully by "+ product.getVendorId());
    }
}
