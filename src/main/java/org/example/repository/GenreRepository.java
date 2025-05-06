package org.example.repository;

import org.example.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

/**
 * Manages Genre entity database operations.
 */
public interface GenreRepository extends BaseRepository<Genre, Long> {

    /**
     * Finds a genre by name (exact match).
     */
    Optional<Genre> findByName(String name);

    /**
     * Custom query to find subgenres of a parent genre.
     *
     * @param parentId ID of the parent genre
     * @return List of child genres
     */
    @Query("SELECT g FROM Genre g WHERE g.parentGenre.id = :parentId")
    List<Genre> findSubGenresByParentId(Long parentId);
}