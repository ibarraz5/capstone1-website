package com.capstone.wea.parser;

import com.capstone.wea.model.cap.CAPMessageModel;
import com.capstone.wea.model.cmac.CMACMessageModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.File;

/**
 * Provides methods for parsing CAP and CMAC XML messages
 */
public class XMLParser {
    /**
     * Parses a CAP message from a given file
     *
     * @param path The file's path
     * @return A CAPMessageModel object
     */
    public static CAPMessageModel parseCAP(String path) {
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

    /**
     * Parses a CMAC message from a given file
     *
     * @param path The file's path
     * @return A CMACMessageModel object
     */
    public static CMACMessageModel parseCMAC(String path) {
        CMACMessageModel model = null;
        try {
            File message = new File(path);
            XmlMapper mapper = new XmlMapper();
            mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
            model = mapper.readValue(message, CMACMessageModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
