package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_Alert_Text")
public class WEAMessageAlertText {
    @JsonProperty("CMAC_text_language")
    private String language;
    @JsonProperty("CMAC_short_text_alert_message_length")
    private String shortLength;
    @JsonProperty("CMAC_short_text_alert_message")
    private String shortMessage;
    @JsonProperty("CMAC_long_text_alert_message_length")
    private String longLength;
    @JsonProperty("CMAC_long_text_alert_message")
    private String longMessage;
}
