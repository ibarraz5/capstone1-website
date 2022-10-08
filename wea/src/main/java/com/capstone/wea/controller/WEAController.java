package com.capstone.wea.controller;

import com.capstone.wea.model.WEAMessageModel;
import com.ctc.wstx.shaded.msv.org_jp_gr_xml.dom.XMLMaker;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RequestMapping("/wea")
@RestController
public class WEAController {
    /**
     * Endpoint to request a WEA message from the server.
     * For now, the message is static, but if we decide to
     * go this route for message retrivial it will be
     * randomized in the future
     *
     * @return An XML formatted WEA message
     */
    @GetMapping("/getMessage")
    public ResponseEntity<WEAMessageModel> getMessage() throws IOException {
        XmlMapper mapper = null;
        File message = null;
        try {
            message = new File("src/main/resources/sampleMessage.xml");
            mapper = new XmlMapper();
            mapper.readValue(message, WEAMessageModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(mapper.readValue(message, WEAMessageModel.class));
    }
}
