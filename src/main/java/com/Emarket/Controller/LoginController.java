package com.Emarket.Controller;

import com.Emarket.Model.*;
import com.Emarket.Service.AuthenticationService;
import com.Emarket.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller

public class LoginController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/customerRegistration")
    public String registerCustomer(@ModelAttribute("customer") Customer customer) {
        registerService.getCustomerDAOimpl().insertCustomerDetails(customer);
        System.out.println(customer);
        return "homepage";
    }
    @PostMapping("/dealerRegistration")
    public String registerDealer(@ModelAttribute("dealer")Dealer dealer){
        registerService.getDealerDAOimpl().dealerRegistration(dealer);;
        return "homepage";
    }
    @PostMapping("/vendorRegistration")
    public String vendorRegister(@ModelAttribute("vendor") Vendor vendor) {
       registerService.getVendorDAOimpl().registerVendor(vendor);
       return "homepage";
    }
    @PostMapping("/authenticate")
    public String authenticateUser(@ModelAttribute("user") User user, Model model,HttpServletRequest request) {
        String page=authenticationService.pageRedirectedLogin(user);
        Customer customer1= user.getCustomer();
        Admin admin1= user.getAdmin();
        System.out.println("this is customer");
        System.out.println(user.getCustomer()!=null);
        System.out.println("this is admin");
        System.out.println(user.getAdmin()!=null);
        System.out.println("this is dealer");
        System.out.println(user.getDealer()!=null);
        System.out.println("this is vendor");
        System.out.println(user.getVendor()!=null);
        System.out.println("page - "+page);
        System.out.println("----------------------");

        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("current-user",user);
        if(page.equalsIgnoreCase("failure")) {
            httpSession.setAttribute("message","username or password doesnot match");

            return "redirect:/login";
        } else if(page.equalsIgnoreCase("register")) {
            httpSession.setAttribute("message","please Register");
            return "redirect:/login";
        }
        else if(page.equalsIgnoreCase("customer")) {

            return "redirect:/customerpage";
        }
        else if(page.equalsIgnoreCase("admin")) {
            return "redirect:/adminpage";
        }
        else if(page.equalsIgnoreCase("vendor")) {
            return "redirect:/vendorpage";
        }
        else {
             return "redirect:/dealerpage";
        }
    }
    @GetMapping("/adminpage")
    public String getAdminPage() {
        return "adminpage";
    }
    @GetMapping("/customerpage")
    public String getcustomerPage() {
        return "customerpage";
    }
    @GetMapping("/vendorpage")
    public String getVendorPage() {
        return "vendorpage";
    }
}
