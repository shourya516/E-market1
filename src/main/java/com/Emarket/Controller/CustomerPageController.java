package com.Emarket.Controller;


import com.Emarket.DAO.CartImpl;
import com.Emarket.DAO.ProductDAOImpl;
import com.Emarket.Model.Category;
import com.Emarket.Model.Customer;
import com.Emarket.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customerpage")
//@SessionAttributes("customer")
public class CustomerPageController {
//    List<Product> cartProduct = new ArrayList<>();

    @Autowired
    private ProductDAOImpl productDAOimpl;
    @Autowired
    private CartImpl cart;


    @GetMapping("/allproducts")
    public String getAllProducts(@SessionAttribute("customer") Customer customer, Model model) {
        List<Product> allProductList = productDAOimpl.getAllProduct();
        List<Category> categoryList = productDAOimpl.getCategoryList();
        cart.createCartTable(customer.getCustomerId());
        model.addAttribute("allProductList", allProductList);
        model.addAttribute("categoryList", categoryList);
        int productsInCart=cart.countCartColumn(customer.getCustomerId());
        model.addAttribute("productsInCart",productsInCart);
        return "allAvailableproducts";
    }

    @GetMapping("/login")
    public String unauthorisedAccess() {
        return "redirect:/login";
    }

    @GetMapping("/addtocart")
    public String addTocart(@RequestParam("productid") String productId,@RequestParam("category") String Category,@RequestParam("id") int id,Model model) {
        Product product = productDAOimpl.addToCart(productId);
        cart.addProductToCart(productId,id);
        return "redirect:allproducts?category="+Category;
    }

    @GetMapping("/cart")
    public String getCartPage(Model model) {

        return "cart";
    }
}


