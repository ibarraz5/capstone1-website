package com.capstone.wea.controller;

import com.capstone.wea.model.cap.CAPMessageModel;
import com.capstone.wea.model.cmac.*;
import com.capstone.wea.model.sqlresult.*;
import com.capstone.wea.model.sqlresult.mappers.*;
import com.capstone.wea.parser.XMLParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/wea")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WEAController {
    @Autowired
    JdbcTemplate dbTemplate;

    /**
     * Endpoint to request a WEA message from the server.
     * For now, the message is static, but if we decide to
     * go this route for message retrivial it will be
     * randomized in the future
     *
     * @return HTTP 200 OK and an XML formatted WEA message
     */
    @GetMapping(value = "/getMessage", produces = "application/xml")
    public ResponseEntity<CMACMessageModel> getMessage() {
        CMACMessageModel model = XMLParser.parseCMAC("src/main/resources/sampleCmacMessage.xml");

        return ResponseEntity.ok(model);
    }

    /**
     * Endpoint to which the data collected from the
     * mobile device will be sent. The uploaded data
     * will be added to the database. This endpoint
     * is simply for testing purposes to make sure an
     * upload is successful before the database is
     * created
     *
     * @param userData An XML body containing the data
     *                 collected from the user
     *
     * @return HTTP 201 CREATED and the URI of the
     *         uploaded data
     */
    @PutMapping(value = "/upload")
    public ResponseEntity<String> upload(@RequestBody CollectedUserData userData) {
        String query = "INSERT INTO alert_db.device VALUES('" + userData.getMessageNumber() + "', NULL, NULL, NULL, " +
                "NULL, '" + userData.getLocationReceived() + "', '" + userData.getLocationDisplayed() + "', '" +
                userData.getTimeReceived() + "', '" + userData.getTimeDisplayed() + "');";
        dbTemplate.update(query);

        query = "SELECT LAST_INSERT_ID();";
        Integer id = dbTemplate.queryForObject(query, Integer.class);

        URI location = ServletUriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/wea/getUpload?identifier=" + id)
                .buildAndExpand()
                .toUri();

        return ResponseEntity.created(location).build();
    }

    /**
     * Gets a data upload represented by a unique
     * identifier. This endpoint is only used to
     * confirm successful uploads from devices
     * during testing
     *
     * @param identifier Unique upload identifier
     * @return HTTP 200 OK and the uploaded data
     *         in XML format, or HTTP 404 NOT
     *         FOUND if the identifier is invalid
     */
    @GetMapping(value = "/getUpload", produces = "application/xml")
    public ResponseEntity<CollectedUserData> getUpload(@RequestParam int identifier) {
        String query = "SELECT * " +
                "FROM alert_db.device " +
                "WHERE device_upload_data.InternalDeviceID = '" + identifier + "';";

        CollectedUserData data = dbTemplate.queryForObject(query, new CollectedUserDataMapper());

        return ResponseEntity.ok(data);
    }

    /**
     * Gets the list of all CMAC_messages sent by a
     * specified CMAC_sender and the collected stats
     * for each message.
     *
     * @param sender A CMAC_sender. '@' characters
     *               must be encoded as %40
     * @return HTTP 200 OK and a JASON array of
     *         objects containing each message's stats
     */
    @GetMapping("/getMessageList")
    public ResponseEntity<List<MessageStatsResult>> getMessageList(@RequestParam String sender) {
        List<String> numbers = dbTemplate.queryForList("SELECT CMACMessageNumber " +
                        "FROM alert_db.cmac_message " +
                        "WHERE CMACSender = '" + sender + "';",
                String.class);

        List<MessageStatsResult> resultList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            resultList.add(new MessageStatsResult(numbers.get(i)));
            mapMessageStats(numbers.get(i), resultList.get(i));
        }

        return ResponseEntity.ok(resultList);
    }

    /**
     * Maps the stats for a CMAC message to a
     * MessageStatsResult object
     *
     * @param messageNumber The CMAC_message_number
     * @param stats The MessageStatsResult object
     */
    public void mapMessageStats(String messageNumber, MessageStatsResult stats) {
        dbTemplate.query("SELECT cmac_message.CMACDateTime, CMACMessageType, " +
                        "SUM(CASE device_upload_data.CMACMessageNumber WHEN cmac_message.CMACMessageNumber " +
                        "THEN 1 ELSE 0 END) AS DeviceCount, " +
                        "CAST(SEC_TO_TIME(AVG(TIME_TO_SEC(TIMEDIFF(TimeReceived, CMACDateTime)))) AS TIME) " +
                        "AS AvgTime, " +
                        "MAX(TIMEDIFF(TimeReceived, CMACDateTime)) AS LongTime, " +
                        "MIN(TIMEDIFF(TimeReceived, CMACDateTime)) AS ShortTime, " +
                        "CAST(SEC_TO_TIME(AVG(TIME_TO_SEC(TIMEDIFF(TimeDisplayed, TimeReceived)))) AS TIME) " +
                        "AS AvgDelay, " +
                        "SUM(CASE WHEN ReceivedOutsideArea = 1 THEN 1 ELSE 0 END) AS ReceivedOutsideCount, " +
                        "SUM(CASE WHEN DisplayedOutsideArea = 1 THEN 1 ELSE 0 END) AS DisplayedOutsideCount, " +
                        "SUM(CASE WHEN ReceivedAfterExpired = 1 THEN 1 ELSE 0 END) AS ReceivedExpiredCount, " +
                        "SUM(CASE WHEN DisplayedAfterExpired = 1 THEN 1 ELSE 0 END) AS DisplayedExpiredCount " +
                        "FROM alert_db.device_upload_data JOIN alert_db.cmac_message " +
                        "ON cmac_message.CMACMessageNumber = device_upload_data.CMACMessageNumber " +
                        "WHERE cmac_message.CMACMessageNumber = '" + messageNumber + "';",
                new StatsResultsMapper(stats));
    }

    /**
     * Parses the sample CAP message file and returns it in an
     * HTTP response body. This endpoint is for testing purposes
     * only
     *
     * @return HTTP 200 OK and an XML CAP message
     */
    @GetMapping(value = "/parseCapMessage", produces = "application/xml")
    public ResponseEntity<CAPMessageModel> parseCapMessage() {
        CAPMessageModel result = XMLParser.parseCAP("src/main/resources/sampleCapMessage.xml");

        return ResponseEntity.ok(result);
    }

    /**
     * Endpoint to test CAP to CmAC conversion. This endpoint
     * converts a CAP message to CMAC, stores it in the database,
     * and returns the CMAC message in the response body
     *
     * @return HTTP 200 OK and an XML CMAC message body if the
     *         message was successfully added to the database,
     *         otherwise HTTP 400 BAD REQUEST
     */
    @GetMapping(value = "/capToCmac", produces = "application/xml")
    public ResponseEntity<CMACMessageModel> capToCmac() {
        CAPMessageModel result = XMLParser.parseCAP("src/main/resources/sampleCapMessage.xml");

        CMACMessageModel cmac = result.toCmac();

        try {
            if (!cmac.addToDatabase(dbTemplate)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to add message to database");
            }
        } catch (DuplicateKeyException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate Key Exception: Could not add message" +
                    " to database because a message with the same CMAC_message_number already exists");
        }

        return ResponseEntity.ok(cmac);
    }
}
