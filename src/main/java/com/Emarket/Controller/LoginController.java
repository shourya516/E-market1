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
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes({"vendor","customer","dealer","admin"})
public class LoginController {


    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public String authenticateUser(@ModelAttribute("user") User user, Model model,HttpServletRequest request) {
        String page=authenticationService.pageRedirectedLogin(user);

        model.addAttribute("vendor",user.getVendor());
        model.addAttribute("customer",user.getCustomer());
        model.addAttribute("admin",user.getAdmin());
        System.out.print("this is customer - ");
        System.out.println(user.getCustomer()!=null);
        System.out.print("this is admin - ");
        System.out.println(user.getAdmin()!=null);
        System.out.print("this is dealer - ");
        System.out.println(user.getDealer()!=null);
        System.out.print("this is vendor - ");
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
            model.addAttribute("customer",user.getCustomer());
            return "redirect:/customerpage";
        }
        else if(page.equalsIgnoreCase("admin")) {
            model.addAttribute("admin",user.getAdmin());
            return "redirect:/adminpage";
        }
        else if(page.equalsIgnoreCase("vendor")) {
            model.addAttribute("vendor",user.getVendor());
            return "redirect:/vendorpage";
        }
        else {
            model.addAttribute("dealer",user.getDealer());
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
