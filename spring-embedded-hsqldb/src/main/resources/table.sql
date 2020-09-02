DROP TABLE CUSTOMER IF EXISTS;
CREATE TABLE CUSTOMER (
    CUSTOMER_ID integer identity primary key,
    CUSTOMER_NAME varchar(50) not null,
    CUSTOMER_ADDRESS varchar(255),
    CUSTOMER_CITY varchar(50) not null,
    CUSTOMER_STATE varchar(50) not null,
    CUSTOMER_ZIP_POSTAL varchar(30) not null
);