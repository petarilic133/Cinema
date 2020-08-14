package com.example.cinema.entity;

import com.example.cinema.util.emums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
