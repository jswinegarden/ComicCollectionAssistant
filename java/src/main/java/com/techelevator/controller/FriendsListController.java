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
import com.techelevator.model.FriendsList;
import com.techelevator.model.NewFriendRequestDTO;

@RestController
@CrossOrigin
@RequestMapping("/friendsList")
@PreAuthorize("isAuthenticated")
public class FriendsListController {
	private FriendListDAO friendListDAO;
	private AccountDAO accountDAO;
	private UserDAO userDao;
	
	public FriendsListController(FriendListDAO friendListDAO, AccountDAO accountDAO, UserDAO userDao) {
		this.friendListDAO = friendListDAO;
		this.accountDAO = accountDAO;
		this.userDao = userDao;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public FriendsList createRequest(@Valid @RequestBody NewFriendRequestDTO friendRequestDTO, Principal princiapl) {
		FriendsList friendsList = buildRequestFromRequestDTO(friendRequestDTO);
	}
	
	
	
}


