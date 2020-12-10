package com.techelevator.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.TradeDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Account;
import com.techelevator.model.AuthorizationException;
import com.techelevator.model.NewTradeDTO;
import com.techelevator.model.Trade;
import com.techelevator.model.TradeAuthorization;
import com.techelevator.model.User;


@RestController
@CrossOrigin
@RequestMapping("/trades")
@PreAuthorize("isAuthenticated()")
public class TradeController {
	private TradeDAO tradeDAO;
	private AccountDAO accountDAO;
	private UserDAO userDAO;
	
	public TradeController(TradeDAO transferDAO, AccountDAO accountDAO, UserDAO userDAO) {
        this.tradeDAO = transferDAO;
        this.accountDAO = accountDAO;
        this.userDAO = userDAO;
    }
	
	@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Trade createTransfer(@Valid @RequestBody NewTradeDTO tradeDTO, Principal principal) {
    	Trade trade = buildTradeFromTradeDTO(tradeDTO);
    	validateAuthorizationToCreate(principal, trade);
    	trade = tradeDAO.newTrade(trade);
    	if(trade.isApproved()) {
    		transferComicsBetweenAccounts(trade);
    	}
    	return trade;
    }
	
	private Trade buildTradeFromTradeDTO(NewTradeDTO tradeDTO) {
		User userFrom = userDAO.getUserById(tradeDTO.getUserFrom());
    	User userTo = userDAO.getUserById(tradeDTO.getUserTo());
    	
    	return new Trade(tradeDTO.getTradeType(),
						    userFrom,
						    userTo,
						    tradeDTO.getComicId());
	}
	
	private void transferComicsBetweenAccounts(Trade trade) {
		Account accountFrom = accountDAO.getAccountByUserId(trade.getUserFrom().getId());
		Account accountTo = accountDAO.getAccountByUserId(trade.getUserTo().getId());
		accountFrom.trade(accountTo, trade.getComicId());
		accountDAO.updateComics(accountFrom);
		accountDAO.updateComics(accountTo);
	}
	
	private void validateAuthorizationToView(Principal principal, Trade trade) {
		TradeAuthorization auth = new TradeAuthorization(principal, trade);
        if(!auth.isAllowedToView()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToCreate(Principal principal, Trade trade) {
		TradeAuthorization auth = new TradeAuthorization(principal, trade);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToUpdateStatus(Principal principal, Trade trade) {
		TradeAuthorization auth = new TradeAuthorization(principal, trade);
        if(!auth.isAllowedToApproveOrReject()) {
        	throw new AuthorizationException();
        }
	}
	
	
}
