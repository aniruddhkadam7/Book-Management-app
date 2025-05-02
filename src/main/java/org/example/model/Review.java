package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import org.example.model.Book;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @NotBlank
    @Size(max = 1000)
    private String content;

    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank
    @Size(max = 255)
    @Column(name = "reviewer_name")
    private String reviewerName;

    @Email
    @Column(name = "reviewer_email")
    private String reviewerEmail;

    @Column(name = "approved", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean approved;
}