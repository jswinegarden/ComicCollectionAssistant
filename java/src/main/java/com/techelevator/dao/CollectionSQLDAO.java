package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Collection;

@Service
public class CollectionSQLDAO implements CollectionDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	
	public CollectionSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
	@Override
	public Collection getCollectionById(Long collectionId) {
		Collection collection = null;
		String sql = "SELECT collection_name, collection_desc FROM collections WHERE collection_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
		while(results.next()) {
			collection = mapRowToCollection(results);
		}
		return collection;
	}

	@Override
	public List<Collection> getAllCollectionsByUserId(Long userId) {
		List<Collection> collection = new ArrayList<>();
		String sql = "SELECT collection_id, collection_name, collection_desc FROM collections "
				+ "INNER JOIN accounts USING (collection_id)"
				+ " INNER JOIN users USING (user_id) "
				+ "WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while(results.next()) {
			Collection collections = mapRowToCollection(results);
			collection.add(collections);
			
		}
		return collection;
	}


	
	private Collection mapRowToCollection (SqlRowSet rs) {
		return new Collection(rs.getLong("collection_id"),
				rs.getString("collection_name"), 
				rs.getString("collection_desc")); 
		
	}

}
