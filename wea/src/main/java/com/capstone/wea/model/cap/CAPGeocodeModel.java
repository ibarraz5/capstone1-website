package com.capstone.wea.model.cap;

import com.capstone.wea.model.cmac.CMACMessageCapGeocode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "geocode")
public class CAPGeocodeModel {
    @JsonProperty("valueName")
    private String valueName;
    @JsonProperty("value")
    private String value;

    public CMACMessageCapGeocode toCmac() {
        CMACMessageCapGeocode cmac = new CMACMessageCapGeocode();

        cmac.setName(valueName);
        cmac.setValue(value);

        return cmac;
    }
}
