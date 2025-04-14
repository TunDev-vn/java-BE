create database shop_book;
create table productDTOS
(
    id               int auto_increment
        primary key,
    book_title       varchar(255)   not null,
    author           varchar(255)   not null,
    page_count       int            not null,
    publisher        varchar(255)   not null,
    publication_year int            not null,
    genre            varchar(100)   not null,
    price            decimal(10, 2) not null,
    discount         decimal(10, 2) null,
    stock_quantity   int            not null,
    description      text           null,
    image            varchar(255)   null
);

INSERT INTO shop_book.productDTOS (id, book_title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, image) VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 180, 'Scribner', 1925, 'Classic', 10.99, 0.10, 100, 'A classic novel of the Jazz Age.', null);
INSERT INTO shop_book.productDTOS (id, book_title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, image) VALUES (2, 'To Kill a Mockingbird', 'Harper Lee', 281, 'J.B. Lippincott & Co.', 1960, 'Fiction', 7.99, 0.20, 150, 'A gripping novel of race and justice in the Depression-era South.', null);
INSERT INTO shop_book.productDTOS (id, book_title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, image) VALUES (3, '1984', 'George Orwell', 328, 'Secker & Warburg', 1949, 'Dystopian', 8.99, 0.15, 200, 'A novel about a dystopian future where Big Brother watches everyone.', null);
INSERT INTO shop_book.productDTOS (id, book_title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, image) VALUES (4, 'Pride and Prejudice', 'Jane Austen', 279, 'T. Egerton', 1813, 'Romance', 6.99, 0.05, 120, 'A novel of manners set in Regency-era England, focusing on the romantic tension between Elizabeth Bennet and Mr. Darcy.', null);
INSERT INTO shop_book.productDTOS (id, book_title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, image) VALUES (5, 'The Catcher in the Rye', 'J.D. Salinger', 214, 'Little, Brown and Company', 1951, 'Literary Fiction', 9.99, 0.10, 80, 'The story of a young man, Holden Caulfield, struggling with isolation and depression.', null);
