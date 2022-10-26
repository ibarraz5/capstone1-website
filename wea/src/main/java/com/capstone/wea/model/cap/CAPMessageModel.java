package com.capstone.wea.model.cap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "alert")
public class CAPMessageModel {
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("sent")
    private LocalDateTime sent;
    @JsonProperty("msgType")
    private String msgType;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("info")
    private List<CAPInfoModel> info;
}
