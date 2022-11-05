package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
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

    public boolean addToDatabse(JdbcTemplate dbTemplate, String messageNumber) {
        String[] areaNames = areaDescription.split("; ");

        //the number of names must equal the number of geocodes
        if (areaNames.length != geocodeList.size()) {
            return false;
        }

        String query;
        for (int i = 0; i < areaNames.length; i++) {
            query = "INSERT INTO alert_db.cmac_area_description " +
                    "VALUES ('" + messageNumber + "', '" + areaNames[i] + "', '" + geocodeList.get(i) + "');";

            //failed to insert, remove all prior successful inserts
            if (dbTemplate.update(query) == 0) {
                removeFromDatabase(dbTemplate, messageNumber);
                return false;
            }
        }

        String[] polyCoordinates = polygon.split(" ");

        for (int i = 0; i < polyCoordinates.length; i++) {
            BigDecimal[] decCoordinates = new BigDecimal[2];
            String[] coordinates = polyCoordinates[i].split(",");

            //index 1 = lat, index 2 = lon
            decCoordinates[0] = new BigDecimal(coordinates[0]);
            decCoordinates[1] = new BigDecimal(coordinates[1]);

            query = "INSERT INTO alert_db.cmac_polygon_coordinates " +
                    "VALUES ('" + messageNumber + ", " + decCoordinates[0] + ", " + decCoordinates[1] + ");";

            if (dbTemplate.update(query) == 0) {
                removeFromDatabase(dbTemplate, messageNumber);
                return false;
            }
        }

        String[] circCoordinates = polygon.split(" ");

        for (int i = 0; i < circCoordinates.length; i++) {
            BigDecimal[] decCoordinates = new BigDecimal[2];
            String[] coordinates = circCoordinates[i].split(",");

            //index 1 = lat, index 2 = lon
            decCoordinates[0] = new BigDecimal(coordinates[0]);
            decCoordinates[1] = new BigDecimal(coordinates[1]);

            query = "INSERT INTO alert_db.cmac_polygon_coordinates " +
                    "VALUES ('" + messageNumber + ", " + decCoordinates[0] + ", " + decCoordinates[1] + ");";

            if (dbTemplate.update(query) == 0) {
                removeFromDatabase(dbTemplate, messageNumber);
                return false;
            }
        }

        return true;
    }

    private void removeFromDatabase(JdbcTemplate dbTemplate, String messageNumber) {
        //TODO: create DELETE query
    }
}
