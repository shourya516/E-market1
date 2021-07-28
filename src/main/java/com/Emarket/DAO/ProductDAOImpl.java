package com.Emarket.DAO;

import com.Emarket.Model.Category;
import com.Emarket.Model.Product;
import com.Emarket.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Product> getproductList(int id) {
        List<Product> productList=new ArrayList<>();

        String query="Select * from product_table";
        productList=this.jdbcTemplate.query(query, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                   Product product1=new Product();
                   product1.setProductId(rs.getString(1));
                   product1.setProductType(rs.getString(2));
                   product1.setProductName(rs.getString(3));
                   product1.setProductDescription(rs.getString(4));
                   product1.setVendorId(rs.getInt(5));
                   product1.setVendorDescription(rs.getString(6));
                   product1.setQuantity(rs.getInt(7));
                   product1.setPrice(rs.getDouble(8));
                   product1.setInStock(rs.getString(9));
                   return product1;
            }
        });
        return productList;
    }
    @Override
    public List<Category> getCategoryList(){
        String query="select * from productcategory";
        return this.jdbcTemplate.query(query, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Category category=new Category();
                category.setCategoryId(rs.getInt(1));
                category.setCategory(rs.getString(2));
                return category;
            }
        });
    }
    @Override
    public List<Product> getAllProduct() {
        String query="select * from product_table where instock=?";
        return this.jdbcTemplate.query(query, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product1=new Product();
                product1.setProductId(rs.getString(1));
                product1.setProductType(rs.getString(2));
                product1.setProductName(rs.getString(3));
                product1.setProductDescription(rs.getString(4));
                product1.setVendorId(rs.getInt(5));
                product1.setVendorDescription(rs.getString(6));
                product1.setQuantity(rs.getInt(7));
                product1.setPrice(rs.getDouble(8));
                product1.setInStock(rs.getString(9));
                return product1;
            }
        },"available");
    }

//    @Override
//    public Product addToCart(String productId) {
//        String query="select * from product_table where productid=?";
//        Product product= (Product) this.jdbcTemplate.queryForObject(query, new RowMapper() {
//            @Override
//            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Product product1=new Product();
//                product1.setProductId(rs.getString(1));
//                product1.setProductType(rs.getString(2));
//                product1.setProductName(rs.getString(3));
//                product1.setProductDescription(rs.getString(4));
//                product1.setVendorId(rs.getInt(5));
//                product1.setVendorDescription(rs.getString(6));
//                product1.setQuantity(rs.getInt(7));
//                product1.setPrice(rs.getDouble(8));
//                product1.setInStock(rs.getString(9));
//                return product1;
//            }
//        },productId);
//        return product;
    }



