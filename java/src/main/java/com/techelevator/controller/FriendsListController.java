package com.techelevator.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.FriendListDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.AuthorizationException;
import com.techelevator.model.FriendsList;
import com.techelevator.model.FriendsListAuthorization;
import com.techelevator.model.NewFriendRequestDTO;
import com.techelevator.model.Trade;
import com.techelevator.model.TradeAuthorization;
import com.techelevator.model.User;

@RestController
@CrossOrigin
@RequestMapping("/friendslist")
@PreAuthorize("isAuthenticated()")
public class FriendsListController {
	private FriendListDAO friendListDAO;
	private AccountDAO accountDAO;
	private UserDAO userDAO;
	
	public FriendsListController(FriendListDAO friendListDAO, AccountDAO accountDAO, UserDAO userDao) {
		this.friendListDAO = friendListDAO;
		this.accountDAO = accountDAO;
		this.userDAO = userDao;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public FriendsList createRequest(@Valid @RequestBody NewFriendRequestDTO friendRequestDTO, Principal principal) {
		FriendsList friendsList = buildRequestFromRequestDTO(friendRequestDTO);
		validateAuthorizationToCreate(principal, friendsList);
		friendsList = friendListDAO.newRequest(friendsList);
		if(friendsList.isApproved()) {
			
		}
		return friendsList;
	}
	
	private FriendsList buildRequestFromRequestDTO(NewFriendRequestDTO friendRequestDTO) {
		User userFrom = userDAO.getUserById(friendRequestDTO.getUserFrom());
		User userTo = userDAO.getUserById(friendRequestDTO.getUserTo());
		
		return new FriendsList(friendRequestDTO.getFriendListRequestType(),
									userFrom,
									userTo);
	}
	
	private void validateAuthorizationToView(Principal principal, FriendsList friendsList) {
		FriendsListAuthorization auth = new FriendsListAuthorization(principal, friendsList);
        if(!auth.isAllowedToView()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToCreate(Principal principal, FriendsList friendsList) {
		FriendsListAuthorization auth = new FriendsListAuthorization(principal, friendsList);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
	
	private void validateAuthorizationToUpdateStatus(Principal principal, FriendsList friendsList) {
		FriendsListAuthorization auth = new FriendsListAuthorization(principal, friendsList);
        if(!auth.isAllowedToApproveOrReject()) {
        	throw new AuthorizationException();
        }
	}
	
}


