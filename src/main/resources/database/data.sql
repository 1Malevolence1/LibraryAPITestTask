
INSERT INTO author (author_id, author_name, author_surname, author_date_of_birth) VALUES
    (1, 'Лев', 'Толстой', '1828-09-09'),
    (2, 'Фёдор', 'Достоевский', '1821-11-11'),
    (3, 'Антон', 'Чехов', '1860-01-29'),
    (4, 'Николай', 'Гоголь', '1809-03-31'),
    (5, 'Александр', 'Пушкин', '1799-06-06'),
    (6, 'Михаил', 'Лермонтов', '1814-10-15'),
    (7, 'Иван', 'Тургенев', '1818-11-09'),
    (8, 'Александр', 'Островский', '1823-04-12'),
    (9, 'Николай', 'Некрасов', '1821-12-10'),
    (10, 'Максим', 'Горький', '1868-03-28')
ON CONFLICT (author_id) DO NOTHING;


INSERT INTO book (book_id, book_name, publication_date) VALUES
    (1, 'Война и мир', '1869-01-01'),
    (2, 'Преступление и наказание', '1866-01-01'),
    (3, 'Вишнёвый сад', '1904-01-01'),
    (4, 'Мёртвые души', '1842-01-01'),
    (5, 'Евгений Онегин', '1833-01-01'),
    (6, 'Герой нашего времени', '1840-01-01'),
    (7, 'Отцы и дети', '1862-01-01'),
    (8, 'Гроза', '1860-01-01'),
    (9, 'Кому на Руси жить хорошо', '1877-01-01'),
    (10, 'На дне', '1902-01-01')
ON CONFLICT (book_id) DO NOTHING;


INSERT INTO author_book (author_id, book_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10)
ON CONFLICT (author_id, book_id) DO NOTHING;


INSERT INTO reader (reader_id, reader_phone, reader_name, reader_surname, reader_gender, reader_date_of_birth) VALUES
    (1, '1234567890', 'Иван', 'Иванов', 'M', '1990-05-15'),
    (2, '0987654321', 'Мария', 'Петрова', 'W', '1985-07-20'),
    (3, '1112223334', 'Алексей', 'Сидоров', 'M', '1995-02-10'),
    (4, '5556667778', 'Ольга', 'Иванова', 'W', '1988-09-25'),
    (5, '9998887776', 'Дмитрий', 'Козлов', 'M', '1992-12-05'),
    (6, '4443332221', 'Екатерина', 'Смирнова', 'W', '1980-03-30'),
    (7, '7778889990', 'Сергей', 'Васильев', 'M', '1975-07-15')
ON CONFLICT (reader_id) DO NOTHING;


INSERT INTO transactional (transactional_id, transactional_type_operation, reader_id, book_id) VALUES
    (1, 'TAKE', 1, 1),
    (2, 'TAKE', 2, 2),
    (3, 'RETURN', 1, 1),
    (4, 'TAKE', 3, 4),
    (5, 'TAKE', 4, 5),
    (6, 'TAKE', 5, 6),
    (7, 'RETURN', 3, 4),
    (8, 'TAKE', 6, 7),
    (9, 'TAKE', 7, 8),
    (10, 'RETURN', 5, 6),
    (11, 'TAKE', 3, 9),
    (12, 'TAKE', 4, 10),
    (13, 'RETURN', 6, 7)
ON CONFLICT (transactional_id) DO NOTHING;


INSERT INTO reader_books (reader_id, book_id) VALUES
    (1, 1),
    (2, 2),
    (3, 4),
    (4, 5),
    (5, 6),
    (6, 7),
    (7, 8),
    (3, 9),
    (4, 10)
ON CONFLICT (reader_id, book_id) DO NOTHING;


INSERT INTO employee (employee_id, employee_email, employee_password) VALUES
    (1, 'admin', crypt('admin', gen_salt('bf')))
ON CONFLICT (employee_id) DO NOTHING;


select setval('author_author_id_seq', (select max(author_id) from author));
select setval('book_book_id_seq', (select max(book_id) from book));
select setval('reader_reader_id_seq', (select max(reader_id) from reader));
select setval('transactional_transactional_id_seq', (select max(transactional_id) from transactional));
SELECT setval('employee_employee_id_seq', (SELECT MAX(employee_id) FROM public.employee));