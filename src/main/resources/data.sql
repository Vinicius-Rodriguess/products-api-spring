create table tb_product (
    id varchar(255) not null primary key,
    name varchar(500) not null,
    description varchar(300),
    price numeric(18, 2)
);