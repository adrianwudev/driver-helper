-- 1_create_order_table.up.sql
BEGIN;

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    city VARCHAR(255),
    district VARCHAR(255),
    address VARCHAR(255),
    order_time TIMESTAMP,
    pick_up_drop VARCHAR(255),
    pick_up_time TIMESTAMP,
    weekday VARCHAR(255),
    group_name VARCHAR(255),
    amount FLOAT,
    distance FLOAT,
    is_exception BOOLEAN,
    repeat_count INTEGER
);


COMMIT;