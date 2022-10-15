package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.LocalDateTime;

@JacksonXmlRootElement(localName = "CMAC_user_data")
public class CollectedUserData {
    @JsonProperty("CMAC_user_time_received")
    private LocalDateTime timeReceived;
    @JsonProperty("CMAC_user_time_displayed")
    private LocalDateTime timeDisplayed;
    @JsonProperty("CMAC_user_location_received")
    private String locationReceived;
    @JsonProperty("CMAC_user_location_displayed")
    private String locationDisplayed;
    @JsonProperty("CMAC_message_number")
    private String messageNumber;
    @JsonProperty("CMAC_cap_identifier")
    private String capIdentifier;

    //identifier for upload confirmation testing
    private int id;
    private static int next_id = 0;

    public CollectedUserData() {
        id = next_id++;
    }

    public int getId() {
        return id;
    }
}
