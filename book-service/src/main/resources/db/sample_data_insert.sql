INSERT INTO books (title, isbn, authors, publisher, publication_date, genre, description, no_of_books, created_at, updated_at)
VALUES
    ('The Great Gatsby', '9780743273565', 'F. Scott Fitzgerald', 'Scribner', '1925-04-10', 'Fiction', 'A novel set in the 1920s, following the life of Jay Gatsby.', 100, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('To Kill a Mockingbird', '9780061120084', 'Harper Lee', 'J.B. Lippincott & Co.', '1960-07-11', 'Fiction', 'A story about racial injustice in the Depression-era South.', 50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('1984', '9780451524935', 'George Orwell', 'Secker & Warburg', '1949-06-08', 'Dystopian', 'A novel about a totalitarian regime and the consequences of mass surveillance.', 200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('The Catcher in the Rye', '9780316769488', 'J.D. Salinger', 'Little, Brown and Company', '1951-07-16', 'Fiction', 'The story of a troubled teenager, Holden Caulfield.', 75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Moby-Dick', '9781503280786', 'Herman Melville', 'Harper & Brothers', '1851-10-18', 'Adventure', 'A novel about the journey of the whaling ship Pequod and its captain, Ahab, seeking revenge on the white whale Moby Dick.', 30, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
