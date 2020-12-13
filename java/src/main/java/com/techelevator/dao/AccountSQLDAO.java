package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Account;
import com.techelevator.model.Comic;
import com.techelevator.model.User;

@Service
public class AccountSQLDAO implements AccountDAO{

	private JdbcTemplate jdbcTemplate;
	
	private static final String SQL_SELECT_COUNT_REQUEST = "SELECT COUNT comic_id FROM accounts WHERE collection_id = ?";
	private static final String SQL_SELECT_ACCOUNT = "SELECT ";
	public AccountSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Account getAccountByUserId(Long userId) {
		Account account = null;
		String sql = "SELECT account_id, user_id, comic_id FROM accounts WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while(results.next()) {
			account = mapRowToAccount(results);
		}
		return account;
	}

	@Override
	public void updateComics(Account account) {
		String sql = "UPDATE accounts SET comic_id = ? WHERE account_id = ?";
		jdbcTemplate.update(sql, account.getComicId(), account.getAccountId());
		
	}
	
	@Override
	public Account addComicForStandardAccount(Comic comic, Account account) {
		String sql = "INSERT INTO accounts (account_id, user_id, comic_id, collection_id, account_type) VALUES (?, ?, ?, ?, ?)";
		Long newAccountId = getNextAccountId();
		Long userId = account.getUserId();
		Long comicId = comic.getComicId();
		Long collectionId = account.getCollectionId();
		String accountType = account.getAccountType();
		int count = jdbcTemplate.update(SQL_SELECT_COUNT_REQUEST, collectionId);
		if(count < 100) {
			jdbcTemplate.update(sql, newAccountId, userId, comicId, collectionId, accountType);
		}
		return getAccountById(newAccountId);
	}
	
	@Override
	public Account addComicForPremiumAccount(Comic comic, Account account) {
		String sql = "INSERT INTO accounts (account_id, user_id, comic_id, collection_id, account_type) VALUES (?, ?, ?, ?, ?)";
		Long newAccountId = getNextAccountId();
		Long userId = account.getUserId();
		Long comicId = comic.getComicId();
		Long collectionId = account.getCollectionId();
		String accountType = account.getAccountType();
		
		jdbcTemplate.update(sql, newAccountId, userId, comicId, collectionId, accountType);
		return getAccountById(newAccountId);
	}
	
	private Account getAccountById(Long accountId) {
		Account account = null;
		String sql = "SELECT * FROM accounts WHERE account_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
		if(results.next()) {
			account = mapRowToAccount(results);
		}
		return account;
	}
	private Long getNextAccountId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval(seq_account_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}  else {
			throw new RuntimeException("Something went wrong while getting an id for a new account");
		}
	}
	
	private Account mapRowToAccount(SqlRowSet rs) {
		return new Account(rs.getLong("account_id"),
				rs.getLong("user_id"),
				rs.getLong("comic_id"),
				rs.getLong("collection_id"),
				rs.getString("account_type"));
	}

}
