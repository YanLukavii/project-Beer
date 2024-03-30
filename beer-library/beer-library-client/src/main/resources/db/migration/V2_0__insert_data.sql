insert into roles(name)
values ('ADMIN'),  ('USER');

insert into users(username, password, role_id)
values ('usr', '$2a$12$p8HOkYJRZREUG.gesNBjl.dB98NULlw43HkfbZFOmzld106ov8Lj6', 2),
 ('adm', '$2a$12$p8HOkYJRZREUG.gesNBjl.dB98NULlw43HkfbZFOmzld106ov8Lj6', 1);