package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.sqlresult.MessageStatsResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class DateDeviceCountMapper implements RowMapper<MessageStatsResult> {
    private MessageStatsResult result;
    public DateDeviceCountMapper(MessageStatsResult result) {
        this.result = result;
    }
    @Override
    public MessageStatsResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.setDate(rs.getString("CMACDateTime"));
        result.setDeviceCount(rs.getInt("DeviceCount"));
        return result;
    }
}