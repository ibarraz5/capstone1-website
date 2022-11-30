CREATE SCHEMA alert_db;
USE alert_db;

CREATE TABLE cmac_message (
    CMACMessageNumber INT NOT NULL AUTO_INCREMENT,
    CMACCapIdentifier VARCHAR(180) NOT NULL,
    CMACSender VARCHAR(180) NOT NULL,
    CMACDateTime DATETIME NOT NULL,
    CMACStatus VARCHAR(20) NOT NULL,
    CMACMessageType VARCHAR(20) NOT NULL,
    CMACSenderName VARCHAR(180) NOT NULL,
    CMACExpiresDateTime DATETIME NOT NULL,
    CMACCategory VARCHAR(20) NOT NULL,
    CMACSeverity VARCHAR(20) NOT NULL,
    CMACUgrency VARCHAR(20) NOT NULL,
    CMACCertainty VARCHAR(20) NOT NULL,
    CMACReferencedCapIdentifier VARCHAR(180),
    CONSTRAINT PK_CMACMessage PRIMARY KEY (CMACMessageNumber, CMACCapIdentifier)
);

CREATE TABLE cmac_polygon_coordinates (
    CMACMessageNumber INT NOT NULL,
    CMACCapIdentifier VARCHAR(180) NOT NULL,
    Latitude DECIMAL(5,2) NOT NULL,
    Longitude DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (CMACMessageNumber, CMACCapIdentifier) REFERENCES cmac_message(CMACMessageNumber, CMACCapIdentifier)
);

CREATE TABLE cmac_circle_coordinates (
    CMACMessageNumber INT NOT NULL,
    CMACCapIdentifier VARCHAR(180) NOT NULL,
    Latitude DECIMAL(5,2) NOT NULL,
    Longitude DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (CMACMessageNumber, CMACCapIdentifier) REFERENCES cmac_message(CMACMessageNumber, CMACCapIdentifier)
);

CREATE TABLE cmac_area_description (
    CMACMessageNumber INT NOT NULL,
    CMACCapIdentifier VARCHAR(150) NOT NULL,
    AreaName VARCHAR(500) NOT NULL,
    CMASGeocode VARCHAR(20) NOT NULL,
    FOREIGN KEY (CMACMessageNumber, CMACCapIdentifier) REFERENCES cmac_message(CMACMessageNumber, CMACCapIdentifier)
);

CREATE TABLE cmac_alert_text (
	CMACMessageNumber INT NOT NULL,
    CMACCapIdentifier VARCHAR(150) NOT NULL,
    CMACLanguage VARCHAR(20) NOT NULL,
    CMACShortMessage VARCHAR(200) NOT NULL,
    CMACLongMessage VARCHAR(2000),
	FOREIGN KEY (CMACMessageNumber, CMACCapIdentifier) REFERENCES cmac_message(CMACMessageNumber, CMACCapIdentifier)
);

CREATE TABLE device_upload_data (
    CMACMessageNumber INT NOT NULL,
    CMACCapIdentifier VARCHAR(180) NOT NULL,
    UploadID INT NOT NULL AUTO_INCREMENT,
    DeviceOS VARCHAR(180) DEFAULT NULL,
    DeviceOSVersion VARCHAR(180) DEFAULT NULL,
    DeviceModel VARCHAR(180) DEFAULT NULL,
    LocationReceived INT DEFAULT NULL,
    LocationDisplayed INT DEFAULT NULL,
    TimeReceived DATETIME DEFAULT NULL,
    TimeDisplayed DATETIME DEFAULT NULL,
    ReceivedOutsideArea BIT DEFAULT 0,
    DisplayedOutsideArea BIT DEFAULT 0,
    ReceivedAfterExpired BIT DEFAULT 0,
    DisplayedAfterExpired BIT DEFAULT 0,
    CONSTRAINT PK_UploadID PRIMARY KEY (UploadID),
    FOREIGN KEY (CMACMessageNumber, CMACCapIdentifier) REFERENCES cmac_message(CMACMessageNumber, CMACCapIdentifier)
);