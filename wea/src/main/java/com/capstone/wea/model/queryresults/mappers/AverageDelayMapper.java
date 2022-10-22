package com.capstone.wea.model.queryresults.mappers;

import com.capstone.wea.model.queryresults.MessageStatsResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AverageDelayMapper implements RowMapper<MessageStatsResult> {
    private MessageStatsResult result;
    public AverageDelayMapper(MessageStatsResult result) {
        this.result = result;
    }
    @Override
    public MessageStatsResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.setAvgDelay(rs.getTime("AvgDelay"));
        return result;
    }
}
