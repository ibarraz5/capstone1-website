package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.sqlresult.MessageStatsResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class DeviceCountMapper implements RowMapper<MessageStatsResult> {
    private MessageStatsResult result;
    public DeviceCountMapper(MessageStatsResult result) {
        this.result = result;
    }
    @Override
    public MessageStatsResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        result.setDeviceCount(rs.getInt("DeviceCount"));
        return result;
    }
}