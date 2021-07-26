package com.Emarket.Controller;

import com.Emarket.DAO.DealerDAOImpl;
import com.Emarket.Model.Dealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/adminpage")
public class AdminController {

    @Autowired
    private DealerDAOImpl dealerDAOimpl;


    @GetMapping("/approvedealers")
    public String getApprovePage(Model model) {
        List<Dealer> unapprovedList=dealerDAOimpl.getUnverfiedList();
        model.addAttribute("unapprovedList",unapprovedList);
        return "approveDealers";
    }
    @GetMapping("/approve")
    public String approveOrReject(@RequestParam("status") String status,@RequestParam("id") int id) {
        dealerDAOimpl.approveOrReject(id,status);
        return "redirect:approvedealers";
    }

}
