package com.example.firstservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "organization_type", schema = "soa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String type;

    @OneToMany(mappedBy = "organizationType", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Organization> organizations;
}
