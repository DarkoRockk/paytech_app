CREATE TABLE users
(
    id       bigserial not null primary key,
    username varchar(500),
    created  timestamp without time zone default now(),
    updated  timestamp without time zone default now()
);

CREATE TABLE tx_payments
(
    id      bigserial                             not null primary key,
    user_id bigint                                not null references users,
    amount  numeric                     default 0 not null,
    status  varchar(50)                           not null,
    created timestamp without time zone default now(),
    updated timestamp without time zone default now()
);

