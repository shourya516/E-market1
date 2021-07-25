package com.Emarket.Controller;


import com.Emarket.DAO.ProductDAOImpl;
import com.Emarket.Model.Category;
import com.Emarket.Model.Product;
import com.Emarket.Model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vendorpage")
//@SessionAttributes("vendor")
public class VendorPageController {

    @Autowired
    private ProductDAOImpl productDAOimpl;
    Vendor vendor=new Vendor();



    @GetMapping("/addProducts")
    public String getAddProductPage( Model model) {
        model.addAttribute("product",new Product());
        return "addProduct";
    }
    @GetMapping("/login")
    public String unauthorisedAccess() {
        return "redirect:/login";
    }
    @PostMapping("/submitProductDetails")
    public String submitProductDetails(@ModelAttribute("product") Product product) {
        System.out.println(product);
        productDAOimpl.addProduct(product);
        return "addProduct";
    }
    @GetMapping("/availableproducts")
    public String getavailableproducts(@RequestParam("id") int id,Model model ) {
        List<Product> productList=new ArrayList<>();
        productList=productDAOimpl.getproductList(id);
        List<Category> categorieList=productDAOimpl.getCategoryList();
        model.addAttribute("productList",productList);
        model.addAttribute("size",productList.size());
        model.addAttribute("categoryList",categorieList);

        return "availableproduct";
    }

    @GetMapping("/sold")
    public String soldproducts() {
        return null;
    }


}
