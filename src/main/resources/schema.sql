CREATE TYPE continent_enum AS ENUM ('AFRICA', 'EUROPA', 'ASIA', 'AMERICA');
CREATE TYPE position_enum AS ENUM ('GK', 'DEF', 'MIDF', 'STR');

CREATE TABLE Team (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      continent continent_enum NOT NULL
);

CREATE TABLE Player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        age INT,
                        position position_enum,
                        id_team INT REFERENCES Team(id)
);