package org.example.repository;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Manages the join table between Book and Author with additional columns.
 */
public interface BookAuthorRepository extends BaseRepository<BookAuthor, Long> {

    /**
     * Finds all book involvements for an author.
     */
    List<BookAuthor> findByAuthor(Author author);

    /**
     * Finds all author involvements for a book.
     */
    List<BookAuthor> findByBook(Book book);

    /**
     * Finds all entries by role (e.g., "Editor").
     */
    List<BookAuthor> findByRole(String role);
}