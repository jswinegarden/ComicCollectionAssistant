package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Account;

@Service
public class AccountSQLDAO implements AccountDAO{

	private JdbcTemplate jdbcTemplate;
	
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
	
	private Account mapRowToAccount(SqlRowSet rs) {
		return new Account(rs.getLong("account_id"),
				rs.getLong("user_id"),
				rs.getLong("comic_id"),
				rs.getLong("collection_id"),
				rs.getString("account_type"));
	}

}
