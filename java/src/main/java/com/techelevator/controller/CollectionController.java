package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value="", method = RequestMethod.GET)
	public List <Collection> getAllCollectionsByUser(Principal principal) {
		List <Collection> allCollections = collectionDAO.getAllCollectionsByUserId(getCurrentUserId(principal));
		return allCollections;
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
	public Collection updateCollectionDetails(@Valid @RequestBody NewCollectionDTO newCollectionDTO, @PathVariable Long id) {		
		Collection collection = collectionDAO.getCollectionById(id);
		if(newCollectionDTO.getCollectionName() != null && newCollectionDTO.getCollectionName().length() > 0 ) {
			collection.setCollectionName(newCollectionDTO.getCollectionName());
			collectionDAO.updateCollectionName(collection);
			//return collection;
		}
		if (newCollectionDTO.getCollectionDesc() != null ) {
			collection.setCollectionDescription(newCollectionDTO.getCollectionDesc());
			collectionDAO.updateCollectionDesc(collection);
			//return collection;
		}
		collection.setFavoriteStatusId(newCollectionDTO.getFavorite_status_id());
		collection.setCollectionVisbilityId(newCollectionDTO.getCollection_visibility_id());
		return collection;
		
	}
	

	
	
	private Collection buildCollectionFromCollectionDTO(NewCollectionDTO collectionDTO) {
		return new Collection (collectionDTO.getCollectionId(),
				collectionDTO.getCollectionName(),
				collectionDTO.getCollectionDesc(),
				collectionDTO.getFavorite_status_id(),
				collectionDTO.getCollection_visibility_id());
	}
	
	private void validateAuthorizationToCreate(Principal principal, Collection collection) {
		CollectionAuthorization auth = new CollectionAuthorization(principal, collection);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
	
	 private Long getCurrentUserId(Principal principal) {
	        return userDAO.findByUsername(principal.getName()).getId();
	    }
}