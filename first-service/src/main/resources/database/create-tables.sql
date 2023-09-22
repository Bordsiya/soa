create table if not exists coordinates
(
    id      serial primary key,
    x       double precision not null,
    y       bigint not null
);

create table if not exists address
(
    id       serial primary key,
    street   text not null,
    zip_code text
);

create table if not exists organization_type
(
    id        serial primary key,
    type_name text not null unique
);

create table if not exists organization
(
    id serial primary key,
    name text not null,
    coordinates_id int not null
        references coordinates (id),
    creationDate timestamp not null default CURRENT_TIMESTAMP,
    annualTurnover double precision not null
        check (annualTurnover > 0),
    type_id int
        references organization_type (id),
    address_id int
        references address (id)
);

create table if not exists employee
(
    id serial primary key,
    first_name text not null,
    second_name text,
    salary int not null
        check ( salary >= 0 ),
    organization_id int not null
        references organization (id)
);




