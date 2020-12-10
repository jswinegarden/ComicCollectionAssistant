package com.techelevator.model;

import java.util.Objects;


public class Account {
	private Long accountId;
	private Long userId;
	private Long comicId;
	private Long collectionId;
	private String accountType;
	
	public Account (Long accountId, Long userId, Long comicId, Long collectionId, String accountType) {
		this.accountId = accountId;
		this.userId = userId;
		this.comicId = comicId;
		this.collectionId = collectionId;
		this.accountType = accountType;
	}
	public Account () {}
	public Long getAccountId() {
		return accountId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public Long getCollectionId() {
		return collectionId;
	}
	
	
	public void trade(Account accountTo, Long comicToTrade) {
		if(this.comicId.compareTo(comicToTrade) == 0) {
			this.comicId = 0L;
    		accountTo.comicId = comicToTrade;
    	} else {
    		throw new InvalidComicException(comicToTrade+" could not be found!");
    	}
		
	}
	
	

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                userId == account.userId &&
                comicId.equals(account.comicId)&&
                collectionId.equals(account.collectionId)&&
                accountType.equals(account.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userId, comicId, collectionId, accountType);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", comicId=" + comicId +
                ", collectionId=" + collectionId +
                ", accountType=" + accountType +
                '}';
    }
	
	
	
}
