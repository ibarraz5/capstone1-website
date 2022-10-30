package com.capstone.wea.model.sqlresult.mappers;

import com.capstone.wea.model.sqlresult.MessageListResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageListResultMapper implements RowMapper<MessageListResult> {
    @Override
    public MessageListResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        MessageListResult numberDate = new MessageListResult();
        numberDate.setMessageNumber(rs.getString("CMACMessageNumber"));
        numberDate.setDate(rs.getString("CMACDateTime"));

        return numberDate;
    }
}