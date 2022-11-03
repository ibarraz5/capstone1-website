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
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CAPInfoModel> info;

    public String getXmlns() {
        return xmlns;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getSender() {
        return sender;
    }

    public String getSent() {
        return sent;
    }

    public String getStatus() {
        return status;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getScope() {
        return scope;
    }

    public List<CAPInfoModel> getInfo() {
        return info;
    }

    @JsonIgnoreProperties
    public CMACMessageModel toCmac() {
        CMACMessageModel cmac = new CMACMessageModel();

        /**
         * TODO:
         * CMAC message number must be dynamically generated because cap identifier
         * does not follow the same convention
         * Current plan: SLECT MAX(CMACMessageNumber) FROM alert_db.cmac_message;
         *
         * convert result to hex
         * add 1
         * convert back to string
         */
        cmac.setMessageNumber("");
        cmac.setSender(getSender());
        cmac.setSentDateTime(getSent());
        cmac.setStatus(getStatus());
        cmac.setMessageType(getMsgType());
        //TODO: Hmm.. This is the endpoint to find this specific message. Should this lead back to us?
        //if so, sendingGatewayId needs changed to match out uri as well
        cmac.setAlertUri("");
        //TODO: this must also be dynamically generated
        cmac.setCapIdentifier("");
        //TODO: should this be LocalDateTime.Now()?
        cmac.setCapSentDateTime(getSent());

        return cmac;
    }
}
