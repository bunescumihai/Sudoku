create table maps(
    map_id serial primary key,
    map_row varchar(81) unique
);

create table users(
    user_id serial primary key,
    login varchar not null unique,
    password varchar not null
);

create table resolved_maps(
    user_id int not null,
    map_id int not null,
    constraint fk_user_id foreign key(user_id) references users(user_id),
    constraint fk_map_id foreign key(map_id) references maps(map_id)
);

create table saves(
    user_id int not null,
    map_id int not null,
    map_row varchar(81),
    constraint fk_user_id foreign key(user_id) references users(user_id),
    constraint fk_map_id foreign key(map_id) references maps(map_id)
);