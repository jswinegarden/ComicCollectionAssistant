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
	
	List<Account>  getComicCountPerCollectionByUser (Long userId, Long collectionId);
	
	List<Account> getComicCountOverallByUser (Long userId);
	
	List<Account> getCollectionCountOverallByUser (Long userId);
	
	List<Account> getMintComicCountByUser (Long userId);
	
	List<Account> getFairComicCountByUser (Long userId);
	
	List<Account> getPoorComicCountByUser (Long userId);
	
	List <Account> getComicsByCollection(Long userId, Long collectionId);
	
	Long getComicIdByAccountId(Long accountId);
	
}
