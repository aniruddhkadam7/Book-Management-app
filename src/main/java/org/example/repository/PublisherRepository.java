package org.example.repository;

import org.example.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

/**
 * Handles database operations for Publisher entities.
 */
public interface PublisherRepository extends BaseRepository<Publisher, Long> {

    /**
     * Finds a publisher by name (exact match).
     */
    Optional<Publisher> findByName(String name);

    /**
     * Finds a publisher by contact email (exact match).
     */
    Optional<Publisher> findByContactEmail(String email);

    /**
     * Custom query to find publishers in a specific city.
     * Uses the embedded Address object within Publisher.
     *
     * @param City name (e.g., "New York")
     */
    @Query("SELECT p FROM Publisher p WHERE p.address.city = :city")
    List<Publisher> findPublishersByCity(@Param("city") String city);
}