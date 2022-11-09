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

        /*
         * TODO:
         * CMAC message number must be dynamically generated because cap identifier
         * does not follow the same convention
         * Current plan: SELECT MAX(CMACMessageNumber) FROM alert_db.cmac_message;
         *
         * convert result to hex
         * add 1
         * convert back to string
         *
         * Alternatives:
         */
        cmac.setMessageNumber("00000000");
        cmac.setSender(sender.toLowerCase());
        cmac.setSentDateTime(sent);
        cmac.setStatus(status);
        cmac.setMessageType(msgType);
        //TODO: Hmm.. This is the endpoint to find this specific message. Should this lead back to us or to IPAWS?
        //if so, sendingGatewayId needs changed to match our uri as well
        cmac.setAlertUri("");
        //TODO: this must also be dynamically generated, but I'm not sure how yet
        cmac.setCapIdentifier("");
        //TODO: should this be LocalDateTime.Now()? or should cmacSentDateTime be NOW?
        cmac.setCapSentDateTime(sent);
        cmac.setAlertInfo(info.toCmac());

        return cmac;
    }
}
