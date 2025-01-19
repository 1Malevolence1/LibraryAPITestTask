insert into author (author_id, author_name, author_surname, author_date_of_birth) values
    (1, 'Лев', 'Толстой', '1828-09-09'),
    (2, 'Фёдор', 'Достоевский', '1821-11-11'),
    (3, 'Антон', 'Чехов', '1860-01-29')
on conflict (author_id) do nothing;

insert into book (book_id, book_name, publication_date) values
    (1, 'Война и мир', '1869-01-01'),
    (2, 'Преступление и наказание', '1866-01-01'),
    (3, 'Вишнёвый сад', '1904-01-01')
on conflict (book_id) do nothing;

insert into author_book (author_id, book_id) values
    (1, 1),
    (2, 2),
    (3, 3)
on conflict (author_id, book_id) do nothing;

insert into reader (reader_id, reader_phone, reader_name, reader_surname, reader_gender, reader_date_of_birth) values
    (1, '1234567890', 'Иван', 'Иванов', 'M', '1990-05-15'),
    (2, '0987654321', 'Мария', 'Петрова', 'W', '1985-07-20')
on conflict (reader_id) do nothing;

insert into transactional (transactional_id, transactional_type_operation, reader_id, book_id) values
    (1, 'TAKE', 1, 1),
    (2, 'TAKE', 2, 2),
    (3, 'RETURN', 1, 1)
on conflict (transactional_id) do nothing;


INSERT INTO employee (employee_id, employee_email, employee_password) VALUES
    (1, 'admin', crypt('admin', gen_salt('bf')))
ON CONFLICT (employee_id) DO NOTHING;


select setval('author_author_id_seq', (select max(author_id) from author));
select setval('book_book_id_seq', (select max(book_id) from book));
select setval('reader_reader_id_seq', (select max(reader_id) from reader));
select setval('transactional_transactional_id_seq', (select max(transactional_id) from transactional));
SELECT setval('employee_employee_id_seq', (SELECT MAX(employee_id) FROM public.employee));