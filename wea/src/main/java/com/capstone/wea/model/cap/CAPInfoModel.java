package com.capstone.wea.model.cap;

import com.capstone.wea.model.cmac.CMACMessageAlertArea;
import com.capstone.wea.model.cmac.CMACMessageAlertInfo;
import com.capstone.wea.model.cmac.CMACMessageAlertText;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "info")
public class CAPInfoModel {
    @JsonProperty("category")
    private String category;
    @JsonProperty("event")
    private String event;
    @JsonProperty("responseType")
    private String responseType;
    @JsonProperty("urgency")
    private String urgency;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("certainty")
    private String certainty;
    @JsonProperty("eventCode")
    @JacksonXmlElementWrapper(useWrapping = false)
    private CAPEventCodeModel eventCode;
    @JsonProperty("expires")
    private String expires;
    @JsonProperty("senderName")
    private String senderName;
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("description")
    private String description;
    @JsonProperty("instruction")
    private String instruction;
    @JsonProperty("contact")
    private String contact;
    @JsonProperty("area")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CAPAreaModel> area;

    public CMACMessageAlertInfo toCmac() {
        CMACMessageAlertInfo cmac = new CMACMessageAlertInfo();

        cmac.setCategory(category);
        cmac.setSeverity(severity);
        cmac.setUrgency(urgency);
        cmac.setCertainty(certainty);
        cmac.setExpires(expires);
        cmac.setSenderName(senderName);
        List <CMACMessageAlertArea> cmacArea = new ArrayList<>();

        for (CAPAreaModel areaModel : area) {
            cmacArea.add(areaModel.toCmac());
        }
        cmac.setAlertAreaList(cmacArea);

        List<CMACMessageAlertText> cmacText = new ArrayList<>();

        cmacText.add(new CMACMessageAlertText());
        cmacText.get(0).setLanguage("English");
        cmacText.get(0).setShortMessage(headline.replace("\n", " "));
        cmacText.get(0).setShortLength(cmacText.get(0).getShortMessage().length());
        cmacText.get(0).setLongMessage(description.replace("\n", " "));
        cmacText.get(0).setLongLength(cmacText.get(0).getLongMessage().length());

        cmac.setAlertTextList(cmacText);

        return cmac;
    }
}
