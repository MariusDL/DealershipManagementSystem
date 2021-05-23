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


CREATE TABLE clients (
    id INTEGER IDENTITY PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    address VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(40)
);


CREATE TABLE sellers (
    id INTEGER IDENTITY PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    phone VARCHAR(15),
    email VARCHAR(40),
    department VARCHAR(40)
);

CREATE TABLE sales (
    id INTEGER IDENTITY PRIMARY KEY,
    vehicle_id INTEGER,
    date_sold DATE,
    vehicle_reg VARCHAR(10),
    vehicle_make VARCHAR(30),
    vehicle_model VARCHAR(30),
    client_id INTEGER,
    seller_id INTEGER,
    buying_price DOUBLE,
    selling_price DOUBLE
);

ALTER TABLE sales ADD CONSTRAINT fk_sales_client FOREIGN KEY (client_id) REFERENCES clients (id);
ALTER TABLE sales ADD CONSTRAINT fk_sales_seller FOREIGN KEY (seller_id) REFERENCES sellers (id);

