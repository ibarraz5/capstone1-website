package com.capstone.wea.controller;

import com.capstone.wea.model.WEAMessageModel;
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

@RequestMapping("/wea")
@RestController
public class WEAController {
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
     * @param message The xml payload
     * @return HTTP 200 OK and the URI of the
     *         uploaded data
     */
    @PutMapping(value = "/upload")
    public ResponseEntity<String> upload(@RequestBody WEAMessageModel message) {
        URI location = ServletUriComponentsBuilder
                .fromHttpUrl("http:/localhost:8080/wea/getUpload?number=" + message.getMessageNumber() +
                        "&identifier=" + message.getCapIdentifier())
                .buildAndExpand()
                . toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/getUpload")
    public ResponseEntity<String> getUpload(@RequestParam String messageNumber, @RequestParam String capIdentifier) {
        return ResponseEntity.ok("ok");
    }
}
