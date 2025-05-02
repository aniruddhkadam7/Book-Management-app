package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.model.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books",
        indexes = {
                @Index(name = "idx_book_title", columnList = "title"),
                @Index(name = "idx_book_isbn", columnList = "isbn", unique = true) //dddddddd
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends BaseEntity {

    @NotBlank
    @Size(max = 1000)
    private String title;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @NotNull
    @Column(name = "publication_year")
    private Integer publicationYear;

    @NotBlank
    @Column(unique = true)
    @Size(min = 10, max = 13)
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @ManyToMany
    @JoinTable(name = "book_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookAuthor> authors = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();
}