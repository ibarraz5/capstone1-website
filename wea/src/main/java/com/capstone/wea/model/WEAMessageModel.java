package com.capstone.wea.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_Alert_Attributes")
public class WEAMessageModel {
    @JacksonXmlProperty(isAttribute = true)
    private String xmlns;
    @JsonProperty("CMAC_protocol_version")
    private String protocolVersion;
    @JsonProperty("CMAC_sending_gateway_id")
    private String sendingGatewayId;
    @JsonProperty("CMAC_message_number")
    private String messageNumber;

    @JsonProperty("CMAC_sender")
    private String sender;

    @JsonProperty("CMAC_sent_date_time")
    private String sentDateTime;

    @JsonProperty("CMAC_status")
    private String status;

    @JsonProperty("CMAC_message_type")
    private String messageType;

    @JsonProperty("CMAC_cap_alert_uri")
    private String alertUri;

    @JsonProperty("CMAC_cap_identifier")
    private String capIdentifier;

    @JsonProperty("CMAC_cap_sent_date_time")
    private String capSentDateTime;

    @JsonProperty("CMAC_alert_info")
    private WEAMessageAlertInfo alertInfo;

    public String getMessageNumber() {
        return messageNumber;
    }

    public String getSender() {
        return sender;
    }

    public String getSentDateTime() {
        return sentDateTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getCapIdentifier() {
        return capIdentifier;
    }

    public WEAMessageAlertInfo getAlertInfo() {
        return alertInfo;
    }
}
