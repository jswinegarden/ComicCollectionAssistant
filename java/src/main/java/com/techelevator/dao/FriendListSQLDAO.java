package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.FriendsList;
import com.techelevator.model.Account;

@Service
public class FriendListSQLDAO implements FriendListDAO{
	private JdbcTemplate jdbcTemplate;
	private UserDAO userDAO;
	private AccountDAO accountDAO;
	
	private static final String SQL_SELECT_REQUEST = "SELECT fl.friends_list_id, frt.friend_request_type_desc, frs.friend_request_status_desc, " +
										"aFrom.account_id as fromAcct, aFrom.user_id as fromUser, " +
										"FROM friends_list fl " +
										"INNER JOIN friend_request_types frt ON fl.friend_request_type_id = frt.friend_request_type_id " +
										"INNER JOIN friend_request_statuses frs ON fl.friend_request_status_id = frs.friend_request_status_id " +
										"INNER JOIN accounts aFrom on user_from = aFrom.account_id " +
										"INNER JOIN accounts aTo on user_to = aTo.account_id ";
	
	private static final String SQL_SELECT_FRIENDS_LIST = "SELECT friend_list_id,";
	
	private FriendListSQLDAO(JdbcTemplate jdbcTemplate, UserDAO userDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.userDAO = userDAO;
	}
	
	
	@Override
	public FriendsList newRequest(FriendsList someRequest) {
		String sql = "INSERT INTO friends_list(friend_list_id, friend_request_type_id, friend_request_status_id, user_from, user_to) VALUES (?, ?, ?, ?, ?, ?)";
		Long newRequestId = getNextRequestId();
		Long requestTypeId = getRequestTypeId(someRequest.getRequestType());
		Long requestStatusId = getRequestStatusId(someRequest.getRequestStatus());
		Account fromAccount = accountDAO.getAccountsByUserId(someRequest.getUserFrom().getId());
		Account toAccount = accountDAO.getAccountsByUserId(someRequest.getUserTo().getId());
		
		jdbcTemplate.update(sql, newRequestId, requestTypeId, requestStatusId, fromAccount.getAccountId(), toAccount.getAccountId());
		return getRequestById(newRequestId);
	}

	@Override
	public void updateRequestStatus(FriendsList someRequest) {
		String sql = "UPDATE friends_list SET friend_request_status_id = ? WHERE friend_list_id = ?";
		Long requestStatusId = getRequestStatusId(someRequest.getRequestStatus());
		jdbcTemplate.update(sql, requestStatusId, someRequest.getRequestId());
	}

	@Override
	public String getRequestType(int requestTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestStatus(int requestStatusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FriendsList> getPendingRequestsForUser(Long userId) {
		String sql = SQL_SELECT_REQUEST + "WHERE friend_request_status_id = 1 AND account_from IN (SELECT account_id FROM accounts WHERE user_id = ?)";
		List<FriendsList> friendsLists = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while(results.next()) {
			FriendsList friendsList = mapRowToFriendsList(results);
			friendsLists.add(friendsList);
		}
		return friendsLists;
	}
	
	@Override
	public FriendsList getRequestById(Long requestId) {
		FriendsList friendsList = null;
		String sql = SQL_SELECT_REQUEST + "WHERE friend_list_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, requestId);
		if(results.next()) {
			friendsList = mapRowToFriendsList(results);
		}
		return friendsList;
	}
	
	private Long getNextRequestId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_friends_list_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new request");
		}
	}
	
	private Long getRequestTypeId(String friendRequestType) {
		String sql = "SELECT friend_request_type_id FROM friend_request_types WHERE friend_request_type_desc = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, friendRequestType);
		if(results.next()) {
			return results.getLong(1);
		} else {
			throw new RuntimeException("Unable to lookup friend request type " + friendRequestType);
		}
	}
	
	private Long getRequestStatusId(String friendRequestStatus) {
		String sql = "SELECT friend_request_status_id FROM friend_request_statuses WHERE friend_request_status_desc = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, friendRequestStatus);
		if(results.next()) {
			return results.getLong(1);
		} else {
			throw new RuntimeException("Unable to lookup friend request status " + friendRequestStatus);
		}
	}
	private FriendsList mapRowToFriendsList(SqlRowSet rs) {
		return new FriendsList(rs.getLong("friend_list_id"),
				rs.getString("friend_request_type_desc"),
				rs.getString("friend_request_status_desc"),
				userDAO.getUserById(rs.getLong("fromUser")),
				userDAO.getUserById(rs.getLong("toUser")));
	}
}
