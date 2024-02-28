CREATE TABLE if not exists users
(
    id         bigserial not null primary key,
    username   varchar(50),
    first_name varchar(50),
    last_name  varchar(50),
    email      varchar(100),
    password   varchar(250),
    role       varchar(50),
    created    timestamp without time zone default now(),
    updated    timestamp without time zone default now()
);

CREATE TABLE if not exists roles
(
    id      bigserial not null primary key,
    name    varchar(50),
    created timestamp without time zone default now(),
    updated timestamp without time zone default now()
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

