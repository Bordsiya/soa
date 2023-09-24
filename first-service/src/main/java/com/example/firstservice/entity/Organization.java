package com.example.firstservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "organization", schema = "soa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id")
    private Coordinates coordinates;

    @Column(name = "creationDate", nullable = false)
    private Timestamp creationDate;

    @PrePersist
    protected void onCreate() {
        creationDate = new Timestamp(new Date().getTime()); // Устанавливаем текущее время при создании сущности
    }

    @Min(0)
    @Column(name = "annualTurnover", nullable = false)
    private Double annualTurnover;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private OrganizationType organizationType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Employee> employees;

}
