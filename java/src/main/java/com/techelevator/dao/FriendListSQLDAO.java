package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.FriendsList;

public class FriendListSQLDAO implements FriendListDAO{

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
		return new FriendsList(rs.getInt("order_added_id"),
				rs.getInt("friend_request_type_id"),
				rs.getInt("friend_request_status_id"),
				rs.getInt("user_from"),
				rs.getInt("user_to"));
	}
}
