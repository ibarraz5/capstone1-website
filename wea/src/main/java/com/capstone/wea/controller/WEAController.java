package com.capstone.wea.controller;

import com.capstone.wea.model.cmac.*;
import com.capstone.wea.model.queryresults.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/wea")
@RestController
public class WEAController {
    private HashMap<Integer, CollectedUserData> uploads;
    @Autowired
    JdbcTemplate dbTemplate;

    public WEAController() {
        uploads = new HashMap<>();
    }
    /**
     * Endpoint to request a WEA message from the server.
     * For now, the message is static, but if we decide to
     * go this route for message retrivial it will be
     * randomized in the future
     *
     * @return HTTP 200 OK and an XML formatted WEA message
     */
    @GetMapping(value = "/getMessage", produces = "application/xml")
    public ResponseEntity<WEAMessageModel> getMessage() {
        XmlMapper mapper = null;
        File message = null;
        WEAMessageModel model = null;

        try {
            message = new File("src/main/resources/sampleMessage.xml");
            mapper = new XmlMapper();
            mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            model = mapper.readValue(message, WEAMessageModel.class);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(model);
    }

    /**
     * Endpoint to which the data collected from the
     * mobile device will be sent
     *
     * @param userData An xml body containing the data
     *                 collected from the user
     *
     * @return HTTP 201 CREATED and the URI of the
     *         uploaded data
     */
    @PutMapping(value = "/upload")
    public ResponseEntity<String> upload(@RequestBody CollectedUserData userData) {
        URI location = ServletUriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/wea/getUpload?identifier=" + userData.getId())
                .buildAndExpand()
                . toUri();

        uploads.put(userData.getId(), userData);

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
        XmlMapper mapper = null;
        CollectedUserData data = uploads.get(identifier);

        if (data == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Upload not found");
        }

        return ResponseEntity.ok(data);
    }

    /**
     * Gets the list of all CMAC_messages sent by
     * a specified CMAC_sender. The list contains
     * the CMAC_message_number and the
     * CMAC_send_date_time which will be displayed
     * for the AO after logging onto the website
     *
     * @param sender A CMAC_sender. '@' characters
     *               must be encoded as %40
     * @return HTTP 200 OK and a JASON array of
     *         objects containing a
     *         CMAC_message_number and a
     *         CMAC_sent_date_time
     */
    @GetMapping("/getMessageList")
    public ResponseEntity<List<MessageListResult>> getMessageList(@RequestParam String sender) {
        List<MessageListResult> result = dbTemplate.query("select cmac_message_number, cmac_sent_date_time from " +
                "cmac_message where cmac_sender = \"" + sender + "\";",
                new MessageListResult.MessageListResultMapper());

        return ResponseEntity.ok(result);
    }

    /**
     * Gets the stats for a specified CMAC_Alert.
     * The stats include: (1) the average time
     * between when the message was sent and the
     * devices received it, (2) the shortest time
     * from all devices in (1), (3) the longest
     * time from all devices in (1), (4) the
     * average delay between when the devices
     * received the message and when it was
     * displayed on the device, (5) the number
     * of devices that received the message, and
     * (6) the number of devices that received the
     * message that were outside the targeted area
     * @param messageNumber The cmac_message_number
     *                      for which to get the
     *                      stats
     * @return HTTP 200 OK and a JSON object
     *         containing the stats
     */
    @GetMapping("/getMessageStats")
    public ResponseEntity<MessageStatsResult> getMessageStats(@RequestParam String messageNumber) {
        MessageStatsResult result = new MessageStatsResult();

        return ResponseEntity.ok(result);
    }
}
