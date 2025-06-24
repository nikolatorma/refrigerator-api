CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    icon VARCHAR(255)
);

CREATE TABLE good (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    icon VARCHAR(255),
    category_id INT REFERENCES category(id)
);

CREATE TABLE app_user (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE fridge_item (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES app_user(id),
    good_id INT REFERENCES good(id),
    quantity INT NOT NULL,
    location VARCHAR(255),
    date_stored DATE,
    best_before_date DATE
);