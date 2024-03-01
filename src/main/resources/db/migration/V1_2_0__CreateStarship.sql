CREATE TABLE starship
(
    id                     INT,
    name                   VARCHAR(255) NOT NULL,
    model                  VARCHAR(255) NOT NULL,
    manufacturer           VARCHAR(255) NOT NULL,
    cost_in_credits        VARCHAR(255),
    length                 VARCHAR(255) NOT NULL,
    max_atmosphering_speed VARCHAR(255),
    crew                   VARCHAR(255) NOT NULL,
    passengers             VARCHAR(255) NOT NULL,
    cargo_capacity         VARCHAR(255),
    consumables            VARCHAR(255) NOT NULL,
    hyperdrive_rating      VARCHAR(255),
    mglt                   VARCHAR(255),
    starship_class         VARCHAR(255),
    created                TIMESTAMP    NOT NULL,
    edited                 TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
);
