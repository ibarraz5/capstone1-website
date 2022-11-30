package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.cmac.CollectedDeviceData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CMACMessageMapper implements RowMapper<CMACMessageMapper> {
    @Override
    public CMACMessageMapper mapRow(ResultSet rs, int rowNum) throws SQLException {
        CMACMessageMapper result = new CMACMessageMapper();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        /*
        result.setMessageNumber(rs.getString("CMACMessageNumber"));
        result.setUploadId(rs.getInt("UploadID"));
        result.setLocationReceived(rs.getString("LocationReceived"));
        result.setLocationDisplayed(rs.getString("LocationDisplayed"));
        result.setTimeReceived(LocalDateTime.parse(rs.getString("TimeReceived"), format));
        result.setTimeDisplayed(LocalDateTime.parse(rs.getString("TimeDisplayed"), format));
        result.setReceivedOutsideArea(rs.getBoolean("ReceivedOutsideArea"));
        result.setDisplayedOutsideArea(rs.getBoolean("DisplayedOutsideArea"));
        result.setReceivedAfterExpired(rs.getBoolean("ReceivedAfterExpired"));
        result.setDisplayedAfterExpired(rs.getBoolean("DisplayedAfterExpired"));
        */

        return result;
    }
}
