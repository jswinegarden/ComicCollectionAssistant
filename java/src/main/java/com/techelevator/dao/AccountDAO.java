package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Account;
import com.techelevator.model.Comic;

public interface AccountDAO {
	List<Account> getAccountsByUserId(Long userId);
	
	Account getAccountByUserId(Long userId);
	
	void updateComics(Account account);
	
	Account addComicForStandardAccount(Comic comic, Account account);
	
	Account addComicForPremiumAccount(Comic comic, Account account);
	Long  getComicCountPerCollectionByUser (Long userId, Long collection_id);
	Long getComicCountOverallByUser (Long userId);
	
}
