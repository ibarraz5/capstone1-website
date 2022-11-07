package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_Alert_Text")
public class CMACMessageAlertText {
    @JsonProperty("CMAC_text_language")
    private String language;
    @JsonProperty("CMAC_short_text_alert_message_length")
    private int shortLength;
    @JsonProperty("CMAC_short_text_alert_message")
    private String shortMessage;
    @JsonProperty("CMAC_long_text_alert_message_length")
    private int longLength;
    @JsonProperty("CMAC_long_text_alert_message")
    private String longMessage;

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setShortLength(int shortLength) {
        this.shortLength = shortLength;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public void setLongLength(int longLength) {
        this.longLength = longLength;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }
}
