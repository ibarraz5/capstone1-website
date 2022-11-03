package com.capstone.wea.model.cap;

import com.capstone.wea.model.cmac.CMACMessageAlertArea;
import com.capstone.wea.model.cmac.CMACMessageCapGeocode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "area")
public class CAPAreaModel {
    @JsonProperty("areaDesc")
    private String areaDesc;
    @JsonProperty("polygon")
    private String polygon;
    @JsonProperty("geocode")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CAPGeocodeModel> geocode;

    public CMACMessageAlertArea toCmac() {
        CMACMessageAlertArea cmac = new CMACMessageAlertArea();

        cmac.setAreaDescription(areaDesc.replace(", ", ";"));
        cmac.setPolygon(polygon);
        cmac.setCircle("");

        List <CMACMessageCapGeocode> cmacGeocode = new ArrayList<>();

        for (CAPGeocodeModel cap : geocode) {
            cmacGeocode.add(cap.toCmac());
        }

        cmac.setCapGeocodeList(cmacGeocode);

        return cmac;
    }
}
