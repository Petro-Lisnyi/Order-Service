create table customer
(
    id                 bigint not null auto_increment primary key,
    customer_name      varchar(50),
    address            varchar(30),
    city               varchar(30),
    state              varchar(30),
    zip_code           varchar(30),
    phone              varchar(20),
    email              varchar(255),
    created_date       timestamp,
    last_modified_date timestamp
);

alter table order_header
    add column customer_id bigint;
alter table order_header
    add constraint order_customer_fk
        foreign key (customer_id) references customer (id);
alter table order_header
    drop column customer;

insert into customer(customer_name, address, city, state, zip_code,
                     phone, email, created_date, last_modified_date)
    value ('First Customer', 'Great street, 88/2', 'NY', 'USA', '12345',
           '00564321', 'first@email.com', now(), now());

insert into order_header (order_header.customer_id)
select c.id
from customer c
where c.customer_name = 'First Customer';