package com.capstone.wea.model.queryresults.mappers;

import com.capstone.wea.model.queryresults.MessageStatsResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LongestTimeMapper implements RowMapper<MessageStatsResult> {
    private MessageStatsResult result;
    public LongestTimeMapper(MessageStatsResult result) {
        this.result = result;
    }
    @Override
    public MessageStatsResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.setLongTime(rs.getTime("LongTime"));
        return result;
    }
}
