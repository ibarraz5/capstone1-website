package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.sqlresult.MessageStatsResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ReceivedDisplayedCountMapper implements RowMapper<MessageStatsResult> {
    private MessageStatsResult result;
    public ReceivedDisplayedCountMapper(MessageStatsResult result) {
        this.result = result;
    }
    @Override
    public MessageStatsResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.setReceivedInsideCount(rs.getInt("ReceivedInside"));
        result.setDisplayedInsideCount(rs.getInt("DisplayedInside"));
        return result;
    }
}