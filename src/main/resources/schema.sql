CREATE TABLE Countries (
    id   INTEGER PRIMARY KEY AUTOINCREMENT
                 UNIQUE
                 NOT NULL,
    name VARCHAR NOT NULL,
    code VARCHAR UNIQUE
                 NOT NULL
);

CREATE TABLE Doc_types (
    id   INTEGER       PRIMARY KEY AUTOINCREMENT
                       UNIQUE
                       NOT NULL,
    name VARCHAR (100) NOT NULL,
    code VARCHAR       UNIQUE
                       NOT NULL
);

CREATE TABLE Organization (
    id        INTEGER       PRIMARY KEY AUTOINCREMENT
                            NOT NULL
                            UNIQUE,
    name      VARCHAR (50)  NOT NULL,
    full_name VARCHAR (150),
    inn       VARCHAR,
    kpp       VARCHAR (9),
    address   VARCHAR (200),
    phone     VARCHAR,
    is_active BOOLEAN       NOT NULL
);

CREATE TABLE Office (
    id              INTEGER       PRIMARY KEY AUTOINCREMENT
                                  NOT NULL
                                  UNIQUE,
    name            VARCHAR (50)  NOT NULL,
    organization_id INTEGER       REFERENCES Organization (id)
                                  NOT NULL,
    address         VARCHAR (200),
    phone           VARCHAR,
    is_active       BOOLEAN       NOT NULL
);

CREATE TABLE Position_list (
    id   INTEGER       PRIMARY KEY AUTOINCREMENT
                       UNIQUE
                       NOT NULL,
    name VARCHAR (200) NOT NULL
                       UNIQUE
);

CREATE TABLE Position (
    id               INTEGER NOT NULL
                             UNIQUE
                             PRIMARY KEY AUTOINCREMENT,
    office_id        INTEGER REFERENCES Office (id),
    position_list_id INTEGER REFERENCES Position_list (id)
);

CREATE TABLE User (
    id             INTEGER      PRIMARY KEY AUTOINCREMENT
                                UNIQUE
                                NOT NULL,
    first_name     VARCHAR (50) NOT NULL,
    second_name    VARCHAR (50) NOT NULL,
    middle_name    VARCHAR (50),
    position_id    INTEGER      REFERENCES Position (id)
                                UNIQUE,
    phone          VARCHAR,
    citizenship_id INTEGER      REFERENCES Countries (id),
    is_identified  BOOLEAN      NOT NULL
);

CREATE TABLE Document (
    user_id      INTEGER      REFERENCES User (id),
    doc_types_id INTEGER      REFERENCES Doc_types (id),
    number       VARCHAR (50),
    receive_date INTEGER,
    expire_date  INTEGER
);


CREATE INDEX IX_Document_User_Id ON Document (
    user_id
);

CREATE INDEX IX_Document_Doc_types_Id ON Document (
    doc_types_id
);

CREATE INDEX IX_Office_Organization_Id ON Office (
    organization_id
);

CREATE INDEX IX_Position_Position_List_Id ON Position (
    position_list_id
);

CREATE INDEX IX_Position_Office_Id ON Position (
    office_id
);

CREATE INDEX IX_User_Position_Id ON User (
    position_id
);

CREATE INDEX IX_User_Sitizenship_Id ON User (
    citizenship_id
);