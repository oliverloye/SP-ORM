INSERT INTO BOOK (TITLE) VALUES ('book-3');
SET @book1 = LAST_INSERT_ID();
INSERT INTO BOOK (TITLE) VALUES ('book-4');
SET @book2 = LAST_INSERT_ID();

INSERT INTO CUSTOMER (firstName, lastName, customerType) VALUES ('Oliver', 'Løye', 'RUSTY');
INSERT INTO CUSTOMER (firstName, lastName, customerType) VALUES ('Ann-Sofie', 'Løye', 'GOLD');
INSERT INTO CUSTOMER (firstName, lastName, customerType) VALUES ('Luna', 'Løye', 'SILVER');