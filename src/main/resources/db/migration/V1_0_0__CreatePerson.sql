CREATE TABLE person
(
    id         INT,
    name       VARCHAR(255) NOT NULL,
    height     VARCHAR(255) NOT NULL,
    mass       VARCHAR(255) NOT NULL,
    hair_color VARCHAR(255) NOT NULL,
    skin_color VARCHAR(255) NOT NULL,
    eye_color  VARCHAR(255) NOT NULL,
    birth_year VARCHAR(255) NOT NULL,
    gender     VARCHAR(255) NOT NULL,
    created    TIMESTAMP    NOT NULL,
    edited     TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
);
