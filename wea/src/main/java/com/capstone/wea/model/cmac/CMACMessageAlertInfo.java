package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_alert_info")
public class CMACMessageAlertInfo {
    @JsonProperty("CMAC_category")
    private String category;
    @JsonProperty("CMAC_severity")
    private String severity;
    @JsonProperty("CMAC_urgency")
    private String urgency;
    @JsonProperty("CMAC_certainty")
    private String certainty;
    @JsonProperty("CMAC_expires_date_time")
    private String expires;

    @JsonProperty("CMAC_sender_name")
    private String senderName;

    @JsonProperty("CMAC_Alert_Area")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CMACMessageAlertArea> alertAreaList;

    @JsonProperty("CMAC_Alert_Text")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CMACMessageAlertText> alertTextList;

    public String getExpires() {
        return expires;
    }

    public String getSenderName() {
        return senderName;
    }
}