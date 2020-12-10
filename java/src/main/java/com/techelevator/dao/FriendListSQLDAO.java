package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.FriendsList;

@Service
public class FriendListSQLDAO implements FriendListDAO{
	private JdbcTemplate jdbcTemplate;
	private UserDAO userDAO;
	
	private FriendListSQLDAO(JdbcTemplate jdbcTemplate, UserDAO userDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.userDAO = userDAO;
	}
	@Override
	public FriendsList newRequest(FriendsList someRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRequestStatus(FriendsList someRequest) {
		// TODO Auto-generated method stub
		
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
	public List<FriendsList> getPendingRequestsForuser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private FriendsList mapRowToFriendsList(SqlRowSet rs) {
		return new FriendsList(rs.getLong("friend_list_id"),
				rs.getString("friend_request_type_desc"),
				rs.getString("friend_request_status_desc"),
				userDAO.getUserById(rs.getLong("fromUser")),
				userDAO.getUserById(rs.getLong("toUser")));
	}
}
