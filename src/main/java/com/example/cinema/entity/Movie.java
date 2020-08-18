package com.example.cinema.entity;

import com.example.cinema.util.emums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Column(nullable = false)
    private int duration; //in minutes

    @Enumerated(value = EnumType.STRING)
    private GenreType genreType;

    @Column(nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Projection> projections = new HashSet<>();
}
