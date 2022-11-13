# WEA API

This document provides an overview on how to start the server and use the API.

## Database Setup

Before running this application, make sure your database is up-to-date with the latest schema and has some sample 
data to query. You can use Alex's `database_schema.sql` query to set up the database and then created your own sample 
data, or you can use the `alert_db_dummy_data_setup.sql` query found this project's root directory to create both the 
schema and populate it with sample data. It is recommended that you re-run one of these queries at the beginning of each
sprint and anytime you pull down the latest changes related to the server to make sure your local database works as
intended.

If you are making changes to the database schema, **DO NOT** directly modify the `alert_db_dummy_data_setup.sql` file. 
These changes should be made in the `database_schema.sql`. The `alert_db_dummy_data.sql` file is an export created by
MySQL and any changes made will be overwritten if a new export is produced. It may also fail to execute because it can 
make the insert statement s invalid.

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
* [Get Message Stats by AO](#stats)

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
    <CMAC_device_data>
        <CMAC_user_time_received>2017-06-03T01:33:29</CMAC_user_time_received>
        <CMAC_user_time_displayed>2017-06-03T01:33:36</CMAC_user_time_displayed>
        <CMAC_user_location_received>48253</CMAC_user_location_received>
        <CMAC_user_location_displayed>48253</CMAC_user_location_displayed>
        <CMAC_message_number>00001059</CMAC_message_number>
        <Received_Outside_Area>false</Received_Outside_Area>
        <Displayed_Outside_Area>false</Displayed_Outside_Area>
        <Received_After_Expired>false</Received_After_Expired>
        <Displayed_After_Expired>false</Displayed_After_Expired>
    </CMAC_device_data>

#### Example Response Location Header:

    Location | http://localhost:8080/wea/getUpload?identifier=1

### <a id="getUpload" />Get an Upload

The **Get an Upload** endpoint is used to confirm that a device's data was successfully uploaded to the server. On a 
successful get, the HTTP response body will be an XML object that contains the uploaded data and the upload's unique 
identifier.

#### Endpoint Usage
| Endpoint   | HTTP Verb | Request Body | Parameters | Success Response | Response Data   |
|------------|-----------|--------------|------------|------------------|-----------------|
| /getUpload | PUT       | XML          | identifier | 200              | application/xml |

#### Example Request:

    GET http://localhost:8080/wea/getUpload?identifier=12

#### Example Response Body:

    <CMAC_device_data>
        <CMAC_user_time_received>2017-06-03T01:33:29</CMAC_user_time_received>
        <CMAC_user_time_displayed>2017-06-03T01:33:36</CMAC_user_time_displayed>
        <CMAC_user_location_received>48253</CMAC_user_location_received>
        <CMAC_user_location_displayed>48253</CMAC_user_location_displayed>
        <CMAC_message_number>00001059</CMAC_message_number>
        <Received_Outside_Area>false</Received_Outside_Area>
        <Displayed_Outside_Area>false</Displayed_Outside_Area>
        <Received_After_Expired>false</Received_After_Expired>
        <Displayed_After_Expired>false</Displayed_After_Expired>
        <id>12</id>
    </CMAC_device_data>

### <a id="stats" /> Get Message Stats by AO

The **Get Message Stats by AO** endpoint is used to get the stats of a subset of all messages in the database from a 
specified AO. Result subsets are divided into pages with up to 9 results per page. The page must be specified in the 
request url. On a successful GET, the HTTP response body will contain a JSON array of JSON objects, one object for 
each message by the AO, and each object will contain that message's unique CMAC_message_number, CMAC_sent_date_time, 
and the stats collected from all the devices that received the message. An AO's registered sender name will contain 
the special character '@' which must be encoded as "%40" in order to successfully query the database. A definition of
each JSON key in the response body is provided in after the example response body.

#### Endpoint Usage
| Endpoint                  | HTTP Verb | Request Body | Parameters   | Success Response | Response Data    |
|---------------------------|-----------|--------------|--------------|------------------|------------------|
| /{sender}/messages/{page} | GET       | ---          | sender, page | 200              | application/json |

#### Example Request:

    GET http://localhost:8080/wea/w-nws.webmaster%40noaa.gov/messages/1

#### Example Response Body:

    {
        "messageStats": [
            {
                "messageNumber": "00001056",
                "messageType": "Alert",
                "date": "2017-06-03 01:32:50",
                "averageTime": "00:06:59",
                "shortestTime": "00:05:00",
                "longestTime": "00:08:57",
                "averageDelay": "00:00:29",
                "deviceCount": 2,
                "receivedOutsideCount": 0,
                "displayedOutsideCount": 1,
                "receivedAfterExpiredCount": 0,
                "displayedAfterExpiredCount": 0
            },
            {
                "messageNumber": "00001057",
                "messageType": "Alert",
                "date": "2017-06-03 01:32:50",
                "averageTime": "00:19:01",
                "shortestTime": "00:01:00",
                "longestTime": "00:28:22",
                "averageDelay": "00:02:08",
                "deviceCount": 3,
                "receivedOutsideCount": 1,
                "displayedOutsideCount": 0,
                "receivedAfterExpiredCount": 0,
                "displayedAfterExpiredCount": 0
            },
            {
                "messageNumber": "00001058",
                "messageType": "Alert",
                "date": "2017-06-03 01:32:50",
                "averageTime": "00:11:23",
                "shortestTime": "00:01:20",
                "longestTime": "00:28:11",
                "averageDelay": "00:01:08",
                "deviceCount": 4,
                "receivedOutsideCount": 1,
                "displayedOutsideCount": 1,
                "receivedAfterExpiredCount": 0,
                "displayedAfterExpiredCount": 0
            },
            {
                "messageNumber": "00001059",
                "messageType": "Alert",
                "date": "2017-06-03 01:32:50",
                "averageTime": "00:00:26",
                "shortestTime": "00:00:11",
                "longestTime": "00:00:39",
                "averageDelay": "00:00:08",
                "deviceCount": 3,
                "receivedOutsideCount": 0,
                "displayedOutsideCount": 0,
                "receivedAfterExpiredCount": 0,
                "displayedAfterExpiredCount": 0
            }
        ],
        "prev": false,
        "next": false
    }

#### Json Key Definitions
| Stat                  | Definition                                                                                                     |
|-----------------------|----------------------------------------------------------------------------------------------------------------|
| messageStats          | an array of JSON objects that contain the collected stats for a cmac message                                   |
| messageNumber         | The CMAC_message_number of the message for which these stats were collected                                    |
| messageType           | The CMAC_message_type oof the alert                                                                            |
| date                  | The CMAC_sent_date_time of the alert                                                                           |
| averageTime           | the average time between when the message was sent and all devices received it                                 |
| shortestTime          | the shortest time between when the message was sent and all devices received it                                |
| longestTime           | the longest time between when the message was sent and all devices received it                                 |
| averageDelay          | the average delay between when all devices received the message and when the alert was displayed on the device |
| deviceCount           | the number of devices that received the message                                                                |
| receivedOutsideCount  | the number of devices that received the message outside of the target area                                     |
| displayedOutsideCount | the average devices for which the alert was displayed on that device outside the target area                   |
| prev                  | A boolean value that represents if there is a previous page of results; this is always true if page > 1        |
| next                  | A boolean value that represents if there is an additional page of results after this one                       |