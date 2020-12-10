package com.techelevator.model;

import javax.validation.constraints.AssertTrue;

public class NewFriendRequestDTO {

	private User userFrom;
	private User userTo;
	private String friendListRequestType;
	
	public User getUserFrom() {
		return userFrom;
	}
	
	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}
	
	public User getUserTo() {
		return userTo;
	}
	
	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}
	
	public String getFriendListRequestType() {
		return friendListRequestType;
	}
	
	public void setFriendListRequestType(String friendListRequestType) {
		this.friendListRequestType = friendListRequestType;
	}

	@AssertTrue
	public boolean isValidFriendListRequestType() {
		return FriendsList.FRIEND_LIST_REQUEST_TYPE_REQUEST.equals(this.friendListRequestType) || FriendsList.FRIEND_LIST_REQUEST_TYPE_SEND.equals(this.friendListRequestType);
	}
	
	
	
}
