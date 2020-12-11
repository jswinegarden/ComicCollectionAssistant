package com.techelevator.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.TradeDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Trade;



@RestController
@CrossOrigin
@RequestMapping("/account")
@PreAuthorize("isAuthenticated()")
public class AccountController {
	private AccountDAO accountDAO;
    private UserDAO userDAO;
    private TradeDAO tradeDAO;

    public AccountController(AccountDAO accountDAO, UserDAO userDAO, TradeDAO tradeDAO) {
        this.accountDAO = accountDAO;
        this.userDAO = userDAO;
        this.tradeDAO = tradeDAO;
    }

    @RequestMapping( value = "/comics", method = RequestMethod.GET)
    public Long getComic(Principal principal) throws UsernameNotFoundException {
        Long userId = getCurrentUserId(principal);
        return accountDAO.getAccountByUserId(userId).getComicId();
    }

    @RequestMapping(value = "/trades", method = RequestMethod.GET)
    public List<Trade> getTrades(Principal principal) {
        return tradeDAO.getTradesForUser(getCurrentUserId(principal));
    }

    
    private Long getCurrentUserId(Principal principal) {
        return userDAO.findByUsername(principal.getName()).getId();
    }
}
