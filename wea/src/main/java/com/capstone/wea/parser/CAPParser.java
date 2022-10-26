package com.capstone.wea.parser;

import com.capstone.wea.model.cap.CAPMessageModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.File;

public class CAPParser {
    /**
     * Parses a CAP message from a given file
     *
     * @param path The file's path
     * @return A CAPMessageModel object
     */
    public static CAPMessageModel parse(String path) {
        CAPMessageModel model = null;
        try {
            File message = new File(path);
            XmlMapper mapper = new XmlMapper();
            mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            model = mapper.readValue(message, CAPMessageModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
