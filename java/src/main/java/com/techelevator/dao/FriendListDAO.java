package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.FriendsList;

public interface FriendListDAO {
	FriendsList newRequest(FriendsList someRequest);
	void updateRequestStatus(FriendsList someRequest);
	String getRequestType(int requestTypeId);
	String getRequestStatus(int requestStatusId);
	List<FriendsList> getPendingRequestsForUser(Long userId);
	FriendsList getRequestById(Long requestId);
}
