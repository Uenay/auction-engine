DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS role_to_user;
DROP TABLE IF EXISTS image;
DROP TABLE IF EXISTS auction;
DROP TABLE IF EXISTS auction_lot;

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

Create table image
(
    id         serial PRIMARY KEY,
    name       VARCHAR,
    image_data bytea
);

Create table auction
(
    id              serial PRIMARY KEY,
    start_time      DATE,
    end_time        DATE,
    current_bet     INT,
    current_user_id bigserial references users (id)
);

Create table auction_lot
(
    id                 serial PRIMARY KEY,
    start_bet          INT,
    name               VARCHAR,
    description        VARCHAR,
    created_by_user_id serial references users (id),
    final_bet          INT,
    purchaser_user_id  serial references users (id),
    auction_id         serial references auction (id),
    image_id           serial references image (id)
);

INSERT INTO role(name)
VALUES
    ('ADMIN'),
    ('AUCTIONEER'),
    ('USER');

INSERT INTO users(login, password, full_name, balance)
VALUES ('vasya1', 'fpfp1111', 'Vasya Oblomow', 20),
       ('sashaa', 'qwerty123', 'Sasha Ivanova', 3),
       ('dash', 'rrrrr323232', 'Dasha Evdokimova', 1);



