package com.capstone.wea.controller;

import com.capstone.wea.model.WEAMessageModel;
import com.capstone.wea.model.wrappers.UploadWrapper;
import com.ctc.wstx.shaded.msv.org_jp_gr_xml.dom.XMLMaker;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/wea")
@RestController
public class WEAController {
    private HashMap<Integer, UploadWrapper> uploads;

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
     * @param wrapper An xml body containing a
     *                WEAMessageModel and a
     *                CollectedUserData
     * @return HTTP 201 CREATED and the URI of the
     *         uploaded data
     */
    @PutMapping(value = "/upload")
    public ResponseEntity<String> upload(@RequestBody UploadWrapper wrapper) {
        URI location = ServletUriComponentsBuilder
                .fromHttpUrl("https://localhost:8080/wea/getUpload?identifier=" + wrapper.getId())
                .buildAndExpand()
                . toUri();

        uploads.put(wrapper.getId(), wrapper);

        return ResponseEntity.created(location).build();
    }

    /**
     * Gets a data upload represented by a
     * unique identifier
     *
     * @param identifier Unique upload identifier
     * @return HTTP 200 OK and the uploaded data
     *         in XML format, or HTTP 404 NOT
     *         FOUND if the identifier is invalid
     */
    @GetMapping(value = "/getUpload", produces = "application/xml")
    public ResponseEntity<UploadWrapper> getUpload(@RequestParam int identifier) {
        XmlMapper mapper = null;
        UploadWrapper wrapper = uploads.get(identifier);

        if (wrapper == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Upload not found");
        }
        
        return ResponseEntity.ok(wrapper);
    }
}
