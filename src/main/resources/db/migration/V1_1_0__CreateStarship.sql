CREATE TABLE starship
(
    id                     INT,
    name                   VARCHAR(255) NOT NULL,
    model                  VARCHAR(255) NOT NULL,
    manufacturer           VARCHAR(255) NOT NULL,
    cost_in_credits        VARCHAR(255) NOT NULL,
    length                 VARCHAR(255) NOT NULL,
    max_atmosphering_speed VARCHAR(255) NOT NULL,
    crew                   VARCHAR(255) NOT NULL,
    passengers             VARCHAR(255) NOT NULL,
    cargo_capacity         VARCHAR(255) NOT NULL,
    consumables            VARCHAR(255) NOT NULL,
    hyperdrive_rating      VARCHAR(255) NOT NULL,
    mglt                   VARCHAR(255) NOT NULL,
    starship_class         VARCHAR(255) NOT NULL,
    created                TIMESTAMP    NOT NULL,
    edited                 TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
);
