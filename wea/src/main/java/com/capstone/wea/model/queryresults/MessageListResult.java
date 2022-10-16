package com.capstone.wea.model.queryresults;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageListResult {
    public static final class MessageListResultMapper implements RowMapper<MessageListResult> {
        @Override
        public MessageListResult mapRow(ResultSet rs, int rowNum) throws SQLException {
            MessageListResult numberDate = new MessageListResult();
            numberDate.setMessageNumber(rs.getString("cmac_message_number"));
            numberDate.setDate(rs.getString("cmac_sent_date_time"));

            return numberDate;
        }
    }

    @JsonProperty("CMAC_message_number")
    private String messageNumber;
    @JsonProperty("CMAC_sent_date_time")
    private String date;

    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
