package com.Emarket.Service;



import com.Emarket.DAO.LoginDAOImpl;
import com.Emarket.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

     @Autowired
    private LoginDAOImpl loginDAOimpl;

    public LoginDAOImpl getLoginDAOimpl() {
        return loginDAOimpl;
    }

    public void setLoginDAOimpl(LoginDAOImpl loginDAOimpl) {
        this.loginDAOimpl = loginDAOimpl;
    }

    public String pageRedirectedLogin(User user){
        return loginDAOimpl.authenticateUsers(user);
    }
}
