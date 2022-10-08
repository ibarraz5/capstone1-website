package com.capstone.wea.model.wrappers;

import com.capstone.wea.model.CollectedUserData;
import com.capstone.wea.model.WEAMessageModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "CMAC_upload")
public class UploadWrapper {
    @JsonProperty("CMAC_user_data")
    private CollectedUserData userData;
    @JsonProperty("CMAC_Alert_Attributes")
    private WEAMessageModel message;
    //unique identifier for a given upload
    private int id;
    private static int next_id = 0;

    public UploadWrapper() {
        id = next_id++;
    }
}
