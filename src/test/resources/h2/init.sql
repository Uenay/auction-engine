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

Create table image
(
    id         serial PRIMARY KEY,
    name       VARCHAR,
    image_data varbinary(MAX)
);

Create table auction
(
    id              serial PRIMARY KEY,
    start_time      DATE,
    end_time        DATE,
    current_bet     int,
    current_user_id int references users (id)
);

Create table auction_lot
(
    id                 serial PRIMARY KEY,
    start_bet          int,
    name               VARCHAR,
    description        VARCHAR,
    created_by_user_id int references users (id),
    final_bet          int,
    purchaser_user_id  int references users (id),
    auction_id         int references auction (id),
    image_id           int references image (id)
);

