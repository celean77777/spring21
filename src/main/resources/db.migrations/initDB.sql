
CREATE TABLE IF NOT EXISTS categories
(
    id    bigserial primary key,
    title varchar(255)
);




CREATE TABLE IF NOT EXISTS products
(
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigint references categories (id)
);



