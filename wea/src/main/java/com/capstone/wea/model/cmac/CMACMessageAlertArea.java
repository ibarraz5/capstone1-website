package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_Alert_Area")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CMACMessageAlertArea {
    @JsonProperty("CMAC_area_description")
    private String areaDescription;

    @JsonProperty("CMAC_polygon")
    private String polygon;

    @JsonProperty("CMAC_circle")
    private String circle;

    @JsonProperty("CMAC_cmas_geocode")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<String> geocodeList;
    @JsonProperty("CMAC_cap_geocode")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CMACMessageCapGeocode> capGeocodeList;

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public void setGeocodeList(List<String> geocodeList) {
        this.geocodeList = geocodeList;
    }

    public void setCapGeocodeList(List<CMACMessageCapGeocode> capGeocodeList) {
        this.capGeocodeList = capGeocodeList;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public String getPolygon() {
        return polygon;
    }

    public String getCircle() {
        return circle;
    }

    public List<String> getGeocodeList() {
        return geocodeList;
    }
}
