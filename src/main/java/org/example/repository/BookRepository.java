package org.example.repository;

import org.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
 * Manages Book entity database operations.
 */
public interface BookRepository extends BaseRepository<Book, Long> {

    /**
     * Finds books by title (partial match, case-insensitive).
     * Example: "potter" matches "Harry Potter".
     */
    List<Book> findByTitleContainingIgnoreCase(String title);

    /**
     * Finds a book by ISBN (exact match).
     * Uses the unique ISBN constraint from the Book entity.
     */
    Optional<Book> findByIsbn(String isbn);

    /**
     * Finds books published in a specific year.
     */
    List<Book> findByPublicationYear(Integer year);

    /**
     * Custom query to find books by genre name.
     *
     * @param genreName Name of the genre (e.g., "Fantasy")
     * @return List of books in the specified genre
     */
    @Query("SELECT b FROM Book b JOIN b.genres g WHERE g.name = :genreName")
    List<Book> findBooksByGenreName(@Param("genreName") String genreName);
}