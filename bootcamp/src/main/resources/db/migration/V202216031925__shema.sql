CREATE TABLE IF NOT EXISTS customer
(
    id    INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(20),
    name  VARCHAR(20),
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

COMMIT