package com.capstone.wea.model.cap;

import com.capstone.wea.model.cmac.CMACMessageModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "alert")
public class CAPMessageModel {
    @JacksonXmlProperty(isAttribute = true)
    private String xmlns = "urn:oasis:names:tc:emergency:cap:1.2";
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("sent")
    private String sent;
    @JsonProperty("status")
    private String status;
    @JsonProperty("msgType")
    private String msgType;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("info")
    private CAPInfoModel info;

    @JsonIgnoreProperties
    public CMACMessageModel toCmac() {
        CMACMessageModel cmac = new CMACMessageModel();

        cmac.setSender(sender.toLowerCase());
        cmac.setSentDateTime(sent);
        cmac.setStatus(status);
        cmac.setMessageType(msgType);
        //TODO: Hmm.. This is the endpoint to find this specific message. Should this lead back to us or to IPAWS?
        //if so, sendingGatewayId needs changed to match our uri as well
        cmac.setAlertUri("");
        cmac.setCapIdentifier(identifier);
        cmac.setCapSentDateTime(sent);
        cmac.setAlertInfo(info.toCmac());

        return cmac;
    }
}
