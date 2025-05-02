package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.model.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres",
        uniqueConstraints = @UniqueConstraint(name = "uc_genre_name", columnNames = "name"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre extends BaseEntity {

    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_genre_id")
    private Genre parentGenre;

    @OneToMany(mappedBy = "parentGenre")
    private Set<Genre> subGenres = new HashSet<>();
}