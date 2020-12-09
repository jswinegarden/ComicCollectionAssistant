package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Trade;

@Service
public class TradeSQLDAO implements TradeDAO{
	private JdbcTemplate jdbcTemplate;
	private UserDAO userDAO;
	private TradeSQLDAO(JdbcTemplate jdbcTemplate, UserDAO userDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.userDAO = userDAO;
	}
	@Override
	public Trade newTrade(Trade someTrade) {
		String sql = "INSERT INTO trades(trade_id, trade_type_id, trade_status_id, user_from, user_to, comic_id) VALUES (?, ?, ?, ?, ?,?)";
		int newTradeId = getnextTradeId();
//		int tradeTypeId = getTradeTypeId(someTrade.getTradeType());
//		int tradeStatusId = getTradeStatusId(someTrade.getTradeStatus());
//		Trade fromUser = userDAO.getUserById(someTrade.getUserFrom().getId());
//		Trade toUser = userDAO.getUserById(someTrade.getUserTo());
//		
//		jdbcTemplate.update(sql, newTradeId, tradeTypeId, tradeStatusId, fromUser.getUserId(), toUser.getUserId(), someTrade.getComicId());
//		return getTradeById(newTradeId);
		return null;
	}

	@Override
	public void updateTradeStatus(Trade someTrade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Trade> getPendingTradesForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	private int getnextTradeId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_trade_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new trade");
		}
	}
	
	private int getTransferTypeId(String tradeType) {
    	String sql = "SELECT trade_type_id FROM trade_types WHERE trade_type_desc = ?";
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tradeType);
    	if(results.next()) {
    		return results.getInt(1);
    	} else {
    		throw new RuntimeException("Unable to lookup transferType "+tradeType);
    	}
    }
    
    private int getTransferStatusId(String tradeStatus) {
    	String sql = "SELECT trade_status_id FROM trade_statuses WHERE trade_status_desc = ?";
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tradeStatus);
    	if(results.next()) {
    		return results.getInt(1);
    	} else {
    		throw new RuntimeException("Unable to lookup transferStatus "+tradeStatus);
    	}
    }
	
	private Trade mapRowToTrade(SqlRowSet rs) {
		return new Trade(rs.getInt("trade_id"),
				rs.getInt("trade_type_id"),
				rs.getInt("trade_status_id"),
				rs.getInt("user_from"),
				rs.getInt("user_to"),
				rs.getInt("comic_id"));
	}

}
