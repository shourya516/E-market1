package com.Emarket.Controller;


import com.Emarket.DAO.ProductDAOImpl;
import com.Emarket.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendorpage")
public class VendorPageController {
    @Autowired
    private ProductDAOImpl productDAOimpl;

    @GetMapping("/addProducts")
    public String getAddProductPage(Model model) {
        model.addAttribute("product",new Product());
        return "addProduct";
    }
    @GetMapping("/login")
    public String unautherizedAccess() {
        return "redirect:/login";
    }
    @PostMapping("/submitProductDetails")
    public String submitProductDetails(@ModelAttribute("product") Product product) {
        System.out.println(product);
        productDAOimpl.addProduct(product);
        return "addProduct";
    }
}
