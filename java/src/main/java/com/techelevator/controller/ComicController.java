package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.ComicDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Comic;

@RestController
@CrossOrigin
@RequestMapping("/comics")
public class ComicController {
	private ComicDAO comicDAO;
	private AccountDAO accountDAO;
	private UserDAO userDAO;

	public ComicController(ComicDAO comicDAO, AccountDAO accountDAO, UserDAO userDAO) {
		this.comicDAO = comicDAO;
		this.accountDAO = accountDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public Comic getComic(@PathVariable Long id) {
		Comic comic = comicDAO.getComicById(id);
		return comic;
	}
	

}
