create schema my_schema

    create table my_schema.metrics
    (
        id             bigserial,
        metric_name    varchar(100) not null,
        metric_value   varchar(100) not null,
        timestamp_date date         not null,
        primary key (id)
    );