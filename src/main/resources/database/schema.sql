create table if not exists author (
    author_id bigserial primary key,
    author_name varchar(255) not null,
    author_surname varchar(255) not null,
    author_date_of_birth date
);

create table if not exists book (
    book_id bigserial primary key,
    book_name varchar(255) not null,
    publication_date date not null
);

create table if not exists author_book (
    author_id bigint references author(author_id) on delete cascade,
    book_id bigint references book(book_id) on delete cascade,
    primary key (author_id, book_id)
);

create table if not exists reader (
    reader_id bigserial primary key,
    reader_phone varchar(255) not null unique,
    reader_name varchar(255) not null,
    reader_surname varchar(255) not null,
    reader_gender varchar(1) not null check (reader_gender in ('M', 'W')),
    reader_date_of_birth date
);

create table if not exists transactional (
    transactional_id bigserial primary key,
    transactional_type_operation varchar(10) not null check (transactional_type_operation in ('TAKE', 'RETURN')),
    date_operation timestamp not null default current_timestamp,
    reader_id bigint references reader(reader_id) on delete cascade,
    book_id bigint references book(book_id) on delete cascade
);