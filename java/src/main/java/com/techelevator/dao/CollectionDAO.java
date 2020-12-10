package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Collection;

public interface CollectionDAO {
	Collection getCollectionById(Long collectionId);
	List<Collection> getAllCollectionsByUserId(Long userId);

}
