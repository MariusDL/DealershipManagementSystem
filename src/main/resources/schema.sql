CREATE TABLE vehicles (
    id INTEGER IDENTITY PRIMARY KEY,
    key_tag INTEGER,
    make VARCHAR(30),
    model  VARCHAR(30),
    reg VARCHAR(10),
    fabrication_year VARCHAR(10),
    transmission VARCHAR(20),
    cc VARCHAR(10),
    colour VARCHAR(20),
    buying_price DOUBLE,
    selling_price DOUBLE
);