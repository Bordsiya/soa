package com.example.firstservice.entity;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    @SequenceGenerator(schema="soa", sequenceName = "soa.address_id_seq", allocationSize = 1, name = "address_id_seq")
    private int id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Organization> organizations;
}
