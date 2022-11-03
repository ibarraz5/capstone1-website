package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_Alert_Attributes")
public class CMACMessageModel {
    @JacksonXmlProperty(isAttribute = true)
    private String xmlns = "cmac:2.0";
    @JsonProperty("CMAC_protocol_version")
    private String protocolVersion = "2.0";
    @JsonProperty("CMAC_sending_gateway_id")
    private String sendingGatewayId = "http://wea_alert_gateway.gov";
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
    private CMACMessageAlertInfo alertInfo;

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public void setSendingGatewayId(String sendingGatewayId) {
        this.sendingGatewayId = sendingGatewayId;
    }

    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSentDateTime(String sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setAlertUri(String alertUri) {
        this.alertUri = alertUri;
    }

    public void setCapIdentifier(String capIdentifier) {
        this.capIdentifier = capIdentifier;
    }

    public void setCapSentDateTime(String capSentDateTime) {
        this.capSentDateTime = capSentDateTime;
    }

    public void setAlertInfo(CMACMessageAlertInfo alertInfo) {
        this.alertInfo = alertInfo;
    }
}
