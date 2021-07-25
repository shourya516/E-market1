package com.Emarket.DAO;


import com.Emarket.Model.Cart;

import java.util.List;

public interface CartDAO {
        public void createCartTable(int id);
        public int countCartColumn(int id);
        public void addProductToCart(String productId,int id);
        public List<Cart> cartProduct(int id);

}
