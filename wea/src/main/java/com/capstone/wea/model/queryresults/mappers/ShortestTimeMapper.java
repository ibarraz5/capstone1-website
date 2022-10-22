package com.capstone.wea.model.queryresults.mappers;

import com.capstone.wea.model.queryresults.MessageStatsResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShortestTimeMapper implements RowMapper<MessageStatsResult> {
    private MessageStatsResult result;
    public ShortestTimeMapper(MessageStatsResult result) {
        this.result = result;
    }
    @Override
    public MessageStatsResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.setShortTime(rs.getTime("ShortTime"));
        return result;
    }
}
