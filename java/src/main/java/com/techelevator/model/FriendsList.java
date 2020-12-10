package com.techelevator.model;

public class FriendsList {
	private Long requestId;
	private Long userFrom;
	private Long userTo;
	private Long requestStatusId;
	private Long requestTypeId;
	
	public FriendsList(Long requestId, Long requestStatusId, Long requestTypeId, Long userFrom, Long userTo) {
		this.requestId = requestId;
		this.requestStatusId = requestStatusId;
		this.requestTypeId = requestTypeId;
		this.userFrom = userFrom;
		this.userTo = userTo;
	}
	public FriendsList() {}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(Long userFrom) {
		this.userFrom = userFrom;
	}
	public Long getUserTo() {
		return userTo;
	}
	public void setUserTo(Long userTo) {
		this.userTo = userTo;
	}
	public Long getRequestStatus() {
		return requestStatusId;
	}
	public void setRequestStatus(Long requestStatusId) {
		this.requestStatusId = requestStatusId;
	}
	public Long getRequestType() {
		return requestTypeId;
	}
	public void setRequestType(Long requestTypeId) {
		this.requestTypeId = requestTypeId;
	}
	
	
}
