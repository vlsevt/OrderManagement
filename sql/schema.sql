DROP TABLE IF EXISTS order_rows CASCADE;
DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id           SERIAL PRIMARY KEY,
    order_number VARCHAR(255) NOT NULL
);

CREATE TABLE order_rows
(
    id          SERIAL PRIMARY KEY,
    order_id    INT NOT NULL,
    item_name   VARCHAR(255) NOT NULL,
    quantity    INT NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE
);
