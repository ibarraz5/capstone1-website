# WEA API

This document provides an overview on how to start the server and use the API.

## Database Setup

Before running this application, make sure your database is up-to-date with the latest schema and has some sample 
data to query. You can use Alex's `database_schema.sql` query to set up the database and then created your own sample 
data, or you can use the `alert_db_dummy_data_setup.sql` query found this project's root directory to create both the 
schema  and populate it with sample data. It is recommended that you re-run one of these queries at the beginning of
each sprint and anytime you pull down the latest changes related to the server to make sure your local database works
as intended.

## Starting the Server

Java JDK 17 is required to run this project. This SpringBoot application can be run in your IDE as you would any other 
application, or by navigating to this project's root directory in the terminal and using the `./gradlew bootRun` 
command in linux, or `gradle bootRun` in Windows. 

## Making API Requests

The host for WEA API endpoints is always `http://localhost:8080/wea`. In this projects root directory, there is a 
json file named `API_Tests.har`. This is an `HAR - HTTP Archive Format` file that can imported in either Insomnia or
Postman to test the API endpoints.

At this time, the WEA API *does not* support HTTPS.

## Endpoint List

The WEA API has the following endpoints:

* [Get a Message](#message)
* [Upload Device Data](#upload)
* [Get an Upload](#getUpload)
* [Get Message List by AO](#list)

### <a id="message" /> Get a Message

The **Get a Message** endpoint is used by mobile devices to simulate receiving a CMAC message from an AO. On a 
successful GET, the response message body will be a CMAC compliant XML object.

#### Endpoint Usage
| Endpoint    | HTTP Verb | Request Body | Parameters | Success Response | Response Data   |
|-------------|-----------|--------------|------------|------------------|-----------------|
| /getMessage | GET       | ---          | ---        | 200              | application/xml |

#### Example Request:

    GET http://localhost:8080/wea/getMessage

#### Example Response Body:

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

### <a id="upload" /> Upload Device Data

The **Upload Device Data** endpoint is used by mobile devices to upload the collected data to the server. On a 
successful PUT, the HTTP response header will contain a Location that points to the uploaded data

#### Endpoint Usage
| Endpoint | HTTP Verb | Request Body | Parameters | Success Response | Response Data |
|----------|-----------|--------------|------------|------------------|---------------|
| /upload  | PUT       | XML          | ---        | 201              | Location      |

#### Example Request:

    PUT http://localhost:8080/wea/upload

#### Example Request Body:

    <?xml version = "1.0" encoding = "UTF-8"?>
    <CMAC_user_data>
        <CMAC_user_time_received>2017-06-03T01:37:50Z</CMAC_user_time_received>
        <CMAC_user_time_displayed>2017-06-03T01:38:01Z</CMAC_user_time_displayed>
        <CMAC_user_location_received>048151</CMAC_user_location_received>
        <CMAC_user_location_displayed>048151</CMAC_user_location_displayed>
        <CMAC_message_number>00001056</CMAC_message_number>
        <CMAC_cap_identifier>NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z</CMAC_cap_identifier>
    </CMAC_user_data>

#### Example Response Location Header:

    Location | http://localhost:8080/wea/getUpload?identifier=0

### <a id="getUpload" />Get an Upload

The **Get an Upload** endpoint is used to confirm that a device's data was successfully uploaded to the server. On a 
successful get, the HTTP response body will be an XML object that contains the uploaded data and the upload's unique 
identifier.

#### Endpoint Usage
| Endpoint   | HTTP Verb | Request Body | Parameters | Success Response | Response Data   |
|------------|-----------|--------------|------------|------------------|-----------------|
| /getUpload | PUT       | XML          | identifier | 200              | application/xml |

#### Example Request:

    GET http://localhost:8080/wea/getUpload?identifier=1

#### Example Response Body:

    <CMAC_user_data>
        <CMAC_user_time_received>2017-06-03T01:37:50</CMAC_user_time_received>
        <CMAC_user_time_displayed>2017-06-03T01:38:01</CMAC_user_time_displayed>
        <CMAC_user_location_received>48151</CMAC_user_location_received>
        <CMAC_user_location_displayed>48151</CMAC_user_location_displayed>
        <CMAC_message_number>00001055</CMAC_message_number>
        <id>14</id>
    </CMAC_user_data>

### <a id="list" /> Get Message List by AO

The **Get Message List by AO** endpoint is used to get a list of all messages in the database from a specified AO. 
On a successful GET, the HTTP response body will contain a JSON array of JSON objects, one object for each message by
the AO, and each object wil contain that message's unique CMAC_message_number, CMAC_sent_date_time, and the stats 
collected from all the devices that received the message. An AO's registered sender will contain the special character
'@' which must be encoded as "%40" in order to successfully query the database. Each stat is defined in the 
following table:

#### Stats Definitions
| Stat                  | Definition                                                                                                     |
|-----------------------|----------------------------------------------------------------------------------------------------------------|
| averageTime           | the average time between when the message was sent and all devices received it                                 |
| shortestTime          | the shortest time between when the message was sent and all devices received it                                |
| longestTime           | the longest time between when the message was sent and all devices received it                                 |
| averageDelay          | the average delay between when all devices received the message and when the alert was displayed on the device |
| deviceCount           | the number of devices that received the message                                                                |
| receivedOutsideCount  | the number of devices that received the message outside of the target area                                     |
| displayedOutsideCount | the average devices for which the alert was displayed on that device outside the target area                   |

#### Endpoint Usage
| Endpoint        | HTTP Verb | Request Body | Parameters | Success Response | Response Data    |
|-----------------|-----------|--------------|------------|------------------|------------------|
| /getMessageList | GET       | ---          | sender     | 200              | application/json |

#### Example Request:

    GET http://localhost:8080/wea/getMessageList?sender=w-nws.webmaster%40noaa.gov

#### Example Response Body:

    [
        {
            "messageNumber": "00001056",
            "date": "2017-06-03 01:32:50",
            "averageTime": "00:05:00",
            "shortestTime": "00:05:00",
            "longestTime": "00:05:00",
            "averageDelay": "00:00:36",
            "deviceCount": 2,
            "receivedOutsideCount": 0,
            "displayedOutsideCount": 1
        },
        {
            "messageNumber": "00001057",
            "date": "2017-06-03 01:32:50",
            "averageTime": "00:19:01",
            "shortestTime": "00:01:00",
            "longestTime": "00:28:22",
            "averageDelay": "00:02:08",
            "deviceCount": 3,
            "receivedOutsideCount": 1,
            "displayedOutsideCount": 0
        }
    ]