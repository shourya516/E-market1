package com.Emarket.Controller;


import com.Emarket.DAO.ProductDAOImpl;
import com.Emarket.Model.Category;
import com.Emarket.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customerpage")
public class CustomerPageController {
    List<Product> cartProduct=new ArrayList<>();
    @Autowired
    private ProductDAOImpl productDAOimpl;


    @GetMapping("/allproducts")
    public String getAllProducts(Model model) {
       List<Product> allProductList=productDAOimpl.getAllProduct();
       List<Category> categoryList=productDAOimpl.getCategoryList();
       model.addAttribute("allProductList",allProductList);
       model.addAttribute("categoryList",categoryList);
       model.addAttribute("cartProduct",cartProduct);
       return "allAvailableproducts";
    }
    @GetMapping("/login")
    public String unauthorisedAccess() {
        return "redirect:/login";
    }

    @GetMapping ("/addtocart")
    public String addTocart(@RequestParam("productid") String productId) {
        Product product=productDAOimpl.addToCart(productId);
        cartProduct.add(product);
        System.out.println(productId);
//        System.out.println(cartProduct.get(0).getProductId());
        System.out.println(cartProduct.size());
        return "redirect:allproducts";
    }
    @GetMapping("/cart")
    public String getCartPage(Model model) {
        model.addAttribute("cartProduct",cartProduct);

        return "cart";
    }

}
