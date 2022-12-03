package com.capstone.wea.model.cap;

import com.capstone.wea.model.cmac.CMACMessageModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "ns1:alerts")
public class IPAWSMessageList {
    @JsonProperty("alert")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CAPMessageModel> alertList;

    public List<CAPMessageModel> getAlertList() {
        return alertList;
    }

    public List<CMACMessageModel> toCmac() {
        List<CMACMessageModel> cmacMessageList = new ArrayList<>();

        for (CAPMessageModel alert : alertList) {
            cmacMessageList.add(alert.toCmac());
        }

        return cmacMessageList;
    }
}
