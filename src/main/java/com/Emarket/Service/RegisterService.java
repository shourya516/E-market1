package com.Emarket.Service;

import com.Emarket.DAO.CustomerDAOImpl;
import com.Emarket.DAO.DealerDAOImpl;
import com.Emarket.DAO.VendorDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private CustomerDAOImpl customerDAOimpl;

    @Autowired
    private DealerDAOImpl dealerDAOimpl;

    @Autowired
    private VendorDAOImpl vendorDAOimpl;


    public CustomerDAOImpl getCustomerDAOimpl() {
        return customerDAOimpl;
    }

    public void setCustomerDAOimpl(CustomerDAOImpl customerDAOimpl) {
        this.customerDAOimpl = customerDAOimpl;
    }

    public DealerDAOImpl getDealerDAOimpl() {
        return dealerDAOimpl;
    }

    public void setDealerDAOimpl(DealerDAOImpl dealerDAOimpl) {
        this.dealerDAOimpl = dealerDAOimpl;
    }

    public VendorDAOImpl getVendorDAOimpl() {
        return vendorDAOimpl;
    }

    public void setVendorDAOimpl(VendorDAOImpl vendorDAOimpl) {
        this.vendorDAOimpl = vendorDAOimpl;
    }
}
