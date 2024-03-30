
create table if not exists roles (
    id bigserial,
    name varchar(255),
    primary key (id)
);

create table if not exists users (
    id bigserial,
    username varchar(255),
    password varchar(255),
    role_id bigint references roles(id) on delete cascade,
    primary key (id)
);