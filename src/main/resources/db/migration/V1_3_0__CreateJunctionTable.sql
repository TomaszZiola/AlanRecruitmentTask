CREATE TABLE person_starship
(
    person_id BIGINT,
    starship_id BIGINT,
    PRIMARY KEY (person_id, starship_id),
    FOREIGN KEY (person_id) REFERENCES person (id),
    FOREIGN KEY (starship_id) REFERENCES starship (id)
);
