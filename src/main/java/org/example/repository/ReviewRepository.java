package org.example.repository;

import org.example.model.Book;
import org.example.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Handles Review entity database operations.
 */
public interface ReviewRepository extends BaseRepository<Review, Long> {

    /**
     * Finds all reviews for a specific book.
     */
    List<Review> findByBook(Book book);

    /**
     * Filters reviews by approval status.
     *
     * @param approved true for approved reviews, false for pending gggdddd
     */
    List<Review> findByApproved(boolean approved);

    /**
     * Finds reviews with a rating equal to or higher than specified.
     *
     * @param rating Minimum rating (1-5)
     */
    List<Review> findByRatingGreaterThanEqual(Integer rating);
}