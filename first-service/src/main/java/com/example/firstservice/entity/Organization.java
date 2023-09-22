package com.example.firstservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "organization")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id", nullable = false)
    private Coordinates coordinates;

    @Column(name = "creationDate")
    private Timestamp creationDate;

    @PrePersist
    protected void onCreate() {
        creationDate = new Timestamp(new Date().getTime()); // Устанавливаем текущее время при создании сущности
    }

    @Min(0)
    @Column(name = "annualTurnover", nullable = false)
    private Double annualTurnover;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private OrganizationType organizationType;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
