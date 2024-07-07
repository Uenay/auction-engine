Create table users
(
    id        serial PRIMARY KEY,
    login     VARCHAR UNIQUE,
    password  VARCHAR,
    full_name VARCHAR,
    balance   INT
);

Create table role
(
    id   serial PRIMARY KEY,
    name VARCHAR
);

Create table role_to_user
(
    id      serial PRIMARY KEY,
    user_id int references users (id),
    role_id int references role (id)
);

INSERT INTO role(name)
VALUES
    ('ADMIN'),
    ('AUCTIONEER'),
    ('USER');
