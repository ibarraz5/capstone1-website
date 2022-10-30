package com.capstone.wea.model.cap;

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
}