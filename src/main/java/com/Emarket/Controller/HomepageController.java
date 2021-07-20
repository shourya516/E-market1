package com.Emarket.Controller;


import com.Emarket.Model.Customer;
import com.Emarket.Model.Dealer;
import com.Emarket.Model.User;
import com.Emarket.Model.Vendor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomepageController {
    @GetMapping("/home")
    public String getHomepage() {
        return "homepage";
    }
    @GetMapping("/about")
    public String getAboutusPage() {
        return "aboutusPage";
    }
    @GetMapping("/products")
    public String getProductsPage() {
        return "productsPage";
    }
    @GetMapping("/partners")
    public String getPartnersPage() {
        return "partnersPage";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("customer",new Customer());
        model.addAttribute("vendor",new Vendor());
        model.addAttribute("dealer",new Dealer());
        model.addAttribute("user",new User());
        return "login";
    }




}
