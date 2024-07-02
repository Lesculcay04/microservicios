CREATE TABLE IF NOT EXISTS grades(
    id SERIAL PRIMARY KEY,
    subject VARCHAR(255),
    note int,
    grade VARCHAR(255)
);