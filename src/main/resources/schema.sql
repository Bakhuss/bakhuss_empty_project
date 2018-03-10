CREATE TABLE Country (
    id      INTEGER       PRIMARY KEY AUTOINCREMENT
                          UNIQUE
                          NOT NULL,
    version INTEGER       NOT NULL,
    name    VARCHAR (100) NOT NULL,
    code    VARCHAR (10)  UNIQUE
                          NOT NULL
);

CREATE TABLE Doc_type (
    id      INTEGER       PRIMARY KEY AUTOINCREMENT
                          UNIQUE
                          NOT NULL,
    version INTEGER       NOT NULL,
    name    VARCHAR (100) NOT NULL,
    code    VARCHAR (10)  UNIQUE
                          NOT NULL
);

CREATE TABLE Document (
    user_id      INTEGER      REFERENCES User (id),
    version      INTEGER      NOT NULL,
    doc_type_id  INTEGER      REFERENCES Doc_type (id),
    number       VARCHAR (50),
    receive_date DATE,
    expire_date  DATE
);

CREATE TABLE Organization (
    id        INTEGER       PRIMARY KEY AUTOINCREMENT
                            NOT NULL
                            UNIQUE,
    version   INTEGER       NOT NULL,
    name      VARCHAR (50)  NOT NULL,
    full_name VARCHAR (150),
    inn       VARCHAR (12),
    kpp       VARCHAR (9),
    address   VARCHAR (200),
    phone     VARCHAR (20),
    is_active BOOLEAN       NOT NULL
);

CREATE TABLE Office (
    id              INTEGER       PRIMARY KEY AUTOINCREMENT
                                  NOT NULL
                                  UNIQUE,
    version         INTEGER       NOT NULL,
    name            VARCHAR (50)  NOT NULL,
    organization_id INTEGER       REFERENCES Organization (id)
                                  NOT NULL,
    address         VARCHAR (200),
    phone           VARCHAR (20),
    is_active       BOOLEAN       NOT NULL
);

CREATE TABLE Position (
    id      INTEGER       PRIMARY KEY AUTOINCREMENT
                          UNIQUE
                          NOT NULL,
    version INTEGER       NOT NULL,
    name    VARCHAR (200) NOT NULL
                          UNIQUE
);

CREATE TABLE User (
    id             INTEGER      PRIMARY KEY AUTOINCREMENT
                                UNIQUE
                                NOT NULL,
    version        INTEGER      NOT NULL,
    first_name     VARCHAR (50) NOT NULL,
    second_name    VARCHAR (50) NOT NULL,
    middle_name    VARCHAR (50),
    position_id    INTEGER      REFERENCES Position (id)
                                UNIQUE,
    phone          VARCHAR (20),
    citizenship_id INTEGER      REFERENCES Country (id),
    is_identified  BOOLEAN      NOT NULL
);

CREATE TABLE User_Country (
    user_id    INTEGER REFERENCES User (id)
                       NOT NULL,
    country_id INTEGER REFERENCES Country (id)
                       NOT NULL
);


CREATE INDEX IX_Document_User_Id ON Document (
    user_id
);

CREATE INDEX IX_Document_Doc_type_Id ON Document (
    doc_type_id
);

CREATE INDEX IX_Office_Organization_Id ON Office (
    organization_id
);

CREATE INDEX IX_User_Position_Id ON User (
    position_id
);

CREATE INDEX IX_User_Citizenship_Id ON User (
    citizenship_id
);

CREATE INDEX IX_User_Country ON User_Country (
    user_id
);

CREATE INDEX IX_Country_User ON User_Country (
    country_id
);
