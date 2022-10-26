package com.capstone.wea.model.cap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "info")
public class CAPInfoModel {
    @JsonProperty("category")
    private String category;
    @JsonProperty("event")
    private String event;
    @JsonProperty("responseType")
    private String responseType;
    @JsonProperty("urgency")
    private String urgency;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("certainty")
    private String certainty;
    @JsonProperty("eventCode")
    private CAPEventCodeModel eventCode;
    @JsonProperty("expires")
    private LocalDateTime expires;
    @JsonProperty("senderName")
    private String senderName;
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("description")
    private String description;
    @JsonProperty("instruction")
    private String instruction;
    @JsonProperty("contact")
    private String contact;
    @JsonProperty("area")
    private List<CAPAreaModel> area;
}
