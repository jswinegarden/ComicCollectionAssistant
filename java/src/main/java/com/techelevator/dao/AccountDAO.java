package com.techelevator.dao;

import com.techelevator.model.Account;
import com.techelevator.model.Comic;

public interface AccountDAO {
	Account getAccountByUserId(Long userId);
	
	void updateComics(Account account);
	
	Account addComicForStandardAccount(Comic comic, Account account);
	
	Account addComicForPremiumAccount(Comic comic, Account account);
}
