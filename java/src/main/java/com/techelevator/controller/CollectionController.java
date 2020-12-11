package com.techelevator.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.CollectionDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.AuthorizationException;
import com.techelevator.model.Collection;
import com.techelevator.model.CollectionAuthorization;
import com.techelevator.model.NewCollectionDTO;
import com.techelevator.model.Trade;
import com.techelevator.model.TradeAuthorization;

@RestController
@CrossOrigin
@RequestMapping("/collections")
public class CollectionController {
	private AccountDAO accountDAO;
	private CollectionDAO collectionDAO;
	private UserDAO userDAO;

	
	public CollectionController(CollectionDAO collectionDAO, AccountDAO accountDAO, UserDAO userDAO) {
		this.collectionDAO = collectionDAO;
		this.accountDAO = accountDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Collection getCollection (@PathVariable Long id) {
		Collection collection = collectionDAO.getCollectionById(id);
		return collection;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Collection createCollection(@Valid @RequestBody NewCollectionDTO collectionDTO, Principal principal) {
		Collection collection = buildCollectionFromCollectionDTO(collectionDTO);
		collection = collectionDAO.newCollection(collection);
		return collection;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Collection deleteCollection(@PathVariable Long id) {
		Collection collection = collectionDAO.getCollectionById(id);
		return collection;
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Collection updateCollectionName(@PathVariable Long id) {
		Collection collection = collectionDAO.getCollectionById(id);
		return collection;
	}
	
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
//	public Collection updateCollectionDescription(@PathVariable Long id) {
//		Collection collection = collectionDAO.getCollectionById(id);
//		return collection;
//	}
	
	
	private Collection buildCollectionFromCollectionDTO(NewCollectionDTO collectionDTO) {
		return new Collection (collectionDTO.getCollectionId(),
				collectionDTO.getCollectionName(),
				collectionDTO.getCollectionDesc());
	}
	
	private void validateAuthorizationToCreate(Principal principal, Collection collection) {
		CollectionAuthorization auth = new CollectionAuthorization(principal, collection);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
}