package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Collection;

public interface CollectionDAO {
	Collection getCollectionById(int collectionId);
	List<Collection> getAllCollectionsByUserId(int userId);
	void updateCollection(int userId);
}
