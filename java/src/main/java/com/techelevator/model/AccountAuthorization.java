package com.techelevator.model;

import java.security.Principal;

import com.techelevator.dao.UserDAO;

public class AccountAuthorization {

	private Principal principal;
	private Account account;
	private UserDAO userDAO;
	
	public AccountAuthorization(Principal principal, Account account) {
		this.principal = principal;
		this.account = account;
	}
	
	public boolean isAllowedToView() {
		return getCurrentUserId(principal).equals(userId());
	}
	
	public boolean isAllowedToCreate() {
		boolean isAllowed = false;
		if(account.isPremium()) {
			isAllowed = getCurrentUserId(principal).equals(userId());
		}
		if(account.isStandard()) {
			isAllowed = getCurrentUserId(principal).equals(userId());
		}
		return isAllowed;
	}
	
	public String standardAccount() {
		return account.getAccountType();
	}
	
	public String premiumAccount() {
		return account.getAccountType();
	}
	public Long userId() {
		return account.getUserId();
	}
	
	private Long getCurrentUserId(Principal principal) {
        return userDAO.findByUsername(principal.getName()).getId();
    }
}
