alter table order_header
    modify column order_status enum ('NEW','IN_PROCESS','COMPLETE');
alter table product
    modify column product_status enum ('NEW','IN_STOCK','DISCOUNTED');