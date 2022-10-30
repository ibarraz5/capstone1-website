package com.capstone.wea.model.sqlresult;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageListResult {
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
