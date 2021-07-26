package com.Emarket.DAO;

import com.Emarket.Model.Dealer;

import java.util.List;
import java.util.Map;

public interface DealerDAO {
    public void dealerRegistration(Dealer dealer);
    public List<Dealer> getUnverfiedList();
    public void approveOrReject(int id,String status);
}
