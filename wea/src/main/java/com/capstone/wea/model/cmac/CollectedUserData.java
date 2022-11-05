package com.capstone.wea.model.cmac;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JacksonXmlRootElement(localName = "CMAC_user_data")
public class CollectedUserData {
    @JsonProperty("CMAC_user_time_received")
    private LocalDateTime timeReceived;
    @JsonProperty("CMAC_user_time_displayed")
    private LocalDateTime timeDisplayed;
    @JsonProperty("CMAC_user_location_received")
    private String locationReceived;
    @JsonProperty("CMAC_user_location_displayed")
    private String locationDisplayed;
    @JsonProperty("CMAC_message_number")
    private String messageNumber;
    @JsonProperty("id")
    private int id;

    /**
     * Gets the unique ID of this collected data in the database
     * @return The unique identifier for this data
     */
    public int getId() {
        return id;
    }

    public LocalDateTime getTimeReceived() {
        return timeReceived;
    }

    public LocalDateTime getTimeDisplayed() {
        return timeDisplayed;
    }

    public String getLocationReceived() {
        return locationReceived;
    }

    public String getLocationDisplayed() {
        return locationDisplayed;
    }

    public String getMessageNumber() {
        return messageNumber;
    }

    /**
     * Sets the time this device received the message
     *
     * @param timeReceived The date and time of receipt
     */
    public void setTimeReceived(LocalDateTime timeReceived) {
        this.timeReceived = timeReceived;
    }

    /**
     * Sets the time this device displayed the message
     *
     * @param timeDisplayed The date and time of display
     */
    public void setTimeDisplayed(LocalDateTime timeDisplayed) {
        this.timeDisplayed = timeDisplayed;
    }

    /**
     * Sets the location this device received the message
     *
     * @param locationReceived The Geocode where the device was
     *                         when the message was received
     */
    public void setLocationReceived(String locationReceived) {
        this.locationReceived = locationReceived;
    }

    /**
     * Sets the location this device displayed the message
     *
     * @param locationDisplayed The Geocode where the device was
     *                         when the message was displayed
     */
    public void setLocationDisplayed(String locationDisplayed) {
        this.locationDisplayed = locationDisplayed;
    }

    /**
     * The CMAC_message_number for which the stats collected
     * are for
     *
     * @param messageNumber The CMAC_message_number
     */
    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    /**
     * Sets the unique idetifier for this data in the database
     *
     * @param id This data's ID
     */
    public void setId(int id) {
        this.id = id;
    }
}
