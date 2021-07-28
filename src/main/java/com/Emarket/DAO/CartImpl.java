package com.Emarket.DAO;

import com.Emarket.Model.Cart;
import com.Emarket.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class CartImpl implements CartDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createCartTable( int id) {
        String query = "CREATE TABLE IF NOT EXISTS CART" + id + "(serialno int primary key auto_increment,customerid int ,productid varchar(36),producttype varchar(200),\n" +
                "productname varchar(200),\n" +
                "productdiscription varchar(400),\n" +
                "vendorId int ,\n" +
                "vendordescription varchar(400),\n" +
                "price double)";
        this.jdbcTemplate.update(query);
    }



    @Override
    public int countCartColumn(int id) {
        String query="SELECT COUNT(*) FROM CART"+id;
        int count=this.jdbcTemplate.queryForObject(query,Integer.class);
        return count;
    }

    @Override
    public void addProductToCart(String productId, int id) {
        String query1="select * from product_table where productid=?";
        Product product= (Product) this.jdbcTemplate.queryForObject(query1, new RowMapper() {
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
        },productId);
        String query3="Insert into CART"+id+"(customerid,productid,producttype,productname,productdiscription,vendorId,vendordescription,price)values(?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(query3,id,product.getProductId(),product.getProductType(),product.getProductName(),product.getProductDescription(),product.getVendorId(),product.getVendorDescription(),product.getPrice());
        System.out.println("product added to cart");
    }

    @Override
    public List<Cart> cartProduct(int id) {
        String query="SELECT * FROM CART"+id;
        return this.jdbcTemplate.query(query, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cart cartProduct1=new Cart();
                cartProduct1.setSerialNo(rs.getInt(1));
                cartProduct1.setCustomerId(rs.getInt(2));
                cartProduct1.setProductId(rs.getString(3));
                cartProduct1.setProductType(rs.getString(4));
                cartProduct1.setProductName(rs.getString(5));
                cartProduct1.setProductDescription(rs.getString(6));
                cartProduct1.setVendorId(rs.getInt(7));
                cartProduct1.setVendorDescription(rs.getString(8));
                cartProduct1.setPrice(rs.getDouble(9));
                return cartProduct1;
            }
        });
    }



    @Override
    public void removeProduct(int serialNo,int id) {
        String query="DELETE FROM cart"+id+" where serialno=?";
        this.jdbcTemplate.update(query,serialNo);
    }

    @Override
    public void order(List<Cart> cartProduct) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        String query="insert into customerordertable(customerid,productid,productname,price,date) values(?,?,?,?,?)";
        String quer1="UPDATE product_table set quantity=quantity-1 where productid=?";
        List<Object[]> cartProductList=new ArrayList<Object[]>();
        for(Cart cart:cartProduct) {
            Object[] objectArray={ cart.getCustomerId(),cart.getProductId(),cart.getProductName(),cart.getPrice(),strDate};
            cartProductList.add(objectArray);
            this.jdbcTemplate.update(quer1,cart.getProductId());
        }
        this.jdbcTemplate.batchUpdate(query,cartProductList);
    }

    @Override
    public void deleteCustomerCart(int id) {
        String query="DROP TABLE cart"+id;
        this.jdbcTemplate.update(query);
        System.out.println("cart deleted");
    }


}


