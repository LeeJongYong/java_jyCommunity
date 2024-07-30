create table if not exists board
(
    id          bigint(20) primary key,
    subject     varchar(100),
    content     varchar(4000),
    userid      varchar(30),
    created_dt  DATETIME,
    updated_dt  DATETIME,
    index idx_id (id)
);