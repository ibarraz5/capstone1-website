package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.jdbc.core.JdbcTemplate;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CMAC_Alert_Text")
public class CMACAlertTextModel {
    @JsonProperty("CMAC_text_language")
    private String language;
    @JsonProperty("CMAC_short_text_alert_message_length")
    private int shortLength;
    @JsonProperty("CMAC_short_text_alert_message")
    private String shortMessage;
    @JsonProperty("CMAC_long_text_alert_message_length")
    private int longLength;
    @JsonProperty("CMAC_long_text_alert_message")
    private String longMessage;

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setShortLength(int shortLength) {
        this.shortLength = shortLength;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
        shortLength = this.shortMessage.length();
    }

    public void setLongLength(int longLength) {
        this.longLength = longLength;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
        longLength = this.longMessage.length();
    }

    public String getShortMessage() {
        return shortMessage;
    }

    public String getLongMessage() {
        return longMessage;
    }

    public boolean addToDatabase(JdbcTemplate dbTemplate, int messageNumber, String capIdentifier) {
        String fullLanguageName;
        if (language.equalsIgnoreCase("en-us") || language.equalsIgnoreCase("english")) {
            fullLanguageName = "English";
        } else {
            fullLanguageName = "Spanish";
        }
        String query = "INSERT INTO alert_db.cmac_alert_text " +
                "VALUES (" + messageNumber + ", '" + capIdentifier + "', '" + fullLanguageName + "', '" +
                shortMessage + "', '" + longMessage.replace("'", "\\'") + "');";

        if (dbTemplate.update(query) == 0) {
            return false;
        }

        return true;
    }
}
