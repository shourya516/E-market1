package com.Emarket.DAO;

import com.Emarket.Model.Product;
import com.Emarket.Model.User;

import java.util.List;


public interface ProductDAO {
    public void addProduct(Product product);
    public List<Product> getproductList(int id);
}
