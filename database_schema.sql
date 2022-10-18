CREATE SCHEMA ALERT_DB;
USE ALERT_DB;
CREATE TABLE cap_alert (
    MessageID VARCHAR(180) NOT NULL,
    SenderID VARCHAR(180) NOT NULL,
    MessageSendDate DATE NOT NULL,
    MessageStatus VARCHAR(180) NOT NULL,
    MessageType VARCHAR(180) NOT NULL,
    Source VARCHAR(180),
    Scope VARCHAR(180) NOT NULL,
    Restriction VARCHAR(180),
    Addresses VARCHAR(280),
    HandlingCode VARCHAR(180),
    Note VARCHAR(180),
    ReferenceID VARCHAR(280),
    IncidentID VARCHAR(280),
    CONSTRAINT PK_MessageID PRIMARY KEY(MessageID)
);
CREATE TABLE cap_info (
    MessageID VARCHAR(180) NOT NULL,
    LanguageInfo VARCHAR(180),
    EventCategory VARCHAR(180) NOT NULL,
    EventType VARCHAR(280) NOT NULL,
    ResponseType VARCHAR(180),
    Urgency VARCHAR(280) NOT NULL,
    Severity VARCHAR(180) NOT NULL,
    Certainty VARCHAR(180) NOT NULL,
    Audience VARCHAR(180),
    EventCode VARCHAR(180),
    EffectiveDate DATE,
    OnsetDate DATE,
    ExpirationDate DATE,
    SenderName VARCHAR(180),
    Headline VARCHAR(180),
    EventDescription VARCHAR(280),
    Instruction VARCHAR(280),
    InformationURL VARCHAR(180),
    ContactInfo VARCHAR(180),
    Parameter VARCHAR(180)
);
CREATE TABLE cap_resource (
    MessageID VARCHAR(180) NOT NULL,
    ResourceDescription VARCHAR(180) NOT NULL,
    MimeType VARCHAR(180) NOT NULL,
    Size INT,
    URI VARCHAR(180),
    DereferencedURI VARCHAR(180),
    ResourceDigest VARCHAR(200)
);
CREATE TABLE cap_area (
    MessageID VARCHAR(180) NOT NULL,
    AreaDescription VARCHAR(200) NOT NULL,
    AreaPolygon VARCHAR(360),
    AreaCircle VARCHAR(180),
    AreaGeocode VARCHAR(200),
    AreaAltitude INT,
    AreaCeiling INT
);
CREATE TABLE cmac_message (
    CMACMessageNumber INT NOT NULL,
    CMACCapIdentifier INT NOT NULL,
    CMACSender VARCHAR(180) NOT NULL,
    CMACDateTime DATE NOT NULL,
    CMACMessageType VARCHAR(165) NOT NULL,
    CONSTRAINT PK_CMACMessage PRIMARY KEY (CMACMessageNumber)
);
CREATE TABLE cmac_alert (
    CMACSenderName VARCHAR(180) NOT NULL,
    CMACAlertArea VARCHAR(200),
    CMACExpiresDateTime DATE NOT NULL
);
CREATE TABLE cmac_alert_geography (
    CMACAreaDescription VARCHAR(200) NOT NULL,
    CMACPolygon INT NOT NULL,
    CMACCirlce INT NOT NULL,
    CMACCMASGeocode INT NOT NULL
);
CREATE TABLE device (
    DeviceOS VARCHAR(180),
    DeviceOSVersion VARCHAR(180),
    DeviceModel VARCHAR(180),
    DeviceLocation VARCHAR(200)
);
ALTER TABLE cmac_alert ADD CONSTRAINT FK_CMACMessageNumber FOREIGN KEY (CMACMessageNumber) REFERENCES cmac_message (CMACMessageNumber) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE cmac_alert ADD CONSTRAINT FK_CMACCAPIdentifier FOREIGN KEY (CMACCapIdentifier) REFERENCES cmac_message (CMACCapIdentifier) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE cmac_alert_geography ADD CONSTRAINT FK_CMACMessageNumber FOREIGN KEY (CMACMessageNumber) REFERENCES cmac_message (CMACMessageNumber) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE cmac_alert_geography ADD CONSTRAINT FK_CMACCAPIdentifier FOREIGN KEY (CMACCapIdentifier) REFERENCES cmac_message (CMACCapIdentifier) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE cmac_message ADD CONSTRAINT FK_CMACCAPIdentifier FOREIGN KEY (CMACCapIdentifier) REFERENCES cap_alert (MessageID) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE cap_info ADD CONSTRAINT FK_MessageID FOREIGN KEY (MessageID) REFERENCES cap_alert (MessageID) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE cap_resource ADD CONSTRAINT FK_MessageID2 FOREIGN KEY (MessageID) REFERENCES cap_alert (MessageID) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE cap_area ADD CONSTRAINT FK_MessageID3 FOREIGN KEY (MessageID) REFERENCES cap_alert (MessageID) ON DELETE NO ACTION ON UPDATE NO ACTION;