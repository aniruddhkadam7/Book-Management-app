package org.example.repository;

import org.example.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.Optional;

/**
 * Base repository for all entities extending BaseEntity. mmmkkkk
 * Provides common soft-delete operations.
 *
 * @param <T>  Entity type (e.g., Author, Book)
 * @param <ID> Primary key type (Long in this case)
 */
@NoRepositoryBean // Prevents Spring from creating a bean for this interface directly
public interface BaseRepository<T extends BaseEntity, ID extends Long>
        extends JpaRepository<T, ID> {

    /**
     * Finds an entity by ID only if it's NOT marked as deleted.
     *
     * @param id Entity ID to search for
     * @return Optional containing the entity if found and not deleted
     */
    Optional<T> findByIdAndDeletedFalse(ID id);
}