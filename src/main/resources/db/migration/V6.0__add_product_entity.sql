drop table if exists product cascade;

create table product
(
    id       bigint not null auto_increment primary key,
    description varchar(255),
    product_status enum ('new','in_stock','discounted'),
    created_date timestamp,
    last_modified_date timestamp
) engine = InnoDB;
