-- MySQL Initialization Script for Spring Boot Application

-- Create the 'author' table
CREATE TABLE IF NOT EXISTS `author` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Create the 'genre' table
CREATE TABLE IF NOT EXISTS `genre` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Create the 'tag' table
CREATE TABLE IF NOT EXISTS `tag` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Create the 'book' table with a foreign key to 'genre'
CREATE TABLE IF NOT EXISTS `book` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `author_id` BIGINT NOT NULL,
    `genre_id` BIGINT,
    `title` VARCHAR(255) NOT NULL,
    `year` INT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
    FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
);

-- Create the 'book_tag' join table for the many-to-many relationship
CREATE TABLE IF NOT EXISTS `book_tag` (
    `book_id` BIGINT NOT NULL,
    `tag_id` BIGINT NOT NULL,
    PRIMARY KEY (`book_id`, `tag_id`),
    FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
    FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
);

-- Insert dummy data into 'author'
INSERT INTO `author` (`name`) VALUES
('J.K. Rowling'),
('George Orwell'),
('Agatha Christie');

-- Insert dummy data into 'genre'
INSERT INTO `genre` (`name`) VALUES
('Fantasy'),
('Science Fiction'),
('Mystery');

-- Insert dummy data into 'tag'
INSERT INTO `tag` (`name`) VALUES
('Bestseller'),
('Classic'),
('Award Winning');

-- Insert dummy data into 'book'
INSERT INTO `book` (`author_id`, `title`, `year`, `genre_id`) VALUES
(1, 'Harry Potter and the Philosophers Stone', 1997, 1),
(1, 'Harry Potter and the Chamber of Secrets', 1998, 1),
(2, 'Nineteen Eighty-Four', 1949, 2),
(2, 'Animal Farm', 1945, 2),
(3, 'Murder on the Orient Express', 1934, 3),
(3, 'Death on the Nile', 1937, 3);

-- Insert dummy data into 'book_tag'
INSERT INTO `book_tag` (`book_id`, `tag_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 2),
(3, 3),
(4, 1),
(5, 2),
(6, 3),
(6, 1);

