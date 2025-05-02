package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.model.Author;
import org.example.model.BaseEntity;
import org.example.model.Book;

@Entity
@Table(name = "book_authors",
        uniqueConstraints = @UniqueConstraint(
                name = "uc_book_author",
                columnNames = {"book_id", "author_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAuthor extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(name = "contribution_order")
    private Integer contributionOrder;

    @Column(name = "role")
    private String role; // e.g., "Primary Author", "Co-Author", "Editor"
}