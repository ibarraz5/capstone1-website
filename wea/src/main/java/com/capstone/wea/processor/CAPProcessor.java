package com.capstone.wea.processor;

import com.capstone.wea.model.cap.CAPMessageModel;
import com.capstone.wea.model.cmac.CMACMessageModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.File;

/**
 * Provides methods for processing CAP messages. These methods
 * convert CAP messages to an CMAC and insert them into the
 * database. In the future, this class may provide a method to
 * get new CAP messages from IPAWS.
 */
public class CAPProcessor {
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
