CREATE TABLE IF NOT EXISTS Countries (
    code INTEGER UNIQUE
                 NOT NULL
                 PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Doc_types (
    code INTEGER       UNIQUE
                       NOT NULL
                       PRIMARY KEY,
    name VARCHAR (100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Organization (
    id        INTEGER       PRIMARY KEY AUTOINCREMENT
                            NOT NULL
                            UNIQUE,
    name      VARCHAR (50)  NOT NULL,
    full_name VARCHAR (150),
    inn       INTEGER,
    kpp       VARCHAR (9),
    address   VARCHAR (200),
    phone     INTEGER,
    is_active BOOLEAN       NOT NULL
);

CREATE TABLE IF NOT EXISTS Office (
    id              INTEGER       PRIMARY KEY AUTOINCREMENT
                                  NOT NULL
                                  UNIQUE,
    name            VARCHAR (50)  NOT NULL,
    organization_id INTEGER       REFERENCES Organization (id)
                                  NOT NULL,
    address         VARCHAR (200),
    phone           INTEGER,
    is_active       BOOLEAN       NOT NULL
);

CREATE TABLE IF NOT EXISTS Position_list (
    id   INTEGER       PRIMARY KEY AUTOINCREMENT
                       UNIQUE
                       NOT NULL,
    name VARCHAR (200) NOT NULL
                       UNIQUE
);

CREATE TABLE IF NOT EXISTS Position (
    id               INTEGER NOT NULL
                             UNIQUE
                             PRIMARY KEY AUTOINCREMENT,
    office_id        INTEGER REFERENCES Office (id),
    position_list_id INTEGER REFERENCES Position_list (id)
);

CREATE TABLE IF NOT EXISTS User (
    id                 INTEGER      PRIMARY KEY AUTOINCREMENT
                                    UNIQUE
                                    NOT NULL,
    first_name         VARCHAR (50) NOT NULL,
    second_name        VARCHAR (50) NOT NULL,
    middle_name        VARCHAR (50),
    office_position_id INTEGER      REFERENCES Office_Position (id)
                                    UNIQUE,
    phone              INTEGER,
    citizenship_code   INTEGER      REFERENCES Countries (code),
    is_identified      BOOLEAN      NOT NULL
);

CREATE TABLE IF NOT EXISTS Docs (
    user_id      INTEGER      REFERENCES User (id),
    doc_types_id INTEGER      REFERENCES Doc_types (code),
    number       VARCHAR (50),
    receive_date INTEGER,
    expire_date  INTEGER
);
