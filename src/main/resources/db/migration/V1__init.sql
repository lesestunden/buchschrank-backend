CREATE TABLE IF NOT EXISTS bookcase (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    streethousenumber VARCHAR(255),
    postcode VARCHAR(255),
    place VARCHAR(255),
    country VARCHAR(255),
    lat DOUBLE,
    lng DOUBLE,
    link VARCHAR(255),
    contact VARCHAR(255),
    opened VARCHAR(255),
    inserted DATETIME,
    lastupdate DATETIME);

CREATE INDEX IF NOT EXISTS latlng ON bookcase (lat, lng);