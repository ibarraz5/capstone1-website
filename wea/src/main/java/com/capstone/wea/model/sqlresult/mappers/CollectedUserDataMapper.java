package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.cmac.CollectedUserData;
import com.capstone.wea.model.sqlresult.MessageStatsResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CollectedUserDataMapper implements RowMapper<CollectedUserData> {
    @Override
    public CollectedUserData mapRow(ResultSet rs, int rowNum) throws SQLException {
        CollectedUserData result = new CollectedUserData();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        result.setMessageNumber(rs.getString("CMACMessageNumber"));
        result.setId(rs.getInt("InternalDeviceID"));
        result.setLocationReceived(rs.getString("LocationReceived"));
        result.setLocationDisplayed(rs.getString("LocationDisplayed"));
        result.setTimeReceived(LocalDateTime.parse(rs.getString("TimeReceived"), format));
        result.setTimeDisplayed(LocalDateTime.parse(rs.getString("TimeDisplayed"), format));

        return result;
    }
}
