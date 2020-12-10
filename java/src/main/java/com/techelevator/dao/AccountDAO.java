package com.techelevator.dao;

import com.techelevator.model.Account;

public interface AccountDAO {
	Account getAccountByUserId(Long userId);
	
	void updateComics(Account account);
}
