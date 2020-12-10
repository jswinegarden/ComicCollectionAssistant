package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Collection;

public interface CollectionDAO {
	Collection getCollectionById(Long collectionId);
	List<Collection> getAllCollectionsByUserId(Long userId);
<<<<<<< HEAD
	void updateCollection(Collection collection);
=======
>>>>>>> c58dc42733b401ea46105835148176511bf09329
}
