CREATE TABLE csv_file (
                          id SERIAL PRIMARY KEY,
                          file_name VARCHAR(255) NOT NULL,
                          content TEXT NOT NULL,
                          created_at TIMESTAMP NOT NULL
);