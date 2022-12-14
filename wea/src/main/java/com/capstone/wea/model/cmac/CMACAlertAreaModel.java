package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_Alert_Area")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CMACAlertAreaModel {
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
    private List<CMACCapGeocodeModel> capGeocodeList;

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

    public void setCapGeocodeList(List<CMACCapGeocodeModel> capGeocodeList) {
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

    public void addArea(String areaDescription, String geocode) {
        if (this.areaDescription != null) {
            this.areaDescription += "; " + areaDescription;
        } else {
            this.areaDescription = areaDescription;
        }

        if (capGeocodeList == null) {
            capGeocodeList = new ArrayList<>();
        }

        capGeocodeList.add(new CMACCapGeocodeModel("SAME", geocode));

        if (geocodeList == null) {
            geocodeList = new ArrayList<>();
        }

        geocodeList.add(geocode);
    }

    public boolean addToDatabase(JdbcTemplate dbTemplate, int messageNumber, String capIdentifier) {
        String[] areaNames = areaDescription.split("; ");

        int sameCount = 0;
        int ugcCount = 0;
        int startIndex = 0;

        //count SAME vs UGC
        for (CMACCapGeocodeModel geocode : capGeocodeList) {
            if (geocode.getName().equalsIgnoreCase("same")) {
                sameCount++;
            } else {
                ugcCount++;
            }
        }

        //the number of names must equal the number of geocodes
        if (sameCount == areaNames.length) {
            startIndex = 0;
        } else if (ugcCount == areaNames.length) {
            startIndex = sameCount;
        } else {
            return false;
        }


        String query;

        for (int i = 0; i < areaNames.length; i++) {
            query = "INSERT INTO alert_db.cmac_area_description " +
                    "VALUES (" + messageNumber + ", '" + capIdentifier + "', '" + areaNames[i] + "', '" +
                    geocodeList.get(i + startIndex) + "');";

            //failed to insert, remove all prior successful inserts
            if (dbTemplate.update(query) == 0) {
                return false;
            }
        }

        String[] polyCoordinates;

        if (polygon == null || polygon.isEmpty()) {
            polyCoordinates = new String[] {};
        } else {
            polyCoordinates = polygon.split(" ");
        }

        for (int i = 0; i < polyCoordinates.length; i++) {
            BigDecimal[] decCoordinates = new BigDecimal[2];
            String[] coordinates = polyCoordinates[i].split(",");

            //index 0 = lat, index 1 = lon
            decCoordinates[0] = new BigDecimal(coordinates[0]);
            decCoordinates[1] = new BigDecimal(coordinates[1]);

            query = "INSERT INTO alert_db.cmac_polygon_coordinates " +
                    "VALUES (" + messageNumber + ", '" + capIdentifier + "', " + decCoordinates[0] + ", " +
                    decCoordinates[1] + ");";

            if (dbTemplate.update(query) == 0) {
                return false;
            }
        }

        String[] circCoordinates;

        if (circle == null || circle.isEmpty()) {
            circCoordinates = new String[] {};
        } else {
            circCoordinates = circle.split(" ");
        }

        for (int i = 0; i < circCoordinates.length; i++) {
            BigDecimal[] decCoordinates = new BigDecimal[2];
            String[] coordinates = circCoordinates[i].split(",");

            //index 1 = lat, index 2 = lon
            decCoordinates[0] = new BigDecimal(coordinates[0]);
            decCoordinates[1] = new BigDecimal(coordinates[1]);

            query = "INSERT INTO alert_db.cmac_circle_coordinates " +
                    "VALUES (" + messageNumber + ", '" + capIdentifier + "', " + decCoordinates[0] + ", " +
                    decCoordinates[1] + ");";

            if (dbTemplate.update(query) == 0) {
                return false;
            }
        }

        return true;
    }
}
