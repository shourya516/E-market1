package com.Emarket.Controller;


import com.Emarket.DAO.CartImpl;
import com.Emarket.DAO.ProductDAOImpl;
import com.Emarket.Model.Cart;
import com.Emarket.Model.Category;
import com.Emarket.Model.Customer;
import com.Emarket.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/customerpage")
@SessionAttributes("customer")
@Controller
public class CustomerPageController {
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
    public String addTocart(@SessionAttribute("customer") Customer customer,@RequestParam("productid") String productId,@RequestParam("category") String Category,@RequestParam("id") int id,Model model) {
        cart.addProductToCart(productId,id);
        return "redirect:allproducts?category="+Category;
    }

    @GetMapping("/cart")
    public String getCartPage(@SessionAttribute("customer") Customer customer,Model model) {
        cart.createCartTable(customer.getCustomerId());
        List<Cart> cartList=cart.cartProduct(customer.getCustomerId());
        model.addAttribute("cartList",cartList);
        return "cart";
    }
    @GetMapping("/remove")
    public String removeProduct(@RequestParam("serialno") int serialNo,@RequestParam("id") int id) {
        cart.removeProduct(serialNo,id);
        return "redirect:cart";
    }

    @GetMapping("/checkout")
    public String checkout(@RequestParam("amount") String amount,Model model) {
        model.addAttribute("totalprice",amount);
        return "payment";
    }
    @GetMapping("/pay")
    public String confirmOrder(@SessionAttribute("customer") Customer customer) {
        List<Cart> cartList=cart.cartProduct(customer.getCustomerId());
        cart.order(cartList);
        cart.deleteCustomerCart(customer.getCustomerId());
        return "redirect:/customerpage";
    }
    @GetMapping("/history")
    public String getHistoryPage() {
        return null;
    }

}


