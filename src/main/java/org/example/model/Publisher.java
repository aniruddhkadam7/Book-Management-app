package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.model.BaseEntity;
import org.example.model.Book;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher extends BaseEntity {

    @NotBlank
    @Size(max = 255)
    @Column(unique = true)
    private String name;

    @Embedded
    private Address address;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$")
    private String phone;

    @Column(unique = true)
    @Email
    private String contactEmail;

    @OneToMany(mappedBy = "publisher", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Book> publishedBooks = new HashSet<>();
}