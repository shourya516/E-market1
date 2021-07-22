package com.Emarket.Controller;

import com.Emarket.Model.Customer;
import com.Emarket.Model.Dealer;
import com.Emarket.Model.Vendor;
import com.Emarket.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResgistrationController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/customerRegistration")
    public String registerCustomer(@ModelAttribute("customer") Customer customer) {
        registerService.getCustomerDAOimpl().insertCustomerDetails(customer);
        System.out.println(customer);
        return "homepage";
    }
    @PostMapping("/dealerRegistration")
    public String registerDealer(@ModelAttribute("dealer") Dealer dealer){
        registerService.getDealerDAOimpl().dealerRegistration(dealer);;
        return "homepage";
    }
    @PostMapping("/vendorRegistration")
    public String vendorRegister(@ModelAttribute("vendor") Vendor vendor) {
        registerService.getVendorDAOimpl().registerVendor(vendor);
        return "homepage";
    }
}
