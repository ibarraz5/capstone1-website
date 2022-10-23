# WEA API


## Making Requests

The host for WEA API endpoints is always http://localhost:8080/wea

At this time. the WEA API *does not* support HTTPS.

## Endpoints Overview

The WEA API has the following enpoints:

Get a Message
Upload Device Data
Get an Upload
Get Message List by AO
Get Message Stats

### Get a Message

| Endpoint    | HTTP Verb | Request Body | Parameters | Success Response | Response Data   |
|-------------|-----------|--------------|------------|------------------|-----------------|
| /getMessage | GET       | ---          | ---        | 200              | application/xml |

The **Get a Message** endpoint is used by mobile devices to simulate receiving a CMAC message. On a successful GET, the
response message body will be a CMAC compliant XML object.

Example Request:

    GET http://localhost:8080/wea/getMessage

Example Response Body:

    <?xml version = "1.0" encoding = "UTF-8"?>
    <CMAC_Alert_Attributes xmlns = "cmac:2.0">
        <CMAC_protocol_version>2.0</CMAC_protocol_version>
        <CMAC_sending_gateway_id>http://wea_alert_gateway.gov</CMAC_sending_gateway_id>
        <CMAC_message_number>00001056</CMAC_message_number>
        <CMAC_sender>w-nws.webmaster@noaa.gov</CMAC_sender>
        <CMAC_sent_date_time>2017-06-03T01:32:50Z</CMAC_sent_date_time>
        <CMAC_status>Actual</CMAC_status>
        <CMAC_message_type>Alert</CMAC_message_type>
        <CMAC_cap_alert_uri>http://wea_alert_gateway.gov/CMAM1056</CMAC_cap_alert_uri>
        <CMAC_cap_identifier>NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z</CMAC_cap_identifier>
        <CMAC_cap_sent_date_time>2017-06-03T01:32:50Z</CMAC_cap_sent_date_time>
        <CMAC_alert_info>
            <CMAC_category>Met</CMAC_category>
            <CMAC_severity>Severe</CMAC_severity>
            <CMAC_urgency>Expected</CMAC_urgency>
            <CMAC_certainty>Likely</CMAC_certainty>
            <CMAC_expires_date_time>2017-06-03T02:30:00Z</CMAC_expires_date_time>
            <CMAC_sender_name>NWS San Angelo TX</CMAC_sender_name>
            <CMAC_Alert_Area>
                <CMAC_area_description>Fisher; Jones; Taylor; Callahan</CMAC_area_description>
                <CMAC_polygon>32.21,-99.62 32.27,-100.15 32.52,-100.15 32.52,-100.16 32.72,-
                    100.17 32.85,-99.61 32.21,-99.62</CMAC_polygon>
                <CMAC_cmas_geocode>48151</CMAC_cmas_geocode>
                <CMAC_cmas_geocode>48253</CMAC_cmas_geocode>
                <CMAC_cmas_geocode>48441</CMAC_cmas_geocode>
                <CMAC_cmas_geocode>48059</CMAC_cmas_geocode>
                <CMAC_cap_geocode>
                    <valueName>SAME</valueName>
                    <value>048151</value>
                </CMAC_cap_geocode>
                <CMAC_cap_geocode>
                    <valueName>SAME</valueName>
                    <value>048253</value>
                </CMAC_cap_geocode>
                <CMAC_cap_geocode>
                    <valueName>SAME</valueName>
                    <value>048441</value>
                </CMAC_cap_geocode>
                <CMAC_cap_geocode>
                    <valueName>SAME</valueName>
                    <value>048059</value>
                </CMAC_cap_geocode>
            </CMAC_Alert_Area>
            <CMAC_Alert_Text>
                <CMAC_text_language>English</CMAC_text_language>
                <CMAC_short_text_alert_message_length>52
                </CMAC_short_text_alert_message_length>
                <CMAC_short_text_alert_message>Flash Flood Warning this area until 9:30 PM CDT.
                    NWS</CMAC_short_text_alert_message>
                <CMAC_long_text_alert_message_length>187
                </CMAC_long_text_alert_message_length>
                <CMAC_long_text_alert_message>Flash Flood Warning this area until 9:30 PM CDT.
                    Avoid flood areas. Do not drive on flooded roads. Check local radio and television
                    stations for more information. National Weather Service</CMAC_long_text_alert_message>
            </CMAC_Alert_Text>
            <CMAC_Alert_Text>
                <CMAC_text_language>Spanish</CMAC_text_language>
                <CMAC_short_text_alert_message_length>68
                </CMAC_short_text_alert_message_length>
                <CMAC_short_text_alert_message>Aviso de inundación de destello esta área hasta
                    las 9:30 PM CDT. NWS</CMAC_short_text_alert_message>
                <CMAC_long_text_alert_message_length>247
                </CMAC_long_text_alert_message_length>
                <CMAC_long_text_alert_message>Advertencia de inundación de emergencia esta área
                    hasta las 9:30 PM CDT. Evite las zonas de inundación. No conduzca en carreteras
                    inundadas. Consulte las emisoras de radio y televisión locales para obtener más
                    información. National Weather Service</CMAC_long_text_alert_message>
            </CMAC_Alert_Text>
        </CMAC_alert_info>
    </CMAC_Alert_Attributes>

### Upload Device Data

| Endpoint | HTTP Verb | Request Body | Parameters | Success Response | Response Data |
|----------|-----------|--------------|------------|------------------|---------------|
| /upload  | PUT       | XML          | ---        | 201              | Location      |

The **Upload Device Data** endpoint is used by mobile devices to upload the collected data to the server. The 
Location Header of the HTTP response points to the location of the uploaded data.

Example Request:

    PUT http://localhost:8080/wea/upload

Example Request Body:

    <?xml version = "1.0" encoding = "UTF-8"?>
    <CMAC_user_data>
        <CMAC_user_time_received>2017-06-03T01:37:50Z</CMAC_user_time_received>
        <CMAC_user_time_displayed>2017-06-03T01:38:01Z</CMAC_user_time_displayed>
        <CMAC_user_location_received>048151</CMAC_user_location_received>
        <CMAC_user_location_displayed>048151</CMAC_user_location_displayed>
        <CMAC_message_number>00001056</CMAC_message_number>
        <CMAC_cap_identifier>NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z</CMAC_cap_identifier>
    </CMAC_user_data>

Example Response Location Header:

    Location | http://localhost:8080/wea/getUpload?identifier=0

### Get an Upload

| Endpoint   | HTTP Verb | Request Body | Parameters | Success Response | Response Data   |
|------------|-----------|--------------|------------|------------------|-----------------|
| /getUpload | PUT       | XML          | identifier | 200              | application/xml |

The **Get an Upload** endpoint is used to confirm that a device's data was successfully uploaded to the server.

Example Request:

    GET http://localhost:8080/wea/getUpload?identifier=0

Example Response Body:

    <CMAC_user_data>
        <id>0</id>
        <CMAC_user_time_received>2017-06-03T01:37:50</CMAC_user_time_received>
        <CMAC_user_time_displayed>2017-06-03T01:37:50</CMAC_user_time_displayed>
        <CMAC_user_location_received>
            048151
        </CMAC_user_location_received>
        <CMAC_user_location_displayed>
            048151
        </CMAC_user_location_displayed>
        <CMAC_message_number>
            00001056
        </CMAC_message_number>
        <CMAC_cap_identifier>
            NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z
        </CMAC_cap_identifier>
    </CMAC_user_data>

