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
	private static final String SQL_SELECT_ACCOUNT = "SELECT a.account_id, a.comic_id, a.collection_id, at.account_type_desc, cc.comic_condition_desc, cts.comic_tradeable_status_desc, " +
														"FROM accounts a " +
														"INNER JOIN account_types at ON a.account_type_id = at.account_type_id " +
														"INNER JOIN comic_conditions cc ON a.comic_condition_id = cc.comic_condition_id " +
														"INNER JOIN comic_tradeable_statuses cts ON a.comic_tradeable_status_id = cts.comic_tradeable_status_id ";
	public AccountSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Account getAccountsByUserId(Long userId) {
		Account account = null;
		String sql = "SELECT * FROM accounts WHERE user_id = ?";
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
		Long newAccountId = getNextAccountId();		//Change sql for addComic methods to reflect table
		Long userId = account.getUserId();
		Long comicId = comic.getComicId();
		Long collectionId = account.getCollectionId();
		Long accountType = account.getAccountTypeId();
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
		Long accountType = account.getAccountTypeId();
		
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
				rs.getLong("comic_condition_id"),
				rs.getLong("comic_tradeable_status_id"),
				rs.getLong("collection_id"),
				rs.getLong("account_type_id"),
				rs.getString("comic_condition"),
				rs.getString("comic_tradeable_status"),
				rs.getString("account_type"))
				;
	}

}
