
create  table if not exists colors (
    id bigserial,
    name varchar(255),
    primary key (id)
);

create table if not exists countries (
    id bigserial,
    name varchar(255),
    primary key (id)
);

create table if not exists manufacturers (
    id bigserial,
    name varchar(255),
    country_id bigint references countries (id) on delete cascade,
    primary key (id)
);

create table if not exists brands (
    id bigserial,
    name varchar(255),
    manufacturer_id bigint references manufacturers (id) on delete cascade,
    primary key (id)
);

create table if not exists beers (
    id bigserial,
    title varchar(255),
    alcohol_percentage varchar(255),
    volume varchar(255),
    color_id bigint references colors (id) on delete cascade,
    brand_id bigint references brands (id) on delete cascade,
    primary key (id)
);

create table if not exists comments (
    id bigserial,
    text varchar(255),
    beer_id bigint references beers (id) on delete cascade,
    primary key (id)
);