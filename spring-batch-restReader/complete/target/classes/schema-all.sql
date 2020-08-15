DROP TABLE people IF EXISTS;

CREATE TABLE EXCHANGE  (
    exchange_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    excode VARCHAR (20),
    short_name VARCHAR(20),
    long_name VARCHAR(90)
);
