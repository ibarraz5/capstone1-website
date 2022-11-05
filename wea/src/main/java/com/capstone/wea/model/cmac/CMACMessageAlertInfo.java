package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_alert_info")
public class CMACMessageAlertInfo {
    @JsonProperty("CMAC_category")
    private String category;
    @JsonProperty("CMAC_severity")
    private String severity;
    @JsonProperty("CMAC_urgency")
    private String urgency;
    @JsonProperty("CMAC_certainty")
    private String certainty;
    @JsonProperty("CMAC_expires_date_time")
    private String expires;

    @JsonProperty("CMAC_sender_name")
    private String senderName;

    @JsonProperty("CMAC_Alert_Area")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CMACMessageAlertArea> alertAreaList;

    @JsonProperty("CMAC_Alert_Text")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CMACMessageAlertText> alertTextList;

    public String getExpires() {
        return expires;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public void setCertainty(String certainty) {
        this.certainty = certainty;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setAlertAreaList(List<CMACMessageAlertArea> alertAreaList) {
        this.alertAreaList = alertAreaList;
    }

    public void setAlertTextList(List<CMACMessageAlertText> alertTextList) {
        this.alertTextList = alertTextList;
    }

    public boolean addToDatabse(JdbcTemplate dbTemplate, String messageNumber, String capIdentifier) {
        String query = "INSERT INTO alert_db.cmac_alert " +
                "VALUES ('" + senderName + "', '" + expires + "', '" + messageNumber + "', '" + capIdentifier + "');";

        //failed to insert
        if (dbTemplate.update(query) == 0) {
            return false;
        }

        //failed to insert an area list, must delete this entry and all added alert areas
        for (int i = 0; i < alertAreaList.size(); i++) {
            if (!alertAreaList.get(i).addToDatabse(dbTemplate, messageNumber)) {
                return false;
            }
        }

        return true;
    }
}
