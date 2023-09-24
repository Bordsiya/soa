package com.example.firstservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "address", schema = "soa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Organization> organizations;
}
