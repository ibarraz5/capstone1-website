package com.capstone.wea.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.LocalDateTime;

@JacksonXmlRootElement(localName = "CMAC_user_data")
public class CollectedUserData {
    @JsonProperty("CMAC_user_time_received")
    private LocalDateTime received;
    @JsonProperty("CMAC_user_location")
    private String location;
}
