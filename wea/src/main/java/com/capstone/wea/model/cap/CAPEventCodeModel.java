package com.capstone.wea.model.cap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "eventCode")
public class CAPEventCodeModel {
    @JsonProperty("valueName")
    private String valueName;
    @JsonProperty("value")
    private CAPEventCodeModel value;
}
