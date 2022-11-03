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

    /**
     * Converts a CAP message to a CMAC message
     *
     * TODO: too many unknowns until I can get some real messages from IPAWS
     * Also, should there just be a constructor for each CMAC model that takes
     * the equivalent CAP model as a param? Makes more sense for CMAC to be in
     * charge of how to map attributes
     *
     * @param cap The CAP message to convert
     * @return A CMACMessageModel derived from the CAP message
     */
    public static CMACMessageModel capToCmac(CAPMessageModel cap) {
        CMACMessageModel cmac = new CMACMessageModel();

        /**
         * CMAC message number must be dynamically generated because cap identifier
         * does not follow the same convention
         * Current plan: SLECT MAX(CMACMessageNumber) FROM alert_db.cmac_message;
         *
         * convert result to hex
         * add 1
         * convert back to string
         */
        cmac.setMessageNumber("");
        cmac.setSender(cap.getSender());
        cmac.setSentDateTime(cap.getSent());
        cmac.setStatus(cap.getStatus());
        cmac.setMessageType(cap.getMsgType());
        //TODO: Hmm.. This is the endpoint to find this specific message. Should this lead back to us?
        //if so, sendingGatewayId needs changed to match out uri as well
        cmac.setAlertUri("");
        //TODO: this must also be dynamically generated
        cmac.setCapIdentifier("");
        //TODO: should this be LocalDateTime.Now()?
        cmac.setCapSentDateTime(cap.getSent());
        return null;
    }
}
