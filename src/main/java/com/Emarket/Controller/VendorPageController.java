package com.Emarket.Controller;


import com.Emarket.DAO.ProductDAOImpl;
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
@SessionAttributes("vendor")
public class VendorPageController {
    List<Product> productList=new ArrayList<>();

    @Autowired
    private ProductDAOImpl productDAOimpl;
    Vendor vendor=new Vendor();
//    int vendorid=vendor.getVendorId();


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
    public String getavailableproducts(@ModelAttribute("vendor") Vendor vendor,Model model) {
       productList=productDAOimpl.getproductList(vendor.getVendorId());
       model.addAttribute("productList",productList);
//        System.out.println(productList.size());
//        System.out.println(productList.get(1).getProductId());
        return "availableproduct";
    }
    @GetMapping("/sold")
    public String soldproducts() {
        return null;
    }


}
