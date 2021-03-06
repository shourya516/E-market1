package com.Emarket.DAO;


import com.Emarket.Model.Cart;

import java.util.List;

public interface CartDAO {
        public void createCartTable(int id);
        public int countCartColumn(int id);
        public void addProductToCart(String productId,int id);
        public List<Cart> cartProduct(int id);
//        public double cartValue(int id);
        public void removeProduct(int serialNo,int id);
        public void order(List<Cart> cartProduct);
        public void deleteCustomerCart(int id);
}
