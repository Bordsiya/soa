package com.example.firstservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "coordinates")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coordinates {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordinates_id_seq")
    @SequenceGenerator(sequenceName = "coordinates_id_seq", allocationSize = 1, name = "coordinates_id_seq")
    private int id;

    @Column(name = "x", nullable = false)
    private Double x;

    @Column(name = "y", nullable = false)
    private Long y;

    @OneToOne(mappedBy = "coordinates", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Organization organization;
}
